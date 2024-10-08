package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Droga;
import com.example.demo.entidades.Mascota;
import com.example.demo.repositorio.DrogaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DrogaServiceImpl implements DrogaService {
    @Autowired
    DrogaRepository drogaRepository;
    
    @Override
    public Droga searchById(Long id) {
        return drogaRepository.findById(id).get();
    }

    @Override
    public List<Droga> searchAll() {
        return drogaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        drogaRepository.deleteById(id); 
    }

    @Override
    public void update(Droga droga) {
        drogaRepository.save(droga);
    }

    @Override
    public void add(Droga droga) {
        drogaRepository.save(droga);
    }
}
