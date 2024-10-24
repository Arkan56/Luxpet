package com.example.demo.repositorio;


import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Droga;
import com.example.demo.entidades.Mascota;
import com.example.demo.entidades.Tratamiento;
import com.example.demo.entidades.Veterinario;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
    List<Tratamiento> findByMascota(Mascota mascota); 
    List<Tratamiento> findByDroga(Droga droga); 
    List<Tratamiento> findByVeterinario(Veterinario veterinario);
}

