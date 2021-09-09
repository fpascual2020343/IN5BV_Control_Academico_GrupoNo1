/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.models.dao;

import com.grupono1.db.Conexion;
import com.grupono1.models.domain.Asignacion_Alumno;
import com.grupono1.models.idao.IAsignacionAlumnoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franshesco Emmanuel Pascual Ramires
 * @time 11:25:22 AM
 * @date 3/09/2021 Codigo Tecnico: IN5BV Carne: 2020343 Jornada: Vespertina
 */
public class AsignaciondeAlumnoDaoImpl implements IAsignacionAlumnoDao {

    private static final String SQL_SELLECT = "SELECT asignacion_id, carne_alumno, id_curso,fecha_asignacion FROM Asignacion_Alumno";
    private static final String SQL_DELETE = "delete from Asignacion_Alumno where asignacion_id = ?";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Asignacion_Alumno asignacion_Alumno = null;
    List<Asignacion_Alumno> ListaAsignacion_Alumno = new ArrayList<>();

    @Override
    public List<Asignacion_Alumno> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELLECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String asignacionAlumno = rs.getString("asignacion_id");
                String carneAlumno = rs.getString("carne_alumno");
                int idCurso = rs.getInt("id_curso");
                Timestamp fechaAsigancion = rs.getTimestamp("fecha_asignacion");

                asignacion_Alumno = new Asignacion_Alumno(asignacionAlumno, carneAlumno, idCurso, fechaAsigancion);
                ListaAsignacion_Alumno.add(asignacion_Alumno);
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
        return ListaAsignacion_Alumno;
    }

    @Override
    public Asignacion_Alumno encontrar(Asignacion_Alumno asignacion_Alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Asignacion_Alumno asignacion_Alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Asignacion_Alumno asignacion_Alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Asignacion_Alumno asignacion_Alumno) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, asignacion_Alumno.getAsignacion_id());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);

        }
        return rows;
    }

}
