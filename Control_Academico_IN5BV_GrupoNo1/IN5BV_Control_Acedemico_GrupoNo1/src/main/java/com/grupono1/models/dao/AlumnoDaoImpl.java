/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.models.dao;

import com.grupono1.db.Conexion;
import com.grupono1.models.domain.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.grupono1.models.idao.IAlumnoDao;
import java.sql.SQLException;

/**
 *
 * @author klbmo
 */
public class AlumnoDaoImpl implements IAlumnoDao{
    private static final String SQL_SELECT ="SELECT carne, apellidos, nombres, email FROM Alumno";
    private static final String SQL_DELETE ="DELETE FROM Alumno WHERE carne=?";
    private static final String SQL_INSERT ="INSERT INTO Alumno(carne, apellidos, nombres, email) VALUES(?,?,?,?)";
    private static final String SQL_SELCT_BY_ID ="SELECT carne, apellidos, nombres, email WHERE carne=?";
    private static final String SQL_UPDATE ="UPDATE Alumno SET apellidos=?, nombres=?, email=? WHERE carne =?";
    
    
    Connection conn=null;
    PreparedStatement pstmt = null;
    ResultSet rs=null;
    Alumno alumno = null;
    List <Alumno> listaAlumno=new ArrayList<>();
        
    @Override
    public List<Alumno> listar() { 
        try {
            conn=Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs=pstmt.executeQuery();
            
            while(rs.next()){
                String carne=rs.getString("carne");
                String apellidos=rs.getString("apellidos");
                String nombres=rs.getString("nombres");
                String email=rs.getString("email");
                
                alumno=new Alumno(carne,apellidos,nombres,email);
                listaAlumno.add(alumno);
                
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaAlumno;
    }

    @Override
    public Alumno encontrar(Alumno alumno) {
        return null;
        /*try {
            conn=Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELCT_BY_ID);//PRIMER CAMBIO
            //Segundo cambio
            pstmt.setString(1, alumno.getCarne());
            System.out.println(pstmt.toString());
            
            rs=pstmt.executeQuery();
            
            
            while(rs.next()){
                String nombres=rs.getString("nombres");
                String apellidos=rs.getString("apellidos");
                String email=rs.getString("emails");
                
                //Tercer Cambio
                alumno.setApellidos(apellidos);
                alumno.setNombres(nombres);
                alumno.setEmail(email);
                
                //cuarto cambio
                //...Se queda vacío
                
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        
        //quinto cambio
        return alumno;*/
    }


    @Override
    public int eliminar(Alumno alumno) {
        int rows =0;
        try{
            conn =Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1,alumno.getCarne());
            System.out.println(pstmt.toString());
            rows=pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int actualizar(Alumno alumno) {
        int rows=0;
        try{
            conn= Conexion.getConnection();
            pstmt= conn.prepareStatement(SQL_UPDATE);// Primer cambio
            pstmt.setString(1,alumno.getApellidos());
            pstmt.setString(2,alumno.getNombres());
            pstmt.setString(3,alumno.getEmail());
            pstmt.setString(4,alumno.getCarne());
            
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }catch(Exception e){
           e.printStackTrace(System.out); 
        }finally{
            Conexion.close(pstmt);
            Conexion.close(pstmt);
            
        }
        return rows;
    }

    @Override
    public int insertar(Alumno alumno) {
        int rows=0;
        try{
            conn= Conexion.getConnection();
            pstmt= conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1,alumno.getCarne());
            pstmt.setString(2,alumno.getApellidos());
            pstmt.setString(3,alumno.getNombres());
            pstmt.setString(4,alumno.getEmail());
            
            
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }catch(Exception e){
           e.printStackTrace(System.out); 
        }finally{
            Conexion.close(pstmt);
            Conexion.close(pstmt);
            
        }
        return rows;
    }
}