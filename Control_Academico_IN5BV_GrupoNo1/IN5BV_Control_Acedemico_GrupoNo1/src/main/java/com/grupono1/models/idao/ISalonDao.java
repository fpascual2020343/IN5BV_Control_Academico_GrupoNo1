/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.models.idao;

import com.grupono1.models.domain.Salon;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ISalonDao {
    
    public List<Salon> listar();
    public Salon encontrar(Salon salon);
    public int insertar(Salon salon);
    public int actualizar(Salon salon);
    public int eliminar(Salon salon);
    
}
