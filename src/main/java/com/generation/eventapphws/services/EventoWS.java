/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.services;

import com.generation.eventapphws.models.Evento;
import com.generation.eventapphws.models.Respuesta;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Path("evento")
public class EventoWS {
    
    public static final String PERSISTENCE_UNIT_NAME = "eventAppWS";
    EntityManager eManager;
    
    @GET
    @Path("principal")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eventosRecientes(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        eManager = emf.createEntityManager();
        
        List<Evento> eventos = new ArrayList<>();
        Respuesta res = new Respuesta();
        Gson gson = new Gson();
        
        eManager.getTransaction().begin();
        eventos = eManager.createQuery("SELECT e FROM Evento e").getResultList();
        
        return Response.ok().entity(eventos).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarEstados(String json){
        Gson gson = new Gson();
        return null;
    }
}
