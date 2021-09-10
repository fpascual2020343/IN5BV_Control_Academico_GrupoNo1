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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(CarreraTecnica carreraTecnica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(CarreraTecnica carreraTecnica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
