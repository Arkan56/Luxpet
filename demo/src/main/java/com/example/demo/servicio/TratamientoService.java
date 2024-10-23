package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.Tratamiento;

public interface TratamientoService {
    public Tratamiento searchById(Long id);

    public List<Tratamiento> searchAll();
    
    public void deleteById(Long id);

    public void update(Tratamiento tratamiento);

    public void add(Tratamiento tratamiento);

    public List<Tratamiento> searchByMascotaId(Long id);

    public List<Tratamiento> searchByDrogaId(Long id);

    public List<Tratamiento> searchByVeterinario(Long id);
        
}
