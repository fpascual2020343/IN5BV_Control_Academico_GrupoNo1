


package com.grupo1.models.dao;

import com.grupono1.db.Conexion;
import com.grupono1.models.domain.Instructor;
import com.grupono1.models.idao.IInstructorDao;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio Javier López Pienda
 * codigo tecnico : IN5BV
 * @date 03-sep-2021
 * @time 0:07:04
 */
public class InstructorDaolmpl implements IInstructorDao{
    
    private static final String SQL_SELECT = "SELECT instructor_id,apellidos,nombres,direccion,telefono FROM Instructor";
    private static final String SQL_DELETE = "DELETE FROM Instructor WHERE instructor_id = ?";
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Instructor instructor = null;
    List<Instructor> listaInstructor = new ArrayList<>();

    @Override
    public List<Instructor> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idinstructor = rs.getInt("instructor_id");
                String nombre = rs.getString("apellidos");
                String apellido = rs.getString("nombres");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
               

                instructor = new Instructor(idinstructor, apellido, nombre, direccion, telefono);
                listaInstructor.add(instructor);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            
            
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }

        return listaInstructor;
    }

    @Override
    public Instructor encontrar(Instructor instructor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Instructor instructor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Instructor instructor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Instructor instructor) {
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1 ,instructor.getInstructor_id());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
    }
        
        return rows;
    }


    
    
}
