/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.models.dao;

import com.grupono1.db.Conexion;
import com.grupono1.models.domain.Usuario;
import com.grupono1.models.idao.ILoginDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 10:35:11 PM
 * @date 15/09/2021 Codigo Tecnico: IN5BV Carne: 2020343 Jornada: Vespertina
 */
public class LoginDaoImpl implements ILoginDao {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    private static final String SQL_SELECT = "Select * from Usuario where user = ? and pass = ?";

    @Override
    public int buscar(Usuario user) {
        try {
            int r = 0;
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            pstmt.setString(1, user.getUser());
            pstmt.setString(2, user.getPass());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                r = r + 1;
                user.setUser(rs.getString("user"));
                user.setPass(rs.getString("pass"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
    }

}
