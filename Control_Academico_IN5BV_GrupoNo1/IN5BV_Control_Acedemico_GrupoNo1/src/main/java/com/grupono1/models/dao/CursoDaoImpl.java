/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupono1.models.dao;

import com.grupono1.db.Conexion;
import com.grupono1.models.domain.Curso;
import com.grupono1.models.idao.ICursoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 * @date 2/09/2021
 * @time 10:21:36 PM
 * @code IN5BV
*/
public class CursoDaoImpl implements ICursoDao{
     
    private static final String SQL_SELECT = "SELECT curso_id, ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario,id_salon, id_codigo_carrera, id_instructor  FROM Curso";
    private static final String SQL_DELETE = "DELETE FROM Curso WHERE curso_id =?";
    private static final String SQL_INSERT = "INSERT INTO Curso(ciclo, cupo_maximo, cupo_minimo, descripcion,id_horario,id_salon, id_codigo_carrera, id_instructor)  VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario,id_salon, id_codigo_carrera, id_instructor  FROM Curso WHERE curso_id=? ";
    private static final String SQL_UPDATE = "UPDATE Curso SET ciclo =?, cupo_maximo =?, cupo_minimo =?, descripcion=?,id_horario=?,id_salon=?, id_codigo_carrera=?, id_instructor =? WHERE curso_id=? ";
    
    
    
    Connection conn = null ; 
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Curso curso = null;
    List<Curso> listaCurso = new ArrayList<>();
    
    
    
    
    @Override
    public List<Curso> listar(){
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int curso_id = rs.getInt("curso_id");
                int ciclo = rs.getInt("ciclo");
                int cupo_maximo = rs.getInt("cupo_maximo");
                int cupo_minimo = rs.getInt("cupo_minimo");
                String descripcion = rs.getString("descripcion");
                int id_horario = rs.getInt("id_horario");
                int id_salon = rs.getInt("id_salon");
                String id_codigo_carrera = rs.getString("id_codigo_carrera");
                int id_instructor = rs.getInt("id_instructor");

                curso = new Curso(curso_id, ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario, id_salon, id_codigo_carrera, id_instructor);
                listaCurso.add(curso);
                
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaCurso;
    }

    
    @Override
    public Curso encontrar(Curso curso) {
         try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, curso.getCurso_id());
            rs = pstmt.executeQuery();

            while (rs.next()) {
               
                int ciclo = rs.getInt("ciclo");
                int cupo_maximo = rs.getInt("cupo_maximo");
                int cupo_minimo = rs.getInt("cupo_minimo");
                String descripcion = rs.getString("descripcion");
                int id_horario = rs.getInt("id_horario");
                int id_salon = rs.getInt("id_salon");
                String id_codigo_carrera = rs.getString("id_codigo_carrera");
                int id_instructor = rs.getInt("id_instructor");

               curso.setCiclo(ciclo);
               curso.setCupo_maximo(cupo_maximo);
               curso.setCupo_minimo(cupo_minimo);
               curso.setDescripcion(descripcion);
               curso.setId_horario(id_horario);
               curso.setId_salon(id_salon);
               curso.setId_codigo_carrera(id_codigo_carrera);
               curso.setId_instructor(id_instructor);
                
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return curso;
        
    }
   
    @Override
    public int insertar(Curso curso) {
          int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, curso.getCiclo());
            pstmt.setInt(2, curso.getCupo_maximo());
            pstmt.setInt(3, curso.getCupo_minimo());
            pstmt.setString(4, curso.getDescripcion());
            pstmt.setInt(5, curso.getId_horario());
            pstmt.setInt(6, curso.getId_salon());
            pstmt.setString(7, curso.getId_codigo_carrera());
            pstmt.setInt(8, curso.getId_instructor());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

    
    
    @Override
    public int actualizar(Curso curso) {
           int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, curso.getCiclo());
            pstmt.setInt(2, curso.getCupo_maximo());
            pstmt.setInt(3, curso.getCupo_minimo());
            pstmt.setString(4, curso.getDescripcion());
            pstmt.setInt(5, curso.getId_horario());
            pstmt.setInt(6, curso.getId_salon());
            pstmt.setString(7, curso.getId_codigo_carrera());
            pstmt.setInt(8, curso.getId_instructor());
            pstmt.setInt(9, curso.getCurso_id());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
  
    }

    @Override
    public int eliminar(Curso curso) {
           int rows = 0;
       try{
           conn = Conexion.getConnection();
           pstmt = conn.prepareStatement(SQL_DELETE);
           pstmt.setInt(1,curso.getCurso_id());
           System.out.println(pstmt.toString());
           rows = pstmt.executeUpdate();
       }catch(SQLException e){
           e.printStackTrace(System.out);
       }finally {
           Conexion.close(pstmt);
           Conexion.close(conn);
       }
        return rows;
    }

}
