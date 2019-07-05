/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.services;

import com.generation.eventapphws.models.Respuesta;
import com.generation.eventapphws.models.Usuario;
import com.google.gson.Gson;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Me
 */
@Path("usuario")
public class UsuarioWS {
    
    private static final String PERSISTENCE_UNIT_NAME ="eventAppWS";
    EntityManager eManager;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarSesion(String json){
        
        Respuesta res;
        Gson gson = new Gson();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        eManager = emf.createEntityManager();
        
        try {
        Usuario user = gson.fromJson(json, Usuario.class);
        System.out.println(user);
        
        
        Query query = eManager.createQuery("SELECT u FROM  Usuario u WHERE u.correo=:correo AND u.contrasenya=:contraseña");
        user = (Usuario)query.setParameter("correo", user.getCorreo())
                .setParameter("contraseña", user.getContrasenya())
                .getSingleResult();
        
        
        if(user != null){
            res = new Respuesta(1, "True");
            return Response.ok().entity(res).build();
        }
        } catch (Exception e) {
            e.printStackTrace();
            res = new Respuesta(0, "False");
            return Response.status(Response.Status.NOT_FOUND).entity(res).build();
        }
    return null;
    }
}
