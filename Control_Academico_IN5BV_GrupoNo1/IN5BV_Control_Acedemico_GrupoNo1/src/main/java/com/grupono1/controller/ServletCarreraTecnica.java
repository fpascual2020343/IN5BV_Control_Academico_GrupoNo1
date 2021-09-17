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
<<<<<<< HEAD
import javax.servlet.ServletException;
=======
>>>>>>> sergio
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
<<<<<<< HEAD
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        System.out.println("accion: " + accion);

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCarrera(request, response);
                    break;
                case "actualizar":
                    actualizarCarrera(request, response);
                    break;
            }
        }
    }
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
=======

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
>>>>>>> sergio
        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "listar":
                    listarCarreraTecnica(request, response);
                    break;
                case "editar":
<<<<<<< HEAD
                    editarCarreraTecnica(request, response);
=======
                    //
>>>>>>> sergio
                    break;
                case "eliminar":
                    eliminarCarrera(request, response);
                    break;
            }

        }
    }
<<<<<<< HEAD
    
    private void insertarCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("\ninsertarCarrera");
        
        
        String codigo_carrera = request.getParameter("codigo_carrera");
        String nombre = request.getParameter("nombre");
        CarreraTecnica carrera = new CarreraTecnica(nombre, nombre);
        System.out.println(carrera);
        
        int registrosIngresado = new CarreraTecnicaDaoImpl().insertar(carrera);
        System.out.println("Registros insertados" + registrosIngresado);
    }
    
    private void actualizarCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String codigo_carrera = request.getParameter("codigo_carrera");
        String nombre = request.getParameter("nombre");
        CarreraTecnica carrera = new CarreraTecnica(nombre, nombre);
        System.out.println(carrera);
        
        int registrosActualizados = new CarreraTecnicaDaoImpl().actualizar(carrera);
        
        listarCarreraTecnica(request, response);
    }
    
    private void editarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        String codigo_carrera = request.getParameter("codigo_carrera");
        CarreraTecnica carrera = new CarreraTecnicaDaoImpl().encontrar(new CarreraTecnica(codigo_carrera));
        request.setAttribute("carrera", carrera);
        request.getRequestDispatcher("carrera/editar-carrera.jsp").forward(request, response);
    }

    private void listarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws IOException {

<<<<<<< HEAD
        List<CarreraTecnica> listarCarreraTecnica = new CarreraTecnicaDaoImpl().listar();
=======
        List<CarreraTecnica> listarCarreraTecnica = new CarreraTecnicaDaoImpl().listarCarrera();
>>>>>>> marck
=======

    private void listarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<CarreraTecnica> listarCarreraTecnica = new CarreraTecnicaDaoImpl().listarCarrera();
>>>>>>> sergio

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCarreraTecnica", listarCarreraTecnica);
        response.sendRedirect("carrera/listarCarrera.jsp");

    }

    private void eliminarCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String codigo_carrera = request.getParameter("codigo_carrera");
        CarreraTecnica carrera = new CarreraTecnica(codigo_carrera);
        int registrosEliminados = new CarreraTecnicaDaoImpl().eliminar(carrera);
<<<<<<< HEAD
        System.out.println();
=======
        System.out.println("Cantidad de registros Elminados: "+ registrosEliminados);
>>>>>>> sergio
        listarCarreraTecnica(request, response);
    }

}
