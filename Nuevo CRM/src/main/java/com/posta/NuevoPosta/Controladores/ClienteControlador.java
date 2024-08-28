/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Controladores;

import com.posta.NuevoPosta.Entidades.Cliente;
import com.posta.NuevoPosta.Servicios.Implementaciones.ClienteServicioImple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteControlador {

    @Autowired
    private ClienteServicioImple clienteServ;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente) {

        try {
            clienteServ.guardar(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Datos de solicitud no válidos", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/todosPaginados/{page}")
    public ResponseEntity<?> buscarTodos(@PathVariable Integer page) {
        try {
            Pageable pageable = PageRequest.of(page, 10);
            Page<Cliente> encontrados = clienteServ.paginacion(pageable);
            return ResponseEntity.ok(encontrados);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            Cliente clienteBBDD = clienteServ.findById(id).get();
            if (clienteBBDD != null) {
                return ResponseEntity.ok(clienteBBDD);
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;

    }

    @PutMapping("/modificarCliente/{id}")
    public ResponseEntity<?> modificarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
        try {
            clienteServ.editarCliente(cliente, id);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Datos de solicitud no válidos", HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/estado/{id}")
    public ResponseEntity<?>cambioEstado(@PathVariable Long id){
        try {
            clienteServ.activarDeactivar(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Datos de solicitud no válidos", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("Estado del cliente cambiado");
    }
    
    
    
    
}
