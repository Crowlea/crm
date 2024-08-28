/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.posta.NuevoPosta.Servicios.Interfaces;

import com.posta.NuevoPosta.Entidades.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author crowl
 */
public interface IUsuarioServicio {
    
    public Page<Usuario>conPaginacion(Pageable pageable);
    public List<Usuario>todos();
    public Optional<Usuario> buscarPorId(Long id);
    public void guardar(Usuario user);
    public void activarDesactivar(Long id);
    public Optional<Usuario> buscarPorEmail(String email);
    
    
}
