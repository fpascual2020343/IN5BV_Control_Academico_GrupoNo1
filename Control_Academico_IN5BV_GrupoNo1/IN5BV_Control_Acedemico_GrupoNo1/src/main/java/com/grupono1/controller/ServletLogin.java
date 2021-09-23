/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.controller;

import com.grupono1.models.dao.LoginDaoImpl;
import com.grupono1.models.domain.Usuario;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 03:51:57 PM
 * @date 22/09/2021 Codigo Tecnico: IN5BV Carne: 2020343 Jornada: Vespertina
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

    LoginDaoImpl login = new LoginDaoImpl();
    Usuario us = new Usuario();

    int respuesta;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("action");

        if (accion.equals("Ingresar")) {
            String user = request.getParameter("txtUser");
            String pass = request.getParameter("txtPass");
            us.setUser(user);
            us.setPass(pass);
            respuesta = login.buscar(us);
            if (respuesta == 1) {
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
