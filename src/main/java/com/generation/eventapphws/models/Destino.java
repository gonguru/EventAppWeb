/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Me
 */
@Entity
@Table(name="destino", schema="eventApp")
public class Destino {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idDestino;
    private String ciudad;
    private String estado;
    private String nombreCede;
    private short activo = 1;
    
    public Destino(){}

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCede() {
        return nombreCede;
    }

    public void setNombreCede(String nombreCede) {
        this.nombreCede = nombreCede;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }
    
    
    
}
