


package com.grupono1.controller;

import com.grupo1.models.dao.InstructorDaolmpl;
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
 * @author Sergio Javier López Pienda
 * codigo tecnico : IN5BV
 * @date 03-sep-2021
 * @time 1:17:34
 */
@WebServlet("/ServletInstructor")
public class ServletInstructor extends  HttpServlet{




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarInstructor(request, response);
                    break;
                case "editar":
                    break;
                case "eliminar":
                    
                    eliminarInstructor(request, response);
                    break;
            }
        }
    }
private void listarInstructor(HttpServletRequest request,HttpServletResponse response) throws IOException{
    List<Instructor> listaInstructor = new InstructorDaolmpl().listar();

    HttpSession sesion = request.getSession();
    sesion.setAttribute("listadoInstructores", listaInstructor);
    
    response.sendRedirect("Instructor/listaInstructor.jsp");

 }

private void eliminarInstructor (HttpServletRequest resquest, HttpServletResponse response) throws IOException{

    int instructor_id = Integer.parseInt(resquest.getParameter("instructor_id"));
    Instructor instructor = new Instructor(instructor_id);
    int registroEliminados = new InstructorDaolmpl().eliminar(instructor);
    
    System.out.println("Cantidad de registros eliminados" + registroEliminados);
   
    listarInstructor(resquest, response);
    
  }
}
