/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Entidades.ModeloCanvas.PasosCanvas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.posta.NuevoPosta.Entidades.ModeloCanvas.ModeloCanvas;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToOne;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author crowl
 */
@Entity
@Data
public class EstructuraCostos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ElementCollection
    @CollectionTable(name = "costos_fijos", joinColumns = @JoinColumn(name = "estructuracostos_id"))
    @MapKeyColumn(name = "componente")
    @Column(name = "monto")
    private Map<String, Double> costosFijos = new HashMap<>();
    
    @ElementCollection
    @CollectionTable(name = "costos_variables", joinColumns = @JoinColumn(name = "estructuracostos_id"))
    @MapKeyColumn(name = "componente")
    @Column(name = "monto")
    private Map<String, Double> costosVariables = new HashMap<>();
            
    @OneToOne(mappedBy = "estructuraCostos", fetch = FetchType.LAZY)
    @JsonIgnore
    private ModeloCanvas modeloCanvas;
    
    public Double calcularTotalCostosFijos() {
        return calcularTotal(costosFijos);
    }

    public Double calcularTotalCostosVariables() {
        return calcularTotal(costosVariables);
    }

    public Double calcularTotalGeneral() {
        return calcularTotal(costosFijos) + calcularTotal(costosVariables);
    }

    private Double calcularTotal(Map<String, Double> costos) {
        Double total = 0.0;
        for (Double amount : costos.values()) {
            total += amount;
        }
        return total;
    }
    
}
