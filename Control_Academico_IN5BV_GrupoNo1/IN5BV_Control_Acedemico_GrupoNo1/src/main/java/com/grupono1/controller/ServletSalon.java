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
public class ServletSalon extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("\ndoPost");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarSalon(request, response);
                    break;
                case "actualizar":
                    actualizarSalon(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");
        request.setCharacterEncoding("UTF-8");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarSalones(request, response);
                    break;
                case "editar":
                    editarSalon(request, response);
                    break;
                case "eliminar":
                    eliminarSalones(request, response);
                    break;
            }
        }
    }

    private void actualizarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int salon_id = Integer.parseInt(request.getParameter("salon_id"));
        String nombre_salon = request.getParameter("nombre_salon");
        String descripcion = request.getParameter("descripcion");
        String capacidadStr = request.getParameter("capacidad");

        int capacidad = 0;
        if ((capacidadStr != null) && (!capacidadStr.equals(""))) {
            capacidad = Integer.parseInt(capacidadStr);
        }

        Salon salon = new Salon(salon_id, capacidad, nombre_salon, descripcion);

        int registrosActualizados = new SalonDaoImpl().actualizar(salon);
        System.out.println("Registros actualizados: " + registrosActualizados);

        listarSalones(request, response);
    }

    private void insertarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("\ninsertarSalon");

        String nombre_salon = request.getParameter("nombre_salon");
        String descripcion = request.getParameter("descripcion");
        String capacidadStr = request.getParameter("capacidad");

        int capacidad = 0;
        if ((capacidadStr != null) && (!capacidadStr.equals(""))) {
            capacidad = Integer.parseInt(capacidadStr);
        }

        Salon salon = new Salon(capacidad, nombre_salon, descripcion);

        int registrosIngresados = new SalonDaoImpl().insertar(salon);
        System.out.println("Registros insertados: " + registrosIngresados);

        listarSalones(request, response);
    }

    private void editarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int salon_id = Integer.parseInt(request.getParameter("salon_id"));

        Salon salon = new SalonDaoImpl().encontrar(new Salon(salon_id));
        System.out.println(salon);
        request.setAttribute("salon", salon);

        request.getRequestDispatcher("salones/editarSalones.jsp").forward(request, response);

    }

    private void eliminarSalones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Recuperar id Estudiante
        int salon_id = Integer.parseInt(request.getParameter("salon_id"));
        //Crear objeto Estudiante
        Salon salon = new Salon(salon_id);
        //llamar metodo eliminar DaoImpl
        int registrosEliminados = new SalonDaoImpl().eliminar(salon);
        System.out.println("Cantidad de registros Elminados: " + registrosEliminados);
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
