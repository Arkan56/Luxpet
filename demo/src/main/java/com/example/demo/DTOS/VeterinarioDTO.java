package com.example.demo.DTOS;

import lombok.Data;

@Data
public class VeterinarioDTO {
    private String cedula;
    private String especialidad;
    private String foto;
    private String numAtenciones;
    private String nombre;
    private Long id;
}
