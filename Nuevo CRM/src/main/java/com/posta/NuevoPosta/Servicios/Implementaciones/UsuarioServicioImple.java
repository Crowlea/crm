/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Servicios.Implementaciones;

import com.posta.NuevoPosta.Entidades.Usuario;
import com.posta.NuevoPosta.Enums.Role;
import com.posta.NuevoPosta.Repositorios.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.posta.NuevoPosta.Servicios.Interfaces.IUsuarioServicio;

/**
 *
 * @author crowl
 */
@Service
public class UsuarioServicioImple implements IUsuarioServicio{
    
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public Page<Usuario> conPaginacion(Pageable pageable) {
        return usuarioRepo.buscarTodo(pageable);
    }

    @Override
    public List<Usuario> todos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public void guardar(Usuario usuario) {
        
        usuario.setRole(Role.ADVISER);
        
        usuarioRepo.save(usuario);
    }

    @Override
    public void activarDesactivar(Long id) {
          Usuario usuario = new Usuario();
        Optional<Usuario> encontrado = buscarPorId(id);
        if (encontrado.isPresent()) {
            usuario = encontrado.get();
            if (usuario.getActivo()) {
                usuario.setActivo(false);
                guardar(usuario);
                
            } else {
                usuario.setActivo(true);
                guardar(usuario);
            }
        }
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
