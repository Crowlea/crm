/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.posta.NuevoPosta.Servicios.Interfaces;

import com.posta.NuevoPosta.Entidades.Asesoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author crowl
 */
public interface IAsesoriaServicio {
    
    public Page<Asesoria>findAll(Pageable pageable);
//    public Page<Asesoria>findByUser(@Param("user_id") Long userId, Pageable pageable);
    public void save(Asesoria asesoria);
}
