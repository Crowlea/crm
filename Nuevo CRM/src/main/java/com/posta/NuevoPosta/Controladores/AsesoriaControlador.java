/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Controladores;

import com.posta.NuevoPosta.Entidades.Asesoria;
import com.posta.NuevoPosta.Servicios.Implementaciones.AsesoriaServicioImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crowl
 */
@RestController
@RequestMapping("/asesorias")
@CrossOrigin(origins = "*")
public class AsesoriaControlador {
    
    @Autowired
    private AsesoriaServicioImple asesoriaServ;
    
    @PostMapping("/guardarAsesoria")
    public ResponseEntity<?>guardar(@RequestBody Asesoria asesoria){
        asesoriaServ.save(asesoria);
        return ResponseEntity.ok("Asesoria Guardada con Exito");
    }
    
//    @GetMapping("/buscar/{page}")
//    public ResponseEntity<?> findByAdvisory(@RequestParam("user_id") Long userId, @PathVariable Integer page) {
//        Pageable pageable = PageRequest.of(page, 10);
//        Page<Asesoria> asesorias = asesoriaServ.findByUser(userId, pageable);
//        if (asesorias.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(asesorias);
//    }
    
}
