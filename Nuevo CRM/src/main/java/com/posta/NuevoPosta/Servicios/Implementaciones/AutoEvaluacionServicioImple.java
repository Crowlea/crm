/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Servicios.Implementaciones;

import com.posta.NuevoPosta.Entidades.AutoEvaluacion;
import com.posta.NuevoPosta.Enums.Respuesta;
import com.posta.NuevoPosta.Repositorios.AutoEvaluacionRepository;
import com.posta.NuevoPosta.Servicios.Interfaces.IAutoEvaluacionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author crowl
 */
@Service
public class AutoEvaluacionServicioImple implements IAutoEvaluacionServicio{
    
    @Autowired
    private AutoEvaluacionRepository autoEvaluacionRepo;

    @Override
    public void guardar(AutoEvaluacion autoEvaluacion) {
        List<Respuesta> respuestas=autoEvaluacion.getAutoEvaluacion();
        int puntaje=0;
        for (Respuesta respuesta : respuestas) {
            switch (respuesta) {
            case SI:
                puntaje += 3;
                break;
            case QUIZAS:
                puntaje += 2;
                break;
            // Agrega otros casos si es necesario
            default:
                // Manejo de otros casos, si los hay
                break;
        }
        }
        autoEvaluacion.setPuntaje(puntaje);
        autoEvaluacionRepo.save(autoEvaluacion);
    }

    @Override
    public Page<AutoEvaluacion> buscarTodas(Pageable pageable) {
        return autoEvaluacionRepo.findAll(pageable);
    }

    @Override
    public AutoEvaluacion buscarPorId(Long id) {
        return autoEvaluacionRepo.findById(id).get();
    }
    
}
