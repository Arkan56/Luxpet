package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Tratamiento;

@Service
public interface TratamientoService {
    public Tratamiento searchById(Long id);

    public List<Tratamiento> searchAll();
    
    public void deleteById(Long id);

    public Tratamiento update(Tratamiento tratamiento);

    public Tratamiento add(Tratamiento tratamiento);

    public List<Tratamiento> searchByMascotaId(Long id);

    public List<Tratamiento> searchByDrogaId(Long id);

    public List<Tratamiento> searchByVeterinario(Long id);
        
}
