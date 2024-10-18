package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Mascota;

@Service
public interface MascotaService {

    public Mascota findById(Long id);

    public List<Mascota> findAll();

    public List<Mascota> findByDuenoId(Long clienteId);

    public void add(Mascota mascota);

    public void deleteById(Long id);

    public Mascota update(Mascota mascota);

    public int mascotasEnTratamiento();

    public long getTotalMascotas();
}