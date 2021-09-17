/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.controller;

import com.grupono1.models.dao.CursoDaoImpl;
import com.grupono1.models.domain.Curso;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author migue
 * @date 2/09/2021
 * @time 10:13:25 PM
 * @code IN5BV
 */
@WebServlet("/ServletCurso")
public class ServletCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {

                case "insertar":
                    insertarCurso(request, response);
                    break;
                    
                case "actualizar":
                    actualizarCurso(request, response);
                    break;

            }

        }
        System.out.println("accion" + "" + accion);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {

                case "listar":
                    listarCurso(request, response);
                    break;

                case "editar":
                    editarCurso(request, response);
                    break;

                case "eliminar":
                    eliminarCurso(request, response);
                    break;

            }

        }

    }

    private void listarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Curso> listaCurso = new CursoDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCurso", listaCurso);
        response.sendRedirect("cursos/listarCursos.jsp");
    }

    private void eliminarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int curso_id = Integer.parseInt(request.getParameter("curso_id"));

        Curso curso = new Curso(curso_id);

        int trows = new CursoDaoImpl().eliminar(curso);
        System.out.println("Registros eliminados" + trows);
        listarCurso(request, response);

    }

    private void insertarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String ciclos = request.getParameter("ciclo");
        String maximo = request.getParameter("cupo_maximo");
        String minimo = request.getParameter("cupo_minimo");
        String descripcion = request.getParameter("descripcion");
        String horario = request.getParameter("id_horario");
        String salon = request.getParameter("id_salon");
        String id_codigo_carrera = request.getParameter("id_codigo_carrera");
        String instructor = request.getParameter("id_instructor");
        int ciclo = 0;
        int cupo_maximo = 0;
        int cupo_minimo = 0;
        int id_horario = 0;
        int id_salon = 0;
        int id_instructor = 0;

        if ((ciclos != null) && (!ciclos.equals(""))) {
            ciclo = Integer.parseInt(ciclos);
        }
        if ((maximo != null) && (!maximo.equals(""))) {
            cupo_maximo = Integer.parseInt(maximo);
        }
        if ((minimo != null) && (!minimo.equals(""))) {
            cupo_minimo  = Integer.parseInt(minimo);
        }
        if ((horario != null) && (!horario.equals(""))) {
            id_horario= Integer.parseInt(horario);
        }
        if ((salon != null) && (!salon.equals(""))) {
            id_salon = Integer.parseInt(salon);
        }
        if ((instructor != null) && (!instructor.equals(""))) {
           id_instructor = Integer.parseInt(instructor);
        }
        Curso curso = new Curso(ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario, id_salon, id_codigo_carrera, id_instructor);
        System.out.println("Registro ingresado"+ "" + curso);
        int cursoint = new CursoDaoImpl().insertar(curso);

        listarCurso(request, response);

    }

   

    private void editarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int curso_id = Integer.parseInt(request.getParameter("curso_id"));
        
        Curso curso = new CursoDaoImpl().encontrar(new Curso(curso_id));
        System.out.println(curso);
        request.setAttribute("curso", curso);
        
        request.getRequestDispatcher("cursos/editarCursos.jsp").forward(request, response);
        
    }

     private void actualizarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        int curso_id = Integer.parseInt(request.getParameter("curso_id"));
         
        String ciclos = request.getParameter("ciclo");
        String maximo = request.getParameter("cupo_maximo");
        String minimo = request.getParameter("cupo_minimo");
        String descripcion = request.getParameter("descripcion");
        String horario = request.getParameter("id_horario");
        String salon = request.getParameter("id_salon");
        String id_codigo_carrera = request.getParameter("id_codigo_carrera");
        String instructor = request.getParameter("id_instructor");
        int ciclo = 0;
        int cupo_maximo = 0;
        int cupo_minimo = 0;
        int id_horario = 0;
        int id_salon = 0;
        int id_instructor = 0;

        if ((ciclos != null) && (!ciclos.equals(""))) {
            ciclo = Integer.parseInt(ciclos);
        }
        if ((maximo != null) && (!maximo.equals(""))) {
            cupo_maximo = Integer.parseInt(maximo);
        }
        if ((minimo != null) && (!minimo.equals(""))) {
            cupo_minimo  = Integer.parseInt(minimo);
        }
        if ((horario != null) && (!horario.equals(""))) {
            id_horario= Integer.parseInt(horario);
        }
        if ((salon != null) && (!salon.equals(""))) {
            id_salon = Integer.parseInt(salon);
        }
        if ((instructor != null) && (!instructor.equals(""))) {
           id_instructor = Integer.parseInt(instructor);
        }
        Curso curso = new Curso(curso_id, ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario, id_salon, id_codigo_carrera, id_instructor);
        System.out.println("Registro ingresado"+ "" + curso);
        int cursoint = new CursoDaoImpl().actualizar(curso);
        System.out.println("registro actualizado" + cursoint);
        listarCurso(request, response);

                
                }
    
}
