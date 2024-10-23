package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.entidades.Veterinario;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.VeterinarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VeterinarioServiceImpl implements VeterinarioService{
    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public Veterinario searchById(Long id) {
        return veterinarioRepository.findById(id).get();
    }

    @Override
    public List<Veterinario> searchAll() {
        return veterinarioRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        veterinarioRepository.deleteById(id);
    }

    @Override
    public Veterinario update(Veterinario veterinario) {
        veterinarioRepository.save(veterinario);
        return veterinario;
    }

    @Override
    public Veterinario add(Veterinario veterinario) {
        veterinarioRepository.save(veterinario);
        return veterinario;
    }

    @Override
    public Veterinario searchByCedula(String cedula) {
        return veterinarioRepository.findByCedula(cedula);
    }
}
