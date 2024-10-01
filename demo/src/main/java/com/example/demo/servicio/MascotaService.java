package com.example.demo.servicio;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Mascota;

public interface MascotaService {
    public Mascota searchById(Long id);

    public List<Mascota> searchAll();

    public void deleteById(Long id);

    public void update(Mascota mascota);

    public void add(Mascota mascota);
}
