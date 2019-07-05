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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Me
 */
@Path("usuario")
public class UsuarioWs {
    
    public static final String PERSISTENCE_UNIT_NAME = "eventAppWS";
    EntityManager eManager;
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validarUsuario(String json){
        
        Gson gson = new Gson();
        Usuario user = gson.fromJson(json, Usuario.class);
        Respuesta res;
        
        Query query = eManager.createQuery("SELECT u FROM Usuario u WHERE u.correo=:correo AND contrasenya=:contraseña");
        Usuario u = (Usuario) query.setParameter("correo", user.getCorreo()).setParameter("contraseña", user.getContrasenya()).getSingleResult();
        res = new Respuesta("True", 1);
        return Response.ok().entity(res).build();
    }
}
