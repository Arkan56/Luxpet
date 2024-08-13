package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Mascota;

public interface MascotaService {
    public Mascota searchById(int id);
    public Collection<Mascota> searchAll();

}
