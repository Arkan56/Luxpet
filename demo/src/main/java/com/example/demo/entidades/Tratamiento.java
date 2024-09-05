package com.example.demo.entidades;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Tratamiento {

    private LocalDate fecha;

    @ManyToOne
    private Droga droga;

    @OneToOne
    @JoinColumn(name = "Mascotas_id")
    private Mascota mascota;

    @Id
    @GeneratedValue
    private Long id;

    public Tratamiento(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Tratamiento() {

    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    
    
}
