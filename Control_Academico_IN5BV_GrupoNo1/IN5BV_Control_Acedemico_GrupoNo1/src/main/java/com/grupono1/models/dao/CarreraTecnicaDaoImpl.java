/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupono1.models.dao;

import com.grupono1.db.Conexion;
import com.grupono1.models.domain.CarreraTecnica;
import com.grupono1.models.idao.ICarreraTecnicaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Alexander Lancerio Alvarado
 * Código Técnico: 2020255
 * @date 1/09/2021
 * @time 09:11:00 PM
 */
public class CarreraTecnicaDaoImpl implements ICarreraTecnicaDao {
    
    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre FROM Carrera_Tecnica";
    private static final String SQL_DELETE = "DELETE FROM Carrera_Tecnica WHERE codigo_carrera = ?";
    private static final String SQL_INSERT = "INSERT INTO Carrera_Tecnica(codigo_carrera, nombre) VALUES(?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT codigo_carrera, nombre FROM Carrera_Tecnica WHERE codigo_carrera = ?";
    private static final String SQL_UPDATE = "UPDATE Carrera_Tecnica SET nombre = ? WHERE codigo_id = ?";
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    CarreraTecnica carrera = null;
    List<CarreraTecnica> listaCarreraTenica = new ArrayList<>();

    @Override
    public List<CarreraTecnica> listarCarrera() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String codigo_carrera = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre");
            

                carrera = new CarreraTecnica(codigo_carrera, nombre);
                listaCarreraTenica.add(carrera);
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
        return listaCarreraTenica;
        
    }

    @Override
    public CarreraTecnica encontrar(CarreraTecnica carreraTecnica) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setString(1, carrera.getCodigo_carrera());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String codigo_carrera = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre");
                carrera.setCodigo_carrera(codigo_carrera);
                carrera.setNombre(nombre);
                
                listaCarreraTenica.add(carrera);
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
        return carrera;
    }

    @Override
    public int insertar(CarreraTecnica carreraTecnica) {
        
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, carreraTecnica.getCodigo_carrera());
            pstmt.setString(2, carreraTecnica.getNombre());
            
            System.out.println(pstmt.toString());
            
            rows=pstmt.executeUpdate();
            
        }catch(SQLException e) {
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
    public int actualizar(CarreraTecnica carreraTecnica) {
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, carreraTecnica.getCodigo_carrera());
            pstmt.setString(2, carreraTecnica.getNombre());
            System.out.println(pstmt.toString());
            rows=pstmt.executeUpdate();
            
        }catch(SQLException e) {
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
    public int eliminar(CarreraTecnica carreraTecnica) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, carreraTecnica.getCodigo_carrera());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
