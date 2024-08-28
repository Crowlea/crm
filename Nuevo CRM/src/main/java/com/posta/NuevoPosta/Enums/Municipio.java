/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.posta.NuevoPosta.Enums;

/**
 *
 * @author crowl
 */
public enum Municipio {
    
    META_2(2, "Meta", "Acacías"),
    META_84(84, "Meta", "Barraca de Upía"),
    META_133(133, "Meta", "Cabuyaro"),
    VAUPES_174(174, "Vaupés", "Carurú"),
    META_176(176, "Meta", "Castilla la Nueva"),
    META_253(253, "Meta", "Cubarral"),
    META_259(259, "Meta", "Cumaral"),
    VICHADA_260(260, "Vichada", "Cumaribo"),
    META_289(289, "Meta", "El Calvario"),
    META_294(294, "Meta", "El Castillo"),
    META_301(301, "Meta", "El Dorado"),
    META_351(351, "Meta", "Fuente de Oro"),
    META_379(379, "Meta", "Granada"),
    META_394(394, "Meta", "Guamal"),
    GUAINIA_433(433, "Guainía", "Inírida"),
    META_469(469, "Meta", "La Macarena"),
    VICHADA_480(480, "Vichada", "La Primavera"),
    META_501(501, "Meta", "Lejanías"),
    META_536(536, "Meta", "Mapiripan"),
    META_554(554, "Meta", "Mesetas"),
    VAUPES_560(560, "Vaupés", "Mitú"),
    CUNDINAMARCA_646(646, "Cundinamarca", "Paratebueno"),
    VICHADA_697(697, "Vichada", "Puerto Carreño"),
    META_699(699, "Meta", "Puerto Concordia"),
    META_701(701, "Meta", "Puerto Gaitán"),
    META_705(705, "Meta", "Puerto Lleras"),
    META_706(706, "Meta", "Puerto López"),
    META_711(711, "Meta", "Purto Rico"),
    META_741(741, "Meta", "Restrepo"),
    META_802(802, "Meta", "San Carlos de Guaroa"),
    META_826(826, "Meta", "San Juan de Arama"),
    META_833(833, "Meta", "San Juanito"),
    META_841(841, "Meta", "San Martín"),
    VICHADA_886(886, "Vichada", "Santa Rosalía"),
    VAUPES_964(964, "Vaupés", "Taraira"),
    META_1032(1032, "Meta", "Uribe"),
    META_1070(1070, "Meta", "Villavicencio"),
    META_1075(1075, "Meta", "Vista Hermosa");

    private final int codigo;
    private final String distrito;
    private final String municipio;

    Municipio(int codigo, String distrito, String municipio) {
        this.codigo = codigo;
        this.distrito = distrito;
        this.municipio = municipio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getMunicipio() {
        return municipio;
    }
    
}
