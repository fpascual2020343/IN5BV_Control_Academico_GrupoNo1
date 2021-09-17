/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupono1.controller;

import com.grupono1.models.dao.HorarioDaoImpl;
import com.grupono1.models.domain.Horario;
import java.io.IOException;
import java.sql.Time;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author migue
 * @date 3/09/2021
 * @time 05:14:38 PM
 * @code IN5BV
*/

@WebServlet("/ServletHorario")
public class ServletHorario  extends HttpServlet{
        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String accion = request.getParameter("accion");
        
          if(accion != null){
            
            switch(accion){
            
            case "insertar":
            insertarHorario(request, response);
            break;
            
            case"actualizar":
            actualizarHorario(request, response);
            break;
                    
           
            }
        
       }
            
    
    }
    
  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String accion = request.getParameter("accion");
        
        if(accion != null){
            
            switch(accion){
            
            case "listar":
            listarHorario(request, response);
            break;
            
            case "editar":
                editarHorario(request, response);
                break;
            
            case "eliminar":
            eliminarHorario(request,response);
                break;
            
            }
        
       }
            
    }
    
    

    private void listarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Horario> listaHorario = new HorarioDaoImpl().listar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoHorario", listaHorario);
        response.sendRedirect("horarios/listarHorario.jsp");
    }

    private void eliminarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException {
         int horario_id = Integer.parseInt(request.getParameter("horario_id"));
        //Crear el objeto estudiante
        Horario horario = new Horario(horario_id);
        
        //Elimianr objeto
        int trows = new HorarioDaoImpl().eliminar(horario);
        System.out.println("Registros eliminados" + trows);
        listarHorario(request, response);
    }

    private void insertarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Horario horario = new Horario();
        
        horario.setHorario_final(Time.valueOf(request.getParameter("horario_final")));
        horario.setHorario_inicio(Time.valueOf(request.getParameter("horario_inicio")));
        System.out.println(horario);
        
        int horarionew = new HorarioDaoImpl().insertar(horario);
        System.out.println("Registro insertado" + horarionew);
        listarHorario(request, response);
    
    }

    private void editarHorario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int horario_id = Integer.parseInt(request.getParameter("horario_id"));
        
        Horario horario = new HorarioDaoImpl().encontrar(new Horario(horario_id));
        System.out.println(horario);
        request.setAttribute("horario", horario);
        
        request.getRequestDispatcher("horarios/editarHorario.jsp").forward(request, response);
  
    }

    private void actualizarHorario(HttpServletRequest request, HttpServletResponse response)  throws IOException{
        Horario horario = new Horario();
        int horario_id = Integer.parseInt(request.getParameter("horario_id"));
        
        horario.setHorario_id(horario_id);
        horario.setHorario_final(Time.valueOf(request.getParameter("horario_final")));
        horario.setHorario_inicio(Time.valueOf(request.getParameter("horario_inicio")));
        System.out.println(horario);
        
        int horariomodi = new HorarioDaoImpl().actualizar(horario);
        System.out.println("Registro insertado" + horariomodi);
        listarHorario(request, response);
    
    
    }
          
    
}