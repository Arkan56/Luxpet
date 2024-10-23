package com.example.demo.repositorio;


import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entidades.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
    List<Tratamiento> findByMascota(Long id); 
    List<Tratamiento> findByDroga(Long id); 
    List<Tratamiento> findByVeterinario(Long id);
}

