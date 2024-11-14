package com.example.demo.entidades;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Cliente {

    private String cedula;
    private String nombre;
    private String correo;
    private String celular;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Mascota> mascotas;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private UserEntity userEntity;

    @Id
    @GeneratedValue
    private Long id;

    public Cliente(Long id, String cedula, String nombre, String correo, String celular) {

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.mascotas = new ArrayList<>();
    }

    public Cliente(String cedula, String nombre, String correo, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.mascotas = new ArrayList<>();
    }

    

}