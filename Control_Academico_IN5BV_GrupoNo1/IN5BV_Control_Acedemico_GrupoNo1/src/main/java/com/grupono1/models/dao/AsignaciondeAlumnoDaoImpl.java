/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.models.dao;

import com.grupono1.db.Conexion;

import com.grupono1.models.domain.Alumno;
import com.grupono1.models.domain.AsignacionAlumno;
import com.grupono1.models.domain.Curso;
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

    private static final String SQL_SELECT = "SELECT asignacion_id, carne_alumno, id_curso,fecha_asignacion FROM Asignacion_Alumno";
    private static final String SQL_SELECT_Alumno = "SELECT carne, apellidos, nombres, email FROM Alumno";
    private static final String SQL_SELECT_Curso = "SELECT curso_id, ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario,id_salon, id_codigo_carrera, id_instructor  FROM Curso";
    private static final String SQL_DELETE = "delete from Asignacion_Alumno where asignacion_id = ?";

    private static final String SQL_INSERT = "INSERT INTO Asignacion_Alumno (asignacion_id, carne_alumno, id_curso, fecha_asignacion) VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT_STRING_BY_ID = "SELECT asignacion_id, carne_alumno, id_curso,fecha_asignacion FROM Asignacion_Alumno WHERE asignacion_id = ?";
    private static final String SQL_UPDATE = " UPDATE Asignacion_Alumno SET carne_alumno = ?, id_curso = ?, fecha_asignacion = ? WHERE asignacion_id = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    AsignacionAlumno asignacion_Alumno = null;
    List<AsignacionAlumno> ListaAsignacion_Alumno = new ArrayList<>();
    Alumno alumno = null;
    List<Alumno> listaAlumno = new ArrayList<>();
    Curso curso = null;
    List<Curso> listaCurso = new ArrayList<>();

    @Override
    public List<AsignacionAlumno> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String asignacion_id = rs.getString("asignacion_id");
                String carne_alumno = rs.getString("carne_alumno");
                int id_curso = rs.getInt("id_curso");
                Timestamp fecha_asignacion = rs.getTimestamp("fecha_asignacion");

                asignacion_Alumno = new AsignacionAlumno(asignacion_id, carne_alumno, id_curso, fecha_asignacion);
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
    public List<Alumno> listarAlumno() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_Alumno);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String carne = rs.getString("carne");
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombres");
                String email = rs.getString("email");

                alumno = new Alumno(carne, apellidos, nombres, email);
                listaAlumno.add(alumno);

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
        return listaAlumno;
    }

    @Override
    public List<Curso> listarCurso() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_Curso);
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
    public AsignacionAlumno encontrar(AsignacionAlumno asignacion_Alumno) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_STRING_BY_ID);
            pstmt.setString(1, asignacion_Alumno.getAsignacion_id());
            pstmt.toString();

            rs = pstmt.executeQuery();

            while (rs.next()) {

                String carne = rs.getString("carne_alumno");
                int curso = rs.getInt("id_curso");
                Timestamp fechaHora = rs.getTimestamp("fecha_asignacion");

                asignacion_Alumno.setCarne_alumno(carne);
                asignacion_Alumno.setId_curso(curso);
                asignacion_Alumno.setFecha_asignacion(fechaHora);

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

        return asignacion_Alumno;
    }

    @Override
    public int insertar(AsignacionAlumno asignacion_Alumno) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, asignacion_Alumno.getAsignacion_id());
            pstmt.setString(2, asignacion_Alumno.getCarne_alumno());
            pstmt.setInt(3, asignacion_Alumno.getId_curso());
            pstmt.setTimestamp(4, asignacion_Alumno.getFecha_asignacion());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);

        }
        return rows;
    }

    @Override
    public int actualizar(AsignacionAlumno asignacion_Alumno) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);

            pstmt.setString(1, asignacion_Alumno.getCarne_alumno());
            pstmt.setInt(2, asignacion_Alumno.getId_curso());
            pstmt.setTimestamp(3, asignacion_Alumno.getFecha_asignacion());
            pstmt.setString(4, asignacion_Alumno.getAsignacion_id());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);

        }
        return rows;
    }

    @Override
    public int eliminar(AsignacionAlumno asignacion_Alumno) {
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
