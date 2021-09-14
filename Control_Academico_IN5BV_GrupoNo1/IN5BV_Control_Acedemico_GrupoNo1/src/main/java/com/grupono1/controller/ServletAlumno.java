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
import com.grupono1.models.dao.AlumnoDaoImpl;
import com.grupono1.models.domain.Alumno;
import java.io.IOException;



/**
 *
 * @author klbmo
 */
@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAlumno(request, response);
                    break;

                case "editar":
                    List<Alumno> listaAlumno = new AlumnoDaoImpl().listar();
                    String carne = request.getParameter("carne");
                    String apellidos = request.getParameter("apellidos");
                    String nombres = request.getParameter("nombres");
                    String email = request.getParameter("email");

                    Alumno alumno = new Alumno(carne, apellidos, nombres, email);

                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("alumno", alumno);
                    response.sendRedirect("alumnos/editarAlumno.jsp");
                    
                    break;
                case "actualizar":
                    actualizarAlumno(request, response);
                    break;
            }
        }

    }

    private void insertarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String carne = request.getParameter("carne");
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        String email = request.getParameter("email");

        Alumno alumno = new Alumno(carne, apellidos, nombres, email);

        //insertar estos datos en la base de datos
        int registroIngresado = new AlumnoDaoImpl().insertar(alumno);

        System.out.println("registros insertados: " + registroIngresado);

        listarAlumno(request, response);
        //int registrosActualizados=new AlumnoDaoImpl().actualizar(alumno);
        //System.out.println("registros actualizados: "+ registrosActualizados);
    }

    private void actualizarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String carne = request.getParameter("carne");
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        String email = request.getParameter("email");

        Alumno alumno = new Alumno(carne, apellidos, nombres, email);

        //insertar estos datos en la base de datos
        int registroIngresado = new AlumnoDaoImpl().actualizar(alumno);

        System.out.println("registros insertados: " + registroIngresado);

        listarAlumno(request, response);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{             
        
        String accion= request.getParameter("accion");
        
        if(accion !=null){
            
            switch(accion){
                case "listar":
                    listarAlumno(request,response);
                    break;
                case "editar":
                       // editarAlumno(request,response);
                        break;
                case "eliminar":
                        eliminarAlumno(request,response);
                        break;
            
            }
        }
        
    }
    
    private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String carne = request.getParameter("carne");

        Alumno alumno= new Alumno(carne);
        

        int registrosEliminados=new AlumnoDaoImpl().eliminar(alumno);
        System.out.println("Cantidad de registros eliminados: "+ registrosEliminados);
        
        listarAlumno(request,response);
        
    }
    
    private void listarAlumno(HttpServletRequest request, HttpServletResponse response)throws IOException{
        
        List<Alumno> listaAlumno = new AlumnoDaoImpl().listar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoAlumno",listaAlumno);
        response.sendRedirect("alumnos/listarAlumnos.jsp");
        
    }

    
}
