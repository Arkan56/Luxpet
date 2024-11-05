package com.example.demo.entidades;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Droga {
    private String nombre;
    private float precioCompra;
    private float precioVenta;
    private int unidadesDisponibles;
    private int unidadesVendidas;
    
    @JsonIgnore
    @OneToMany(mappedBy = "droga")
    private List<Tratamiento> tratamientos = new ArrayList<>();



    @Id
    @GeneratedValue
    private Long id;

    public Droga(String nombre, float precioCompra, float precioVenta, int unidadesDisponibles, int unidadesVendidas) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesVendidas = unidadesVendidas;
    }

 

   

    
}
