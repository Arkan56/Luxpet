package com.example.demo.entidades;
import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Tratamiento {

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "droga_id", nullable = true)
    private Droga droga;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
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


    public Droga getDroga() {
        return droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }

    
    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    

    
    
}
