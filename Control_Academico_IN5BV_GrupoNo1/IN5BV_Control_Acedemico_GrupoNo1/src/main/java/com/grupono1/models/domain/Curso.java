/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupono1.models.domain;

/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 07:23:51 PM
 * @date 30/08/2021
 * Codigo Tecnico: IN5BV
 * Carne: 2020343
 * Jornada: Vespertina
 */
public class Curso {
    
    private int curso_id;
    private int ciclo;
    private int cupo_maximo;
    private int cupo_minimo;
    private String descripcion;
    private int id_horario;
    private int id_salon;
    private String id_codigo_carrera;
    private int id_instructor;

    public Curso() {
    }

    public Curso(int curso_id) {
        this.curso_id = curso_id;
    }

    public Curso(int ciclo, int cupo_maximo, int cupo_minimo, String descripcion, int id_horario, int id_salon, String id_codigo_carrera, int id_instructor) {
        this.ciclo = ciclo;
        this.cupo_maximo = cupo_maximo;
        this.cupo_minimo = cupo_minimo;
        this.descripcion = descripcion;
        this.id_horario = id_horario;
        this.id_salon = id_salon;
        this.id_codigo_carrera = id_codigo_carrera;
        this.id_instructor = id_instructor;
    }
    

    public Curso(int curso_id, int ciclo, int cupo_maximo, int cupo_minimo, String descripcion, int id_horario, int id_salon, String id_codigo_carrera, int id_instructor) {
        this.curso_id = curso_id;
        this.ciclo = ciclo;
        this.cupo_maximo = cupo_maximo;
        this.cupo_minimo = cupo_minimo;
        this.descripcion = descripcion;
        this.id_horario = id_horario;
        this.id_salon = id_salon;
        this.id_codigo_carrera = id_codigo_carrera;
        this.id_instructor = id_instructor;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getCupo_maximo() {
        return cupo_maximo;
    }

    public void setCupo_maximo(int cupo_maximo) {
        this.cupo_maximo = cupo_maximo;
    }

    public int getCupo_minimo() {
        return cupo_minimo;
    }

    public void setCupo_minimo(int cupo_minimo) {
        this.cupo_minimo = cupo_minimo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public int getId_salon() {
        return id_salon;
    }

    public void setId_salon(int id_salon) {
        this.id_salon = id_salon;
    }

    public String getId_codigo_carrera() {
        return id_codigo_carrera;
    }

    public void setId_codigo_carrera(String id_codigo_carrera) {
        this.id_codigo_carrera = id_codigo_carrera;
    }

    public int getId_instructor() {
        return id_instructor;
    }

    public void setId_instructor(int id_instructor) {
        this.id_instructor = id_instructor;
    }

    @Override
    public String toString() {
        return "Curso{" + "curso_id=" + curso_id + ", ciclo=" + ciclo + ", cupo_maximo=" + cupo_maximo + ", cupo_minimo=" + cupo_minimo + ", descripcion=" + descripcion + ", id_horario=" + id_horario + ", id_salon=" + id_salon + ", id_codigo_carrera=" + id_codigo_carrera + ", id_instructor=" + id_instructor + '}';
    }  
}
