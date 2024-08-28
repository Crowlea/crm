/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.posta.NuevoPosta.Servicios.Interfaces;

import com.posta.NuevoPosta.Entidades.Cliente;
import com.posta.NuevoPosta.Enums.Genero;
import com.posta.NuevoPosta.Enums.TipoCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author crowl
 */
public interface IClienteServicio {

    public Optional<Cliente> findById(Long id);

    public void guardar(Cliente cliente);

    public void activarDeactivar(Long id);

    public Page<Cliente> findByGenero(Genero genero, Pageable pageable);

    public Page<Cliente> findByTipoCliente(TipoCliente tipoCliente, Pageable pageable);

    public Page<Cliente> findByActivo(Boolean activo, Pageable pageable);

    public Page<Cliente> paginacion(Pageable pageable);

    public Page<Cliente> byCreateTime(Pageable pageable);

    public Page<Cliente> findByMunicipio(Long idMunicipio, Pageable pageable);

    public List<Cliente> findByName(String nombre);

    public Page<Cliente> findByRegdate(Pageable pageable);

    public List<Cliente> buscarPorDesactivado(Boolean active);

    public Page<Cliente> buscarPorUsuario(Long id, Pageable pageable);

    public List<Cliente> findByRegdate();

}
