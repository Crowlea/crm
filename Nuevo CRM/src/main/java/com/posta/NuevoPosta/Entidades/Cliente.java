/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.posta.NuevoPosta.Enums.Actividades;
import com.posta.NuevoPosta.Enums.Genero;
import com.posta.NuevoPosta.Enums.GrupoEtnico;
import com.posta.NuevoPosta.Enums.Municipio;
import com.posta.NuevoPosta.Enums.NivelEstudio;
import com.posta.NuevoPosta.Enums.RegimenTributario;
import com.posta.NuevoPosta.Enums.TipoCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author crowl
 */
@Entity
@Data
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotNull
    @Column(unique = true)
    private Long NIT;

    @Enumerated(value = EnumType.STRING)
    private Genero genero;

    @Enumerated(value = EnumType.STRING)
    private NivelEstudio nivelDeEstudio;

    @Enumerated(value = EnumType.STRING)
    private GrupoEtnico grupoEtnico;

    @NotNull
    private Boolean poblacionVictima;

    @NotNull
    private Boolean discapacidad;

    @NotNull
    private Boolean desplazamiento;

    @NotBlank
    @Column(unique = true)
    private String telefono;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String direccion;

    @Lob
    @Column(length = 2500)
    private String observaciones;

    private Boolean activo;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp fechaRegistro;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp fechaActualizacion;

    @Enumerated(value = EnumType.STRING)
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private LocalDate fechaNacimiento;

    private Integer edad;

    private String nombreCompañia;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private Date fechaAlta;

    @Enumerated(value = EnumType.STRING)
    private RegimenTributario regimenTributario;//Esto es regimen tributario

    @Column(nullable = true)
    private Integer empleadosinformales;//Informales

    @Column(nullable = true)
    private Integer empleadosFormales;//Formales

    private Boolean registroMercantil;

    private String numeroRegistroMercantil;

    @Enumerated(value = EnumType.STRING)
    private Actividades actividades;

    @Enumerated(value = EnumType.STRING)
    private TipoCliente tipoCliente;

//    //Atributos Emprededor
    private String ideaNegocio;

    private String producto;

    //Atibutos para cargar en informe de Diagnostico
    private String paginaWeb;

//    @Enumerated(value = EnumType.STRING)
//    private TrueType trueTypeOfCom;//Esto es el tipo de compañia
    
    
//      ACA VOY A PONER LAS RELACIONES CON CARGA PERESOZA A TODO LO REFERIDO A PROCESOS
    @OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AutoEvaluacion autoEvaluacion;

    @PrePersist
    public void active() {
        this.activo = true;

    }

}
