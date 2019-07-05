/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.models;

/**
 *
 * @author Me
 */
public class Respuesta {
    
    private int codigo;
    private String mensaje;
    
    public Respuesta(int codigo,String mensaje){
        this.mensaje = mensaje;
        this.codigo = codigo;
    }
    
    public Respuesta(){
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "{\"codigo\":\"" + codigo + "\",\"mensaje\":\"" + mensaje + "\"}";
    }
}
