package com.grupono1.controller;

import com.grupono1.models.dao.InstructorDaolmpl;
import com.grupono1.models.domain.Instructor;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Sergio Javier López Pienda codigo tecnico : IN5BV
 * @date 03-sep-2021
 * @time 1:17:34
 */
@WebServlet("/ServletInstructor")
public class ServletInstructor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("/ndoPost");

        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "insertar":

                    insertarInstructor(request, response);
                    break;
                case "actualizar":
                    actualizarInstructor(request, response);
                    break;
                case "editar":
                    actualizarInstructor(request, response);

                    break;
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarInstructor(request, response);
                    break;
                case "editar":
                    editarInstructor(request, response);
                    break;
                case "eliminar":

                    eliminarInstructor(request, response);
                    break;
            }
        }
    }

    private void actualizarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int instructor_id = Integer.parseInt(request.getParameter("instructor_id"));

        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        Instructor instructor = new Instructor(instructor_id, apellidos, nombres, direccion, telefono);
        System.out.println(instructor);

        int registrosModificados = new InstructorDaolmpl().actualizar(instructor);
        listarInstructor(request, response);

    }

    private void editarInstructor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int instructor_id = Integer.parseInt(request.getParameter("instructor_id"));
        Instructor instructor = new InstructorDaolmpl().encontrar(new Instructor(instructor_id));
        System.out.println(instructor);
        request.setAttribute("instructor", instructor);
        request.getRequestDispatcher("Instructor/editar-instructor.jsp").forward(request, response);

    }

    private void insertarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("/ninsertarInsreuctor");

        Instructor instructor = new Instructor();
        instructor.setApellidos(request.getParameter("apellidos"));
        instructor.setNombres(request.getParameter("nombres"));
        instructor.setDireccion(request.getParameter("direccion"));
        instructor.setTelefono(request.getParameter("telefono"));

        System.out.println(instructor);

        int resgistrosIngresados = new InstructorDaolmpl().insertar(instructor);

        System.out.println("registors insertados" + resgistrosIngresados);

        listarInstructor(request, response);

    }

    private void listarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Instructor> listaInstructor = new InstructorDaolmpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoInstructores", listaInstructor);

        response.sendRedirect("Instructor/listaInstructor.jsp");

    }

    private void eliminarInstructor(HttpServletRequest resquest, HttpServletResponse response) throws IOException {

        int instructor_id = Integer.parseInt(resquest.getParameter("instructor_id"));
        Instructor instructor = new Instructor(instructor_id);
        int registroEliminados = new InstructorDaolmpl().eliminar(instructor);

        System.out.println("Cantidad de registros eliminados" + registroEliminados);

        listarInstructor(resquest, response);

    }

}
