package com.example.demo.entidades;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder
@NoArgsConstructor
public class Veterinario {
    private String cedula;
    @Transient
    private String contrasenia;
    private String especialidad;
    private String foto;
    private int numAtenciones;
    private String nombre;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "Veterinario_id", nullable = true)
    private List<Tratamiento> tratamiento;

    @OneToOne(cascade=CascadeType.ALL)
    @JsonIgnore
    private UserEntity userEntity;

    @Id
    @GeneratedValue
    private Long id;

    public Veterinario(String cedula, String contrasenia, String especialidad, String foto, int numAtenciones, String nombre) {
        this.cedula = cedula;
        this.contrasenia = contrasenia;
        this.especialidad = especialidad;
        this.foto = foto;
        this.numAtenciones = numAtenciones;
        this.nombre = nombre;
    }

    public Veterinario(String cedula, String contrasenia, String especialidad, String foto, int numAtenciones, String nombre, List<Tratamiento> tratamiento, UserEntity userEntity, Long id) {
        this.cedula = cedula;
        this.contrasenia = contrasenia;
        this.especialidad = especialidad;
        this.foto = foto;
        this.numAtenciones = numAtenciones;
        this.nombre = nombre;
        this.tratamiento = tratamiento;
        this.userEntity = userEntity;
        this.id = id;
    }

    

    
}
