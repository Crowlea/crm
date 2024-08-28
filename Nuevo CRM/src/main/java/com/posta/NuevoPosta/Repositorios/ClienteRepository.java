/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.posta.NuevoPosta.Repositorios;

import com.posta.NuevoPosta.Entidades.Cliente;
import com.posta.NuevoPosta.Enums.Genero;
import com.posta.NuevoPosta.Enums.TipoCliente;
import java.util.List;
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
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    @Query("SELECT a FROM Cliente a WHERE a.genero=:genero")
    public Page<Cliente> findByGenero(@Param("genero") Genero genero, Pageable pageable);
    
    public Page<Cliente> findByTipoCliente(TipoCliente tipoCliente, Pageable pageable);
    
    @Query("SELECT a FROM Cliente a WHERE a.activo = true ORDER BY a.fechaRegistro DESC LIMIT 5")
    public List<Cliente>findByFechaRegistro();
    
    public Page<Cliente>findByActivo(Boolean activo, Pageable pageable);
    
    @Query("SELECT a FROM Cliente a WHERE a.activo = true ORDER BY a.fechaRegistro DESC")
    public Page<Cliente>findByRegdate(Pageable pageable);
    
    @Query("SELECt a FROM Cliente a WHERE a.nombre LIKE %?1%")
    public List<Cliente>findByNombre(String nombre);

    public List<Cliente> findByNombreContainingIgnoreCase(String term);
    
   @Query("select c from Cliente c where c.activo=true")
    public List<Cliente> buscarPorActivos(Pageable pageable);
    
    @Query("select c from Cliente c where c.activo=?1")
    public List<Cliente> buscarPorEstado(Boolean active);
    
    @Query("select c from Cliente c where c.usuario.id=?1")
    public Page<Cliente> buscarPorUsuario(Long id,Pageable pageable);
    
}
