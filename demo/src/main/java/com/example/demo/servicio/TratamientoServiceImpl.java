package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Droga;
import com.example.demo.entidades.Mascota;
import com.example.demo.entidades.Tratamiento;
import com.example.demo.entidades.Veterinario;
import com.example.demo.repositorio.TratamientoRepository;
@Service
public class TratamientoServiceImpl implements TratamientoService{

    @Autowired
    TratamientoRepository tratamientoRepository;

    @Autowired
    MascotaService mascotaService;

    @Autowired
    DrogaService drogaService;

    @Autowired
    VeterinarioService veterinarioService;

    @Override
    public Tratamiento searchById(Long id) {
        return tratamientoRepository.findById(id).get();
    }

    @Override
    public List<Tratamiento> searchAll() {
        return tratamientoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        tratamientoRepository.deleteById(id);
    }

    @Override
    public Tratamiento update(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
        return tratamiento;
    }

    @Override
    public Tratamiento add(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
        return tratamiento;
    }

    @Override
    public List<Tratamiento> searchByMascotaId(Long id) {

        Mascota mascota = mascotaService.searchById(id);

        return tratamientoRepository.findByMascota(mascota);
    }

    @Override
    public List<Tratamiento> searchByDrogaId(Long id) {

        Droga droga = drogaService.searchById(id);

        return tratamientoRepository.findByDroga(droga);
    }

    @Override
    public List<Tratamiento> searchByVeterinario(Long id) {

        Veterinario veterinario = veterinarioService.searchById(id);

        return tratamientoRepository.findByVeterinario(veterinario);
    }
    
}
