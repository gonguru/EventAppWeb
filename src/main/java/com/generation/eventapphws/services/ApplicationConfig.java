/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.services;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

/**
 *
 * @author Me
 */
@ApplicationPath("api")
public class ApplicationConfig extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
    
    
    
}
