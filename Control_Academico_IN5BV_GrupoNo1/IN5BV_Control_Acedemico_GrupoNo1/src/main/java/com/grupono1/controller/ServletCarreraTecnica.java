/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.controller;

import com.grupono1.models.dao.CarreraTecnicaDaoImpl;
import com.grupono1.models.domain.CarreraTecnica;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro Alexander Lancerio Alvarado Código Técnico: 2020255
 * @date 1/09/2021
 * @time 09:20:11 PM
 */
@WebServlet("/ServletCarreraTecnica")
public class ServletCarreraTecnica extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "listar":
                    listarCarreraTecnica(request, response);
                    break;
                case "editar":
                    //
                    break;
                case "eliminar":
                    eliminarCarrera(request, response);
                    break;
            }

        }
    }

    private void listarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<CarreraTecnica> listarCarreraTecnica = new CarreraTecnicaDaoImpl().listarCarrera();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCarreraTecnica", listarCarreraTecnica);
        response.sendRedirect("listar/listarCarrera.jsp");

    }

    private void eliminarCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int codigo_carrera = Integer.parseInt(request.getParameter("codigo_carrera"));
        CarreraTecnica carrera = new CarreraTecnica(codigo_carrera);
        int registrosEliminados = new CarreraTecnicaDaoImpl().eliminar(carrera);

        System.out.println();
        listarCarreraTecnica(request, response);
    }

}
