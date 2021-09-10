package com.grupono1.controller;

import com.grupono1.models.dao.AsignaciondeAlumnoDaoImpl;
import com.grupono1.models.domain.AsignacionAlumno;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 11:24:21 AM
 * @date 3/09/2021 Codigo Tecnico: IN5BV Carne: 2020343 Jornada: Vespertina
 */
@WebServlet("/ServletAsignaciondeAlumnos")
public class ServletAsignaciondeAlumnos extends HttpServlet {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    AsignacionAlumno asignacion_Alumno = null;
    List<AsignacionAlumno> ListaAsignacion_Alumno = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {

            switch (accion) {

                case "listar":
                    listarAsignaciondeAlumnos(request, response);
                    break;
                case "editar":
                    //..
                    break;
                case "eliminar":
                    EliminarAsignaciondeAlumno(request, response);
                    break;
            }

        }
    }

    private void listarAsignaciondeAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AsignacionAlumno> listaAsignacionAlumnos = new AsignaciondeAlumnoDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoAsignacionAlumnos", listaAsignacionAlumnos);
        response.sendRedirect("asignacionDeAlumno/listarAsignacionAlumno.jsp");

    }

    private void EliminarAsignaciondeAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String asignacion_id = request.getParameter("asignacion_id");
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(asignacion_id);
        int registrosEliminados = new AsignaciondeAlumnoDaoImpl().eliminar(asignacionAlumno);
        System.out.println("cantidad de registros eliminados: " + registrosEliminados);
        listarAsignaciondeAlumnos(request, response);

    }

}
