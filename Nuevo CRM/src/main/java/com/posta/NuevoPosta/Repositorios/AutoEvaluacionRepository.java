/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.posta.NuevoPosta.Repositorios;

import com.posta.NuevoPosta.Entidades.AutoEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author crowl
 */
@Repository
public interface AutoEvaluacionRepository extends JpaRepository<AutoEvaluacion, Long>{
    
}
