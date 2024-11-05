package com.example.demo.entidades;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String raza;
    private int edad;
    private float peso;
    private String foto;
    private String enfermedad;
    private String estado;
    
    @JsonIgnore
    @ManyToOne
    private Cliente cliente;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "Mascota_id", nullable = true)
    private List<Tratamiento> tratamiento;

    public Mascota(String nombre, String raza, int edad, float peso, String foto, String enfermedad, String estado) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.foto = foto;
        this.enfermedad = enfermedad;
        this.estado = estado;
    }

    
}
