/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.models.domain;

/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 10:32:24 PM
 * @date 15/09/2021 Codigo Tecnico: IN5BV Carne: 2020343 Jornada: Vespertina
 */
public class Usuario {

    private String user;
    private String pass;

    public Usuario() {
    }

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
