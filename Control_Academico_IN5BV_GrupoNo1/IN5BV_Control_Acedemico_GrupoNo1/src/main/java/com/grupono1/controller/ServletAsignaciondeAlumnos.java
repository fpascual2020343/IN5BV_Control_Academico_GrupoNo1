package com.grupono1.controller;

import com.grupono1.models.dao.AsignaciondeAlumnoDaoImpl;
<<<<<<< HEAD
import com.grupono1.models.domain.Alumno;
import com.grupono1.models.domain.AsignacionAlumno;
<<<<<<< HEAD
import com.grupono1.models.domain.Curso;
=======
import com.grupono1.models.domain.Asignacion_Alumno;
>>>>>>> guideon2
import java.io.IOException;
import java.sql.Timestamp;
=======
import com.grupono1.models.domain.AsignacionAlumno;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
>>>>>>> marck
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

<<<<<<< HEAD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("\ndoPost");
        String accion = request.getParameter("accion");
        System.out.println("Accion: " + accion);
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAsignacion(request, response);
                    break;
                case "actualizar":
                    actualizarAsignacion(request, response);
                    break;
            }
        }

    }
=======
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    AsignacionAlumno asignacion_Alumno = null;
    List<AsignacionAlumno> ListaAsignacion_Alumno = new ArrayList<>();
>>>>>>> marck

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {

            switch (accion) {

                case "listar":
                    listarAsignaciondeAlumnos(request, response);
                    break;
                case "editar":
<<<<<<< HEAD
                    editarAsignacion(request, response);
=======
                    //..
>>>>>>> marck
                    break;
                case "eliminar":
                    EliminarAsignaciondeAlumno(request, response);
                    break;
            }

        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
    
        private void listarAsignaciondeAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AsignacionAlumno> listaAsignacionAlumnos = new AsignaciondeAlumnoDaoImpl().listar();
=======

    private void listarAsignaciondeAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Asignacion_Alumno> listaAsignacionAlumnos = new AsignaciondeAlumnoDaoImpl().listar();
>>>>>>> guideon2
=======

    private void listarAsignaciondeAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AsignacionAlumno> listaAsignacionAlumnos = new AsignaciondeAlumnoDaoImpl().listar();
>>>>>>> marck

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoAsignacionAlumnos", listaAsignacionAlumnos);
        response.sendRedirect("asignacionDeAlumno/listarAsignacionAlumno.jsp");

    }

<<<<<<< HEAD
    private void listarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Alumno> listaAlumno = new AsignaciondeAlumnoDaoImpl().listarAlumno();

        HttpSession sesion = request.getSession();
            sesion.setAttribute("listadoAlumno", listaAlumno);
    }

    private void listarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Curso> curso = new AsignaciondeAlumnoDaoImpl().listarCurso();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCurso", curso);
    }
    

    private void insertarAsignacion(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("\nInsertarAsignacion");
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno();

        asignacionAlumno.setAsignacion_id(request.getParameter("asignacion_id"));
        asignacionAlumno.setCarne_alumno(request.getParameter("carne_alumno"));
        asignacionAlumno.setId_curso(Integer.parseInt(request.getParameter("id_curso")));
        asignacionAlumno.setFecha_asignacion(Timestamp.valueOf(request.getParameter("fecha_asignacion")));

        System.out.println(asignacionAlumno);

        //insertar el nuevo objeto en la base de datos
        int registrosIngresados = new AsignaciondeAlumnoDaoImpl().insertar(asignacionAlumno);
        System.out.println("Registros insertados" + registrosIngresados);
        listarAsignaciondeAlumnos(request, response);

    }

    private void actualizarAsignacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String asignacion = request.getParameter("asignacion_id");
        
        String carne = request.getParameter("carne_alumno");
        int curso = Integer.parseInt(request.getParameter("id_curso"));
        Timestamp fechaAsignacion = Timestamp.valueOf(request.getParameter("fecha_asignacion"));
        
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(asignacion, carne, curso, fechaAsignacion);
        System.out.println(asignacionAlumno);
        
        int registroActualizados = new AsignaciondeAlumnoDaoImpl().actualizar(asignacionAlumno);
        listarAsignaciondeAlumnos(request, response);
            
    }
    
    private void editarAsignacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String asignacion = request.getParameter("asignacion_id");

        AsignacionAlumno asignacionAlumno = new AsignaciondeAlumnoDaoImpl().encontrar(new AsignacionAlumno(asignacion));

        System.out.println(asignacionAlumno);

        request.setAttribute("asignacion", asignacionAlumno);
        request.getRequestDispatcher("asignacionDeAlumno/editar-asignacion.jsp").forward(request, response);

    }
    
    private void EliminarAsignaciondeAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String asignacion_id = request.getParameter("asignacion_id");
        Asignacion_Alumno asignacion_Alumno = new Asignacion_Alumno(asignacion_id);
        int registrosEliminados = new AsignaciondeAlumnoDaoImpl().eliminar(asignacion_Alumno);
=======
    private void EliminarAsignaciondeAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String asignacion_id = request.getParameter("asignacion_id");
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(asignacion_id);
        int registrosEliminados = new AsignaciondeAlumnoDaoImpl().eliminar(asignacionAlumno);
>>>>>>> marck
        System.out.println("cantidad de registros eliminados: " + registrosEliminados);
        listarAsignaciondeAlumnos(request, response);

    }

}
