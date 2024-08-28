/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.posta.NuevoPosta.Servicios.Interfaces;

import com.posta.NuevoPosta.Entidades.AutoEvaluacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author crowl
 */
public interface IAutoEvaluacionServicio {
    
    public void guardar(AutoEvaluacion autoEvaluacion);
    public Page<AutoEvaluacion>buscarTodas(Pageable pageable);
    public AutoEvaluacion buscarPorId(Long id);
}
