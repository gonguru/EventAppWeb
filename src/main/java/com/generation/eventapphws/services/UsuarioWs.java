package com.generation.eventapphws.services;

import com.generation.eventapphws.models.ObjetoRegistro;
import com.generation.eventapphws.models.Perfil;
import com.generation.eventapphws.models.Persona;
import com.generation.eventapphws.models.Respuesta;
import com.generation.eventapphws.models.Usuario;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("usuario")
public class UsuarioWs {
    
    public static final String PERSISTENCE_UNIT_NAME = "eventAppWS";
    EntityManager eManager;
  
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validarUsuario(String json){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        eManager = emf.createEntityManager();
        Gson gson = new Gson();
        Respuesta res = new Respuesta();
        try{
        Usuario user = gson.fromJson(json, Usuario.class);
        
        
        Usuario validateUser = (Usuario)eManager.createQuery("SELECT u FROM Usuario u WHERE u.correo=:correo AND u.contrasenya=:contraseña")
                .setParameter("correo", user.getCorreo())
                .setParameter("contraseña", user.getContrasenya())
                .getSingleResult();
        
        Persona person = eManager.find(Persona.class,validateUser.getIdUsuario());
        
        res.setMensaje(person.getNombre());
        
        }catch(Exception e){
            res.setCodigo(0);
            res.setMensaje("Correo/Contraseña incorrectos");
            return Response.status(Response.Status.NOT_FOUND).entity(res).build();
        }finally{
            if(emf.isOpen()){
                emf.close();
                eManager.close();
            }
        }
        res.setCodigo(1);
        return Response.ok().entity(res).build();
    }
    
    @POST
    @Path("registrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(String json){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        eManager = emf.createEntityManager();
    
        Gson gson = new Gson();
        Respuesta res = null;
        ObjetoRegistro reg = gson.fromJson(json, ObjetoRegistro.class);
        Persona person = null;
        Usuario user = null;
        
        try{
            eManager.getTransaction().begin();
            
            person = new Persona();
            person.setNombre(reg.getNombre());
            person.setApellidoP(reg.getApellidoP());
            person.setApellidoM(reg.getApellidoM());
            person.setFechaNac(reg.getFechaNac());
            person.setGenero(reg.getGenero());
            person.setFechaRegistro(new Date());
            
            eManager.persist(person);
            
            user = new Usuario();
            user.setIdPersona(person.getIdPersona());
            user.setCorreo(reg.getCorreo());
            user.setContrasenya(reg.getContrasenya());
            
            eManager.persist(user);
            
            eManager.getTransaction().commit();
        
        }catch(Exception e){
            e.printStackTrace();
            eManager.getTransaction().rollback();
            res = new Respuesta(0,"Este correo ya está registrado");
            return Response.status(Response.Status.NOT_FOUND).entity(res).build();
        }finally{
            if(emf.isOpen()){
                emf.close();
                eManager.close();
            }
        }
        res = new Respuesta(1,"Usuario registrado");
        return Response.ok().entity(res).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPerfil(@PathParam("id")int id){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        eManager = emf.createEntityManager();
    
        Gson gson = new Gson();
        
        Respuesta res = null;
        Perfil perfil = new Perfil();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        
        try{
            eManager.getTransaction().begin();
            Usuario user = eManager.find(Usuario.class, id);
            Persona person = eManager.find(Persona.class, user.getIdPersona());
            
            perfil.setNombre(person.getNombre() + " " +
                             person.getApellidoP());
            perfil.setDescripcion(user.getDescripcion());
            perfil.setIdUsuario(id);
            if(person.getGenero() == 'M'){
                perfil.setGenero("Mujer");
            }else if(person.getGenero() == 'H'){
                perfil.setGenero("Hombre");
            }else{
                perfil.setGenero("Otro");
            }
            perfil.setFechaRegistro(sdf.format(person.getFechaRegistro()));
        }catch(Exception e){
            e.printStackTrace();
            res = new Respuesta(0, "No se encontró");
            return Response.status(Response.Status.NOT_FOUND).entity(res).build();
        }finally{
            if(emf.isOpen()){
                emf.close();
                eManager.close();
            }
        }
        return Response.ok().entity(perfil).build();
    }
}
