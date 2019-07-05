/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.services;

import com.generation.eventapphws.models.Evento;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eventosRecientes(){
        
        List<Evento> eventos = new ArrayList<>();
        return null;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarEstados(String json){
        Gson gson = new Gson();
        return null;
    }
}
