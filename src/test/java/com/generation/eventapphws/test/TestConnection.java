/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Me
 */
public class TestConnection {
    
    
    private final String PERSISTENCE_UNIT_NAME = "eventAppWS";
    EntityManager entityManager;
    
    
    //@Test
    public void pruebaConnection(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        assertNotNull(emf);
        System.out.println("Se creo emf");
        entityManager = emf.createEntityManager();
        assertNotNull(entityManager);
        System.out.println("Se creo entityManager");
        
        entityManager.close();
        assertFalse(entityManager.isOpen());
        System.out.println("Se cerro la conexión con entityManager");
        emf.close();
        assertFalse(emf.isOpen());
        System.out.println("Se cerro la conexión con EntityManagerFactory");
    }
    
}
