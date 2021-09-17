package com.grupono1.models.idao;

import com.grupono1.models.domain.Alumno;
import com.grupono1.models.domain.AsignacionAlumno;
import com.grupono1.models.domain.Curso;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IAsignacionAlumnoDao {
    
    //Declaracion de los Metodos para Acceder a la Base de Datos (CRUD)
    public List<AsignacionAlumno> listar();
    public List<Alumno> listarAlumno();
    public List<Curso> listarCurso();
    public AsignacionAlumno encontrar(AsignacionAlumno asignacion_Alumno);
    public int insertar(AsignacionAlumno asignacion_Alumno);
    public int actualizar(AsignacionAlumno asignacion_Alumno);
    public int eliminar(AsignacionAlumno asignacion_Alumno);

}
