/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupono1.models.domain;

/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 07:08:41 PM
 * @date 30/08/2021
 * Codigo Tecnico: IN5BV
 * Carne: 2020343
 * Jornada: Vespertina
 */
public class CarreraTecnica {
    
    private String codigo_carrera;
    private String nombre;

    public CarreraTecnica() {
    }

    public CarreraTecnica(String codigo_carrera, String nombre) {
        this.codigo_carrera = codigo_carrera;
        this.nombre = nombre;
    }

    public String getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CarreraTecnica{" + "codigo_carrera=" + codigo_carrera + ", nombre=" + nombre + '}';
    }
    
    
}
