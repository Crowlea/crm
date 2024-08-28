/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Servicios.Implementaciones;

import com.posta.NuevoPosta.Entidades.Cliente;
import com.posta.NuevoPosta.Enums.Actividades;
import com.posta.NuevoPosta.Enums.Genero;
import com.posta.NuevoPosta.Enums.TipoCliente;
import com.posta.NuevoPosta.Repositorios.ClienteRepository;
import com.posta.NuevoPosta.Servicios.Interfaces.IClienteServicio;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author crowl
 */
@Service
public class ClienteServicioImple implements IClienteServicio {
    
    @Autowired
    private ClienteRepository clienteRepo;
    
    @Override
    public Page<Cliente> paginacion(Pageable pageable) {
        return clienteRepo.findAll(pageable);
    }
    
    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepo.findById(id);
    }
    
    @Override
    public void guardar(Cliente cliente) {
        
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(cliente.getFechaNacimiento(), fechaActual).getYears();
        cliente.setEdad(edad);
        clienteRepo.save(cliente);
    }
    
    public void editarCliente(Cliente cliente, Long id) {
        Cliente clienteBBDD = clienteRepo.findById(id).get();
        if (clienteBBDD.getTipoCliente().equals("EMPRESARIO")) {
            
            clienteBBDD.setApellido(cliente.getApellido());
            clienteBBDD.setNombre(cliente.getNombre());
            clienteBBDD.setNIT(cliente.getNIT());
            clienteBBDD.setGenero(cliente.getGenero());
            clienteBBDD.setFechaNacimiento(cliente.getFechaNacimiento());
            clienteBBDD.setNivelDeEstudio(cliente.getNivelDeEstudio());
            clienteBBDD.setGrupoEtnico(cliente.getGrupoEtnico());
            clienteBBDD.setDesplazamiento(cliente.getDesplazamiento());
            clienteBBDD.setDiscapacidad(cliente.getDiscapacidad());
            clienteBBDD.setPoblacionVictima(cliente.getPoblacionVictima());
            clienteBBDD.setRegimenTributario(cliente.getRegimenTributario());
            clienteBBDD.setActividades(cliente.getActividades());
            clienteBBDD.setNombreCompañia(cliente.getNombreCompañia());
            clienteBBDD.setFechaAlta(cliente.getFechaAlta());
            clienteBBDD.setEmpleadosFormales(cliente.getEmpleadosFormales());
            clienteBBDD.setEmpleadosinformales(cliente.getEmpleadosinformales());
            clienteBBDD.setTelefono(cliente.getTelefono());
            clienteBBDD.setDireccion(cliente.getDireccion());
            clienteBBDD.setEmail(cliente.getEmail());
            clienteBBDD.setRegistroMercantil(cliente.getRegistroMercantil());
            clienteBBDD.setNumeroRegistroMercantil(cliente.getNumeroRegistroMercantil());
            clienteBBDD.setMunicipio(cliente.getMunicipio());
            clienteRepo.save(clienteBBDD);
        } else {
            clienteBBDD.setApellido(cliente.getApellido());
            clienteBBDD.setNombre(cliente.getNombre());
            clienteBBDD.setNIT(cliente.getNIT());
            clienteBBDD.setGenero(cliente.getGenero());
            clienteBBDD.setFechaNacimiento(cliente.getFechaNacimiento());
            clienteBBDD.setNivelDeEstudio(cliente.getNivelDeEstudio());
            clienteBBDD.setGrupoEtnico(cliente.getGrupoEtnico());
            clienteBBDD.setDesplazamiento(cliente.getDesplazamiento());
            clienteBBDD.setDiscapacidad(cliente.getDiscapacidad());
            clienteBBDD.setPoblacionVictima(cliente.getPoblacionVictima());
            clienteBBDD.setTelefono(cliente.getTelefono());
            clienteBBDD.setDireccion(cliente.getDireccion());
            clienteBBDD.setEmail(cliente.getEmail());
            clienteBBDD.setMunicipio(cliente.getMunicipio());
            clienteBBDD.setIdeaNegocio(cliente.getIdeaNegocio());
            clienteBBDD.setProducto(cliente.getProducto());
            clienteRepo.save(clienteBBDD);
        }
    }
    
    @Override
    public void activarDeactivar(Long id) {
        Cliente nuevoCliente = new Cliente();
        Optional<Cliente> encontrado = findById(id);
        if (encontrado.isPresent()) {
            nuevoCliente = encontrado.get();
            if (nuevoCliente.getActivo()) {
                nuevoCliente.setActivo(false);
                guardar(nuevoCliente);
                
            } else {
                nuevoCliente.setActivo(true);
                guardar(nuevoCliente);
            }
        }
    }
    
    @Override
    public Page<Cliente> findByGenero(Genero genero, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Page<Cliente> findByTipoCliente(TipoCliente tipoCliente, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Page<Cliente> findByActivo(Boolean activo, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Page<Cliente> byCreateTime(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Page<Cliente> findByMunicipio(Long idMunicipio, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Cliente> findByName(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Page<Cliente> findByRegdate(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Cliente> buscarPorDesactivado(Boolean active) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Page<Cliente> buscarPorUsuario(Long id, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Cliente> findByRegdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
