/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Controladores;

import com.posta.NuevoPosta.Entidades.AutoEvaluacion;
import com.posta.NuevoPosta.Servicios.Implementaciones.AutoEvaluacionServicioImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crowl
 */
@RestController
@RequestMapping("/autoevaluacion")
@CrossOrigin(origins = "*")
public class AutoEvaluacionControlador {

    @Autowired
    private AutoEvaluacionServicioImple autoEvaluacionServicio;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody AutoEvaluacion autoEvaluacion) {
        try {
            autoEvaluacionServicio.guardar(autoEvaluacion);
            return ResponseEntity.status(HttpStatus.CREATED).body("Autoevaluacion Guardada Correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos Incorrectos");
        }
    }

    @GetMapping("/todas/{page}")
    public ResponseEntity<?> buscarTodas(@PathVariable Integer page) {
        try {
            Pageable pageable = PageRequest.of(page, 10);
            Page<AutoEvaluacion> encontradas = autoEvaluacionServicio.buscarTodas(pageable);
            return ResponseEntity.ok(encontradas);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        try {
            AutoEvaluacion autoEvaluacionBBDD = autoEvaluacionServicio.buscarPorId(id);
            if (autoEvaluacionBBDD != null) {
                return ResponseEntity.ok(autoEvaluacionBBDD);
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }
}
