/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.eventapphws.models;

import java.util.Date;
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
@Table(name="viaje",schema="eventApp")
public class Viaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idViaje;
    private short minimoAs;
    private short maximoAs;
    private Date fechaViaje;
    private Date fechaDead;
    private String descripcion;
    private float precio;
    private Date fechaRegistro;
    private short activo = 1;
    private int idDestino;
    private int idPartida;
    private int idEvento;
    private int idUsuario;
    
    public Viaje(){}

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public short getMinimoAs() {
        return minimoAs;
    }

    public void setMinimoAs(short minimoAs) {
        this.minimoAs = minimoAs;
    }

    public short getMaximoAs() {
        return maximoAs;
    }

    public void setMaximoAs(short maximoAs) {
        this.maximoAs = maximoAs;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public Date getFechaDead() {
        return fechaDead;
    }

    public void setFechaDead(Date fechaDead) {
        this.fechaDead = fechaDead;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    
    
    
}
