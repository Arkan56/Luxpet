package com.example.demo.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.entidades.Veterinario;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.VeterinarioRepository;

import jakarta.persistence.EntityNotFoundException;
@Service

public class VeterinarioServiceImpl implements VeterinarioService {
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
    // Obtener el cliente por su ID
    Veterinario veterinario = veterinarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

    // Obtener la lista de mascotas asociadas al cliente
    List<Mascota> mascotas = veterinario.getMascotas();

    // Borrar cada mascota de la lista
    for (Mascota mascota : mascotas) {
        mascotaRepository.deleteById(mascota.getId());
    }

    // Borrar el cliente
    veterinarioRepository.deleteById(id);
}

    @Override
    public void update(Veterinario veterinario) {
        veterinarioRepository.save(veterinario);
    }

    @Override
    public void add(Veterinario veterinario) {
        veterinarioRepository.save(veterinario);
    }

    @Override
    public Veterinario searchByCedula(String cedula) {
        return veterinarioRepository.findByCedula(cedula);
    }

    @Override
    public void addMascota(String cedula, Mascota mascota){
        Veterinario veterinario = veterinarioRepository.findByCedula(cedula);
        veterinario.getMascotas().add(mascota);
        veterinarioRepository.save(veterinario);
    }

    @Override
    public void deleteMascota(String cedula, Long id){
        Veterinario veterinario = veterinarioRepository.findByCedula(cedula);
        veterinario.getMascotas().removeIf(mascota -> mascota.getId() == id);
        veterinarioRepository.save(veterinario);
    }
    
}
