package com.example.demo.entidades;

public class DrogaTratamientoCount {
    private String nombreDroga;
    private Long cantidadTratamientos;

    public DrogaTratamientoCount(String nombreDroga, Long cantidadTratamientos) {
        this.nombreDroga = nombreDroga;
        this.cantidadTratamientos = cantidadTratamientos;
    }

    public String getNombreDroga() {
        return nombreDroga;
    }

    public Long getCantidadTratamientos() {
        return cantidadTratamientos;
    }
}

