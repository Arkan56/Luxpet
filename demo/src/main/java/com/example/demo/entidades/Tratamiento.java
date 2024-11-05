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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

   

    

    

    
    
}
