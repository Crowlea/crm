/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.posta.NuevoPosta.Repositorios;

import com.posta.NuevoPosta.Entidades.Asesoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author crowl
 */
@Repository
public interface AsesoriaRepository extends JpaRepository<Asesoria, Long>{
    
//    @Query("SELECT a FROM Asesoria a WHERE a.usuario.id=?1")
//    public Page<Asesoria>findByUser(@Param("user_id") Long userId, Pageable pageable);
    public Page<Asesoria>findAll(Pageable pageable);
    
}
