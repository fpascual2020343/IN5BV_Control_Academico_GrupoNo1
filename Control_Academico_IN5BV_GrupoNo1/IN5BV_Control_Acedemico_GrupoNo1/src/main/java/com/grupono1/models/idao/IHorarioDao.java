package com.grupono1.models.idao;

import com.grupono1.models.domain.Horario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IHorarioDao {
    
    //Declaracion de los Metodos para Acceder a la Base de Datos (CRUD)
    public List<Horario> listar();
    public Horario encontrar(Horario horario);
    public int insertar(Horario horario);
    public int actualizar(Horario horario);
    public int eliminar(Horario horario);
    
}
