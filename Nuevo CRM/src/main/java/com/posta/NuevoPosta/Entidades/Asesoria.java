/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
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
public class Asesoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    @NotBlank
    @Lob
    @Column(length = 2500)
    private String asesoria;
//    @ManyToOne
//    private Usuario usuario;
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp fechaRegistro;
    @UpdateTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp fechaActualizacion;
    
}
