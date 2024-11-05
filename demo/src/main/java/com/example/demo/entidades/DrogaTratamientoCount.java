package com.example.demo.entidades;

import lombok.Data;

@Data
public class DrogaTratamientoCount {
    private String nombreDroga;
    private Long cantidadTratamientos;

    public DrogaTratamientoCount(String nombreDroga, Long cantidadTratamientos) {
        this.nombreDroga = nombreDroga;
        this.cantidadTratamientos = cantidadTratamientos;
    }

}

