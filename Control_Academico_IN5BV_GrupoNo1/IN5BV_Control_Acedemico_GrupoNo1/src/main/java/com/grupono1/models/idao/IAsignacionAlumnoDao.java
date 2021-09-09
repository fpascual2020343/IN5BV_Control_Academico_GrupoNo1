package com.grupono1.models.idao;

import com.grupono1.models.domain.Asignacion_Alumno;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IAsignacionAlumnoDao {
    
    //Declaracion de los Metodos para Acceder a la Base de Datos (CRUD)
    public List<Asignacion_Alumno> listar();
    public Asignacion_Alumno encontrar(Asignacion_Alumno asignacion_Alumno);
    public int insertar(Asignacion_Alumno asignacion_Alumno);
    public int actualizar(Asignacion_Alumno asignacion_Alumno);
    public int eliminar(Asignacion_Alumno asignacion_Alumno);

}
