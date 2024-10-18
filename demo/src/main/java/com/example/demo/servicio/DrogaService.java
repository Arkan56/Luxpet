package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Droga;

@Service
public interface DrogaService {

    public Droga findById(Long id);

    public List<Droga> findAll();

    public void add(Droga droga);

    public void deleteById(Long id);

    public void update(Droga droga);

    public Double getVentasTotales();

    public Double getGananciasTotales();

    public List<Object[]> getTopTratamientos();
}