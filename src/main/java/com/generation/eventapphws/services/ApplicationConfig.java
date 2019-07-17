package com.generation.eventapphws.services;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class ApplicationConfig extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
    
    
    
}
