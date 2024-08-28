/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Controladores;

import com.posta.NuevoPosta.Entidades.Usuario;
import com.posta.NuevoPosta.Servicios.Implementaciones.UsuarioServicioImple;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crowl
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicioImple usuarioSer;
    
    @GetMapping("/paginar/{page}")
    public ResponseEntity<?> findAllPaginar(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Usuario> paginarUsuario = usuarioSer.conPaginacion(pageable);
        return ResponseEntity.ok(paginarUsuario);
    }
    
    @GetMapping("/porId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            Usuario usuarioBBDD = usuarioSer.buscarPorId(id).get();
            if (usuarioBBDD != null) {
                return ResponseEntity.ok(usuarioBBDD);
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;

    }
    
    
    @PostMapping("/guardar")
    public ResponseEntity<?>guardarUsuario(@RequestBody Usuario usuario){
        try {
            usuarioSer.guardar(usuario);
        } catch (Exception e) {
            
        }
        
        return ResponseEntity.ok("Usuario Guardado");
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?>editarUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
        
        Optional<Usuario> usuarioEncontrado = usuarioSer.buscarPorId(id);
        if (usuarioEncontrado.isPresent()) {
            Usuario updateUser = usuarioEncontrado.get();
            updateUser.setNombre(usuario.getNombre());
            updateUser.setApellido(usuario.getApellido());
            updateUser.setEmail(usuario.getEmail());
            updateUser.setPassword(usuario.getPassword());
            updateUser.setTelefono(usuario.getTelefono());
            updateUser.setRole(usuario.getRole());
            updateUser.setCedula(usuario.getCedula());
            updateUser.setProfesion(usuario.getProfesion());
            usuarioSer.guardar(updateUser);
            return ResponseEntity.ok(updateUser);
        }
        return ResponseEntity.notFound().build();
        
    }
    
    @DeleteMapping("/estado/{id}")
    public ResponseEntity<?>cambioEstado(@PathVariable Long id){
        try {
            usuarioSer.activarDesactivar(id);
        } catch (Exception e) {
        }
        return ResponseEntity.ok("Estado del usuario cambiado");
    }
    
}
