package com.generation.eventapphws.test;

import com.generation.eventapphws.models.Persona;
import com.generation.eventapphws.models.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class TestLoginUsuario {

    private final String PERSISTENCE_UNIT_NAME = "eventAppWS";
    EntityManager eManager;

    //@Test
    public void loginUsuario() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        assertNotNull(emf);
        System.out.println("emf Creado");
        eManager = emf.createEntityManager();
        assertNotNull(eManager);
        System.out.println("em creado");
        
        String correo = "omg_@live.com.mx";
        String password = "Und3rground";
        
        Query queryUsuario = eManager.createQuery("SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasenya = :contraseña");
        Usuario usuario = (Usuario)queryUsuario.setParameter("correo", correo)
                .setParameter("contraseña", password)
                .getSingleResult();
        
        if(usuario != null){
            Persona persona = eManager.find(Persona.class, usuario.getIdPersona());
            String nombre = persona.getNombre() + " " + persona.getApellidoP() + " " + persona.getApellidoM();
            System.out.println("Bienvenido: " + nombre);
            System.out.println("Tu fecha de nacimiento: " + persona.getFechaNac());
            String genero = persona.getGenero() == 'H'?"Hombre":"Mujer";
            System.out.println("Genero: " + genero);
        }else{
            System.out.println("Usuario y/o contraseña no validos");
        }
    }

}
