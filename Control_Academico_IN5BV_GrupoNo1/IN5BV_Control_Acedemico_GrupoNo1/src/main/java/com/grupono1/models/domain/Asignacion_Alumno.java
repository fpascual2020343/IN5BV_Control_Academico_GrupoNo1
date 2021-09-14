/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupono1.models.domain;
import java.sql.Timestamp;
/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 07:27:17 PM
 * @date 30/08/2021
 * Codigo Tecnico: IN5BV
 * Carne: 2020343
 * Jornada: Vespertina
 */
public class Asignacion_Alumno {
    
    private String asignacion_id;
    private String carne_alumno;
    private int id_curso;
    private Timestamp fecha_asignacion;

    public Asignacion_Alumno() {
    }

    public Asignacion_Alumno(String asignacion_id) {
        this.asignacion_id = asignacion_id;
    }

    public Asignacion_Alumno(String asignacion_id, String carne_alumno, int id_curso, Timestamp fecha_asignacion) {
        this.asignacion_id = asignacion_id;
        this.carne_alumno = carne_alumno;
        this.id_curso = id_curso;
        this.fecha_asignacion = fecha_asignacion;
    }

    public Asignacion_Alumno(String carne_alumno, int id_curso, Timestamp fecha_asignacion) {
        this.carne_alumno = carne_alumno;
        this.id_curso = id_curso;
        this.fecha_asignacion = fecha_asignacion;
    }

    public String getAsignacion_id() {
        return asignacion_id;
    }

    public void setAsignacion_id(String asignacion_id) {
        this.asignacion_id = asignacion_id;
    }

    public String getCarne_alumno() {
        return carne_alumno;
    }

    public void setCarne_alumno(String carne_alumno) {
        this.carne_alumno = carne_alumno;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public Timestamp getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(Timestamp fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    @Override
    public String toString() {
        return "Asignacion_Alumno{" + "asignacion_id=" + asignacion_id + ", carne_alumno=" + carne_alumno + ", id_curso=" + id_curso + ", fecha_asignacion=" + fecha_asignacion + '}';
    }    

}
