/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Servicios.ModeloCanvas.Implementaciones;

import com.posta.NuevoPosta.Entidades.ModeloCanvas.PasosCanvas.EstructuraCostos;
import com.posta.NuevoPosta.Repositorios.ModeloCanvas.EstructuraCostosRepository;
import com.posta.NuevoPosta.Servicios.ModeloCanvas.Interfaces.IEstructuraCostos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crowl
 */
@Service
public class EstructuraCostosServiceImpe implements IEstructuraCostos{
    
    @Autowired
    private EstructuraCostosRepository estructuraRepository;

    @Override
    public EstructuraCostos guardar(EstructuraCostos estructuraCostos) {
        return estructuraRepository.save(estructuraCostos);
    }
    
}
