package com.grupono1.controller;

import com.grupono1.models.dao.AsignaciondeAlumnoDaoImpl;
import com.grupono1.models.domain.Asignacion_Alumno;
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
@WebServlet("/ServletAsignaciondeEstudiantes")
public class ServletAsignaciondeEstudiantes extends HttpServlet {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Asignacion_Alumno asignacion_Alumno = null;
    List<Asignacion_Alumno> ListaAsignacion_Alumno = new ArrayList<>();

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
        List<Asignacion_Alumno> listaAsignacion_Alumnos = new AsignaciondeAlumnoDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoAsignacion_Alumnos", listaAsignacion_Alumnos);
        response.sendRedirect("Asignacion_de_Alumno/ListarAsignaciondeAlumno.jsp");

    }

    private void EliminarAsignaciondeAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idAsignacion = request.getParameter("asignacion_id");

        Asignacion_Alumno asignacion_Alumno = new Asignacion_Alumno(idAsignacion);

        int registrosEliminados = new AsignaciondeAlumnoDaoImpl().eliminar(asignacion_Alumno);
        System.out.println("cantidad de registros eliminados: " + registrosEliminados);
        listarAsignaciondeAlumnos(request, response);

    }

}
