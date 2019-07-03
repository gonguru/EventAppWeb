/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.test;

import com.generation.eventapphws.models.Persona;
import com.generation.eventapphws.models.Usuario;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Me
 */
public class TestInserUsuario {
    
    private final String PERSISTENCE_UNIT_NAME = "eventAppWS";
    EntityManager eManager;
    
    
    @Test
    public void insertUsuario(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        assertNotNull(emf);
        System.out.println("emf Creado");
        eManager = emf.createEntityManager();
        assertNotNull(eManager);
        System.out.println("em creado");
        
        eManager.getTransaction().begin();
        
        /*Persona persona = new Persona();
        persona.setNombre("Carlo");
        persona.setApellidoP("Mango");
        persona.setApellidoM("Mangazo");
        persona.setFechaNac(new Date());
        persona.setGenero('H');*/
        
        Persona persona = eManager.find(Persona.class, 1);
        
        //eManager.persist(persona);
        
        Usuario usuario = new Usuario();
        usuario.setIdPersona(persona.getIdPersona());
        usuario.setContrasenya("Und3rground");
        usuario.setCorreo("omg_@live.com.mx");
        usuario.setDescripcion("Soy una persona para compartir viajes con compañeros nuevos");
        usuario.setNickname("BGongora");
        
        eManager.persist(usuario);
        eManager.getTransaction().commit();
        
        
        
        
    }
    
}
