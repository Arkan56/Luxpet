package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Veterinario;

@Service
public interface VeterinarioService {

    public Veterinario findById(Long id);

    public Veterinario findByCedula(int cedula);

    public List<Veterinario> findAll();

    public void add(Veterinario veterinario);

    public void deleteById(Long id);

    public void update(Veterinario veterinario);

    public int countByEstado(boolean estado);
}
