package com.example.demo.entidades;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
@Entity
public class Veterinario {
    private String nombre;  
    private int cedula;
    private String contrasenia;
    private String especialidad;
    private String foto;
    private int numAtenciones;
    private boolean estado;

    @JsonIgnoreProperties("veterinario")
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consulta = new ArrayList<>();

    @Id
    @GeneratedValue
    private Long id;

    public Veterinario(String nombre, int cedula, String contrasenia, String especialidad, String fotoURL,
            int numAtenciones) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.contrasenia = contrasenia;
        this.especialidad = especialidad;
        this.foto = fotoURL;
        this.numAtenciones = numAtenciones;
        this.estado = true;
    }


    public Veterinario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
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

    public void setFotoURL(String foto) {
        this.foto = foto;
    }

    public int getNumAtenciones() {
        return numAtenciones;
    }

    public void setNumAtenciones(int numAtenciones) {
        this.numAtenciones = numAtenciones;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
