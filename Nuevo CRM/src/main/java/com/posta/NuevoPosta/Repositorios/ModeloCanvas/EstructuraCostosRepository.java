/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.posta.NuevoPosta.Repositorios.ModeloCanvas;

import com.posta.NuevoPosta.Entidades.ModeloCanvas.PasosCanvas.EstructuraCostos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author crowl
 */
@Repository
public interface EstructuraCostosRepository extends JpaRepository<EstructuraCostos, Long>{
    
}
