package com.grupono1.models.idao;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.grupono1.models.domain.Alumno;
import com.grupono1.models.domain.AsignacionAlumno;
import com.grupono1.models.domain.Curso;
=======
import com.grupono1.models.domain.Asignacion_Alumno;
>>>>>>> guideon2
=======
import com.grupono1.models.domain.AsignacionAlumno;
>>>>>>> marck
=======
import com.grupono1.models.domain.AsignacionAlumno;
>>>>>>> sergio
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IAsignacionAlumnoDao {
    
    //Declaracion de los Metodos para Acceder a la Base de Datos (CRUD)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public List<AsignacionAlumno> listar();
    public List<Alumno> listarAlumno();
    public List<Curso> listarCurso();
=======
    public List<AsignacionAlumno> listar();
>>>>>>> marck
=======
    public List<AsignacionAlumno> listar();
>>>>>>> sergio
    public AsignacionAlumno encontrar(AsignacionAlumno asignacion_Alumno);
    public int insertar(AsignacionAlumno asignacion_Alumno);
    public int actualizar(AsignacionAlumno asignacion_Alumno);
    public int eliminar(AsignacionAlumno asignacion_Alumno);
<<<<<<< HEAD
<<<<<<< HEAD
=======
    public List<Asignacion_Alumno> listar();
    public Asignacion_Alumno encontrar(Asignacion_Alumno asignacion_Alumno);
    public int insertar(Asignacion_Alumno asignacion_Alumno);
    public int actualizar(Asignacion_Alumno asignacion_Alumno);
    public int eliminar(Asignacion_Alumno asignacion_Alumno);
>>>>>>> guideon2
=======
>>>>>>> marck
=======
>>>>>>> sergio

}
