/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.posta.NuevoPosta.Repositorios;

import com.posta.NuevoPosta.Entidades.Usuario;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author crowl
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Optional<Usuario>findByEmail(String email);
    @Query("SELECT u FROM Usuario u")
    public Page<Usuario>buscarTodo(Pageable pageable);
}
