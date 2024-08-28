/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Entidades.ModeloCanvas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.posta.NuevoPosta.Entidades.Cliente;
import com.posta.NuevoPosta.Entidades.ModeloCanvas.PasosCanvas.EstructuraCostos;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author crowl
 */
@Entity
@Data
public class ModeloCanvas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String[] segmentoClientes = new String[4];
    private String propuestaValor;
    private String[] canales = new String[5];
    private String[] relacionesClientes = new String[3];
    private String[] recursosCalve = new String[5];
    private String[] actividadesClaves = new String[5];
    private String[] socioClave = new String[5];   
    private String[] ingresos = new String[4];

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estructura_costos_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private EstructuraCostos estructuraCostos;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cliente cliente;
    
    
}
