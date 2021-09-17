/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.models.dao;

import com.grupono1.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 10:35:11 PM
 * @date 15/09/2021 Codigo Tecnico: IN5BV Carne: 2020343 Jornada: Vespertina
 */
public class LoginDao {
/*
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    private static final String SQL_SELECT = "CALL sp_BuscarUsuario(?)";

    private void login() {

        String user = .getText();
        String pass = .getText();

        if (!(txtUsuario.getText().isEmpty() || .getText().isEmpty()) {
            
        }
        
            ) {

            if (pass.equals(getPassword(user))) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Kinal Mall");
                alert.setHeaderText(null);
                alert.setContentText("Sesion Iniciada \n" + "Bienvenido ");
                alert.show();

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Kinal Mall");
                alert.setHeaderText(null);
                alert.setContentText("El Usuario o La Contraseña son incorrectos, intente de nuevo");
                alert.show();
            }

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Kinal Mall");
            alert.setHeaderText(null);
            alert.setContentText("Llene todos los campos");
            alert.show();
        }

    }

    private String getPassword(String user) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String passDecodificado = null;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            pstmt.setString(1, user);
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            
            while (rs.next()) {

                escenarioPrincipal.getUsuario().setUser(rs.getString("user"));
                escenarioPrincipal.getUsuario().setPass(rs.getString("pass"));
                escenarioPrincipal.getUsuario().setNombre(rs.getString("nombre"));
                escenarioPrincipal.getUsuario().setRol(rs.getInt("rol"));
                //escenarioPrincipal.getUsuario().setPass(new String(Base64.getDecoder().decode(escenarioPrincipal.getUsuario().getPass())));
                passDecodificado = new String(Base64.getDecoder().decode(escenarioPrincipal.getUsuario().getPass()));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return passDecodificado;
    }
*/

}
