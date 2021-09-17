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


/**
 *
 * @author migue
 * @date 2/09/2021
 * @time 10:13:25 PM
 * @code IN5BV
*/

@WebServlet("/ServletCurso")
public class ServletCurso extends HttpServlet{    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String accion = request.getParameter("accion");
        
        if(accion != null){   
            switch(accion){
            
            case "listar":
            listarCurso(request, response);
            break;
            
            case "editar":
                break;
            
            case "eliminar":
            eliminarCurso(request,response);
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

}
