package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.Droga;
import com.example.demo.entidades.Tratamiento;

public interface DrogaService {
    public Droga searchById(Long id);

    public List<Droga> searchAll();
    
    public void deleteById(Long id);

    public void update(Droga droga);

    public void add(Droga droga);
}
