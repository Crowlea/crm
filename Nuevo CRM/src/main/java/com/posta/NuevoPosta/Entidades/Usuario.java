/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.posta.NuevoPosta.Enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author crowl
 */
@Entity
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotNull
    private Long cedula;
    @NotBlank
    private String profesion;
    @NotBlank
    @Column(unique = true)
    private String telefono;
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp fechaRegistro;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp fechaActualizacion;
   
    private Boolean activo;
    
    @PrePersist
    public void active(){
        this.activo=true;
        
    }
    
}
