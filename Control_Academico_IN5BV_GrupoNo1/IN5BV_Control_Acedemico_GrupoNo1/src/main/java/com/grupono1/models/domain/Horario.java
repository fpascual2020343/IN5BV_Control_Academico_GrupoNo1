/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupono1.models.domain;
import java.sql.Time;

/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 07:01:11 PM
 * @date 30/08/2021
 * Codigo Tecnico: IN5BV
 * Carne: 2020343
 * Jornada: Vespertina
 */
public class Horario {
    
    private int horario_id;
    private Time horario_final;
    private Time horario_inicio;

    public Horario() {
    }

    public Horario(int horario_id, Time horario_final, Time horario_inicio) {
        this.horario_id = horario_id;
        this.horario_final = horario_final;
        this.horario_inicio = horario_inicio;
    }

    public Horario(Time horario_final, Time horario_inicio) {
        this.horario_final = horario_final;
        this.horario_inicio = horario_inicio;
    }

    public Horario(int horario_id) {
        this.horario_id = horario_id;
    }

    
    
    public int getHorario_id() {
        return horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }

    public Time getHorario_final() {
        return horario_final;
    }

    public void setHorario_final(Time horario_final) {
        this.horario_final = horario_final;
    }

    public Time getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(Time horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    @Override
    public String toString() {
        return "Horario{" + "horario_id=" + horario_id + ", horario_final=" + horario_final + ", horario_inicio=" + horario_inicio + '}';
    }

}
