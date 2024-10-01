package com.example.demo.entidades;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
@Entity
public class Veterinario {
    private String cedula;
    private String contrasenia;
    private String especialidad;
    private String foto;
    private int numAtenciones;

    @JsonIgnore
    @OneToMany (mappedBy = "veterinario")
    private List<Mascota> mascotas = new ArrayList<>();

    @Id
    @GeneratedValue
    private Long id;

    public Veterinario(String cedula, String contrasenia, String especialidad, String foto, int numAtenciones) {
        this.cedula = cedula;
        this.contrasenia = contrasenia;
        this.especialidad = especialidad;
        this.foto = foto;
        this.numAtenciones = numAtenciones;
    }

    public Veterinario() {

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getNumAtenciones() {
        return numAtenciones;
    }

    public void setNumAtenciones(int numAtenciones) {
        this.numAtenciones = numAtenciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
}
