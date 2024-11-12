package com.example.demo.entidades;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private UserEntity user;
     @Column(name = "PK_ID")
    @Id
    @GeneratedValue
    private Long id;

    private String cedula;
    private String nombre;
    private String correo;
    private String celular;
    
       @JsonIgnoreProperties("cliente")
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas = new ArrayList<>();
   

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