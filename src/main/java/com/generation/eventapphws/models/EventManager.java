/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Me
 */
public class EventManager {
    
    EntityManager eManager;
    private final String PERSISTENCE_UNIT_NAME = "eventAppWS";
    
    public void consultarRecientes(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        eManager = emf.createEntityManager();
        Evento[] eventos = new Evento[9];
        
        
    }
    
}
