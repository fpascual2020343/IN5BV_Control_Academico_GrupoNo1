/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupono1.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.util.List;
import com.grupono1.models.dao.SalonDaoImpl;
import com.grupono1.models.domain.Salon;
import java.io.IOException;
/**
 *
 * @author Dylan
 * @codigo Tecnico: 2020235
 * @data 2/09/2021
 * @time 02:56:55 PM
 */

@WebServlet("/ServletSalon")
public class ServletSalon extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarSalones(request, response);
                    break;
                case "editar":
                    break;
                case "eliminar":
                    eliminarSalones(request, response);
                    break;
            }
        }
    }

private void eliminarSalones (HttpServletRequest request, HttpServletResponse response) throws IOException{
    //Recuperar id Estudiante
    int salon_id = Integer.parseInt(request.getParameter("salon_id"));
    //Crear objeto Estudiante
    Salon salon = new Salon(salon_id);
    //llamar metodo eliminar DaoImpl
    int registrosEliminados = new SalonDaoImpl().eliminar(salon);
    System.out.println("Cantidad de registros Elminados: "+ registrosEliminados);
    //volver a cargar estudiantes
    listarSalones(request, response);
}
        
private void listarSalones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Salon> listaSalon = new SalonDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoSalon", listaSalon);
        response.sendRedirect("salones/listarSalones.jsp");

    }

}
