/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.models.dao;

import com.grupono1.db.Conexion;
import com.grupono1.models.domain.Salon;
import com.grupono1.models.idao.ISalonDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dylan
 * @codigo Tecnico: 2020235
 * @data 2/09/2021
 * @time 02:32:21 PM
 */
public class SalonDaoImpl implements ISalonDao {

    private static final String SQL_SELECT = "SELECT salon_id, capacidad, descripcion, nombre_salon FROM Salon";
    private static final String SQL_DELETE = "DELETE FROM Salon WHERE salon_id = ?";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Salon salon = null;
    List<Salon> listaSalon = new ArrayList<>();
    
    @Override
    public List<Salon> listar() {

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int idSalon = rs.getInt("salon_id");
                int capacidad = rs.getInt("capacidad");
                String descripcion = rs.getString("descripcion");
                String nombre_salon = rs.getString("nombre_salon");

                salon = new Salon(idSalon, capacidad, descripcion, nombre_salon);
                listaSalon.add(salon);
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
        return listaSalon;
    }

    @Override
    public Salon encontrar(Salon salon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Salon salon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Salon salon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Salon salon) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, salon.getSalon_id());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }
}