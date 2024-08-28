/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Controladores;

import com.posta.NuevoPosta.Entidades.ModeloCanvas.ModeloCanvas;
import com.posta.NuevoPosta.Servicios.ModeloCanvas.Implementaciones.ModeloCanvasServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crowl
 */
@RestController
@RequestMapping("/proceso")
@CrossOrigin(origins = "*")
public class ProcesoControlador {
    
    @Autowired
    private ModeloCanvasServiceImple modeloService;
    
    //Guarda o Edita el Canvas Completo
    @PostMapping("/canvas")
    public ResponseEntity<?>guardarCanvas(@RequestBody ModeloCanvas modeloCanvas){
        try {
            modeloService.guardar(modeloCanvas);
            return new ResponseEntity<>(modeloCanvas, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Datos de solicitud no válidos", HttpStatus.BAD_REQUEST);
        }
        
    }
    
}
