/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Servicios.Implementaciones;

import com.posta.NuevoPosta.Entidades.Asesoria;
import com.posta.NuevoPosta.Repositorios.AsesoriaRepository;
import com.posta.NuevoPosta.Servicios.Interfaces.IAsesoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author crowl
 */
@Service
public class AsesoriaServicioImple implements IAsesoriaServicio{
    
    @Autowired
    private AsesoriaRepository asesoriaRepo;

    @Override
    public Page<Asesoria> findAll(Pageable pageable) {
        return asesoriaRepo.findAll(pageable);
    }

//    @Override
//    public Page<Asesoria> findByUser(Long userId, Pageable pageable) {
//       return asesoriaRepo.findByUser(userId, pageable);
//    }

    @Override
    public void save(Asesoria asesoria) {
         asesoriaRepo.save(asesoria);
    }
    
}
