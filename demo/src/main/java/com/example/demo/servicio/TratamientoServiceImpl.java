package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entidades.Tratamiento;
import com.example.demo.repositorio.TratamientoRepository;

public class TratamientoServiceImpl implements TratamientoService{

    @Autowired
    TratamientoRepository tratamientoRepository;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public void update(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void add(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public List<Tratamiento> searchByMascotaId(Long id) {
        return tratamientoRepository.findByMascota(id);
    }

    @Override
    public List<Tratamiento> searchByDrogaId(Long id) {
        return tratamientoRepository.findByDroga(id);
    }

    @Override
    public List<Tratamiento> searchByVeterinario(Long id) {
        return tratamientoRepository.findByVeterinario(id);
    }
    
}
