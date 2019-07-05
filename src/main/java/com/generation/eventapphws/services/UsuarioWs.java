/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.services;

import com.generation.eventapphws.models.Usuario;
import com.google.gson.Gson;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginUsuario(String json){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        eManager = emf.createEntityManager();
        
        Gson gson = new Gson();
        Usuario user;
        
        user = gson.fromJson(json, Usuario.class);
        System.out.println(user);
        
        
        
        
        
        
        return Response.ok().entity(user).build();
    }
}
