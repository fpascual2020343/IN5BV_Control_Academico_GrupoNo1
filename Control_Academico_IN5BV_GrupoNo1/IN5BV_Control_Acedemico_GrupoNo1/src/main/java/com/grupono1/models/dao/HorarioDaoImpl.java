/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupono1.models.dao;

import com.grupono1.db.Conexion;
import com.grupono1.models.domain.Horario;
import com.grupono1.models.idao.IHorarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 * @date 3/09/2021
 * @time 05:15:01 PM
 * @code IN5BV
*/
public class HorarioDaoImpl implements IHorarioDao{

      
    private static final String SQL_SELECT = "SELECT horario_id, horario_final, horario_inicio FROM Horario";
    private static final String SQL_DELETE = "DELETE FROM Horario WHERE horario_id =?";
    private static final String SQL_INSERT = "INSERT INTO Horario (horario_final, horario_inicio) VALUES (?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT horario_id, horario_final, horario_inicio FROM Horario WHERE horario_id=?";
     private static final String SQL_UPDATE = "UPDATE Horario SET horario_final = ?, horario_inicio =?  WHERE horario_id =?";
   
    
    Connection conn = null ; 
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Horario horario = null;
    List<Horario> listaHorario = new ArrayList<>();
    

    
    
    
    
    
    @Override
    public List<Horario> listar() {
         try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                int horario_id = rs.getInt("horario_id");
                Time horario_final = rs.getTime("horario_final");
                Time horario_inicio = rs.getTime("horario_inicio");

                horario = new Horario(horario_id, horario_final, horario_inicio);
                listaHorario.add(horario);
                
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
        return listaHorario;
    }

    
    @Override
    public Horario encontrar(Horario horario) {
         try {
             conn = Conexion.getConnection();
             pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);

             pstmt.setInt(1, horario.getHorario_id());
             System.out.println(pstmt.toString());
             rs = pstmt.executeQuery();

            while (rs.next()) {

                Time horario_final = rs.getTime("horario_final");
                Time horario_inicio = rs.getTime("horario_inicio");
                
                horario.setHorario_final(horario_final);
                horario.setHorario_inicio(horario_inicio);
                             
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
        return horario;
    }

    @Override
    public int insertar(Horario horario) {
     int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setTime(1,horario.getHorario_final());
            pstmt.setTime(2,horario.getHorario_inicio());    
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
    public int actualizar(Horario horario) {
         int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setTime(1,horario.getHorario_final());
            pstmt.setTime(2,horario.getHorario_inicio()); 
            pstmt.setInt(3,horario.getHorario_id()); 
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
    public int eliminar(Horario horario) {
          int rows = 0;
       try{
           conn = Conexion.getConnection();
           pstmt = conn.prepareStatement(SQL_DELETE);
           pstmt.setInt(1,horario.getHorario_id());
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
