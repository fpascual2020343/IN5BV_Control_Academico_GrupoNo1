/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupono1.models.idao;

import com.grupono1.models.domain.Usuario;

/**
 *
 * @author Usuario
 */
public interface ILoginDao {
    
    public int buscar(Usuario user);
    
}
