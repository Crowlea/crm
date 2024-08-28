/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Servicios.ModeloCanvas.Implementaciones;

import com.posta.NuevoPosta.Entidades.ModeloCanvas.ModeloCanvas;
import com.posta.NuevoPosta.Entidades.ModeloCanvas.PasosCanvas.EstructuraCostos;
import com.posta.NuevoPosta.Repositorios.ModeloCanvas.ModeloCanvasRepository;
import com.posta.NuevoPosta.Servicios.ModeloCanvas.Interfaces.IModeloCanvasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crowl
 */
@Service
public class ModeloCanvasServiceImple implements IModeloCanvasServicio{
    
    @Autowired
    private ModeloCanvasRepository modeloRepo;
    @Autowired
    private EstructuraCostosServiceImpe estrcuturaService;
    

    
    //Guarda el Modelo Canvas junto con el Segmento de clientes(Persiste los dos en la BBDD para que tengan un id)
    @Override
    public void guardar(ModeloCanvas modeloCanvas) {
        try {
            modeloCanvas.setEstructuraCostos(estrcuturaService.guardar(modeloCanvas.getEstructuraCostos()));
            modeloRepo.save(modeloCanvas);
        } catch (Exception e) {
            System.out.println("Otra cosa");
        }
        
    }
    
}
