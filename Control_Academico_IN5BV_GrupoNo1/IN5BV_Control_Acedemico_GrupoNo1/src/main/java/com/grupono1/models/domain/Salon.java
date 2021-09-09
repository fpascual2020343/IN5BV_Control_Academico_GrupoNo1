/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupono1.models.domain;

/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 07:06:01 PM
 * @date 30/08/2021
 * Codigo Tecnico: IN5BV
 * Carne: 2020343
 * Jornada: Vespertina
 */
public class Salon {
    
    private int salon_id;
    private int capacidad;
    private String descripcion;
    private String nombre_salon;

    public Salon() {
    }

    public Salon(int salon_id, int capacidad, String descripcion, String nombre_salon) {
        this.salon_id = salon_id;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.nombre_salon = nombre_salon;
    }

    public Salon(int capacidad, String descripcion, String nombre_salon) {
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.nombre_salon = nombre_salon;
    }

    public Salon(int salon_id) {
        this.salon_id = salon_id;
    }
    
    

    public int getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(int salon_id) {
        this.salon_id = salon_id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_salon() {
        return nombre_salon;
    }

    public void setNombre_salon(String nombre_salon) {
        this.nombre_salon = nombre_salon;
    }

    @Override
    public String toString() {
        return "Salon{" + "salon_id=" + salon_id + ", capacidad=" + capacidad + ", descripcion=" + descripcion + ", nombre_salon=" + nombre_salon + '}';
    }

}
