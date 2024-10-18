package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    Veterinario findByCedula(int cedula);
     @Query("SELECT v FROM Veterinario v JOIN Consulta c ON c.veterinario = v WHERE c.mascota.id = :mascotaId")
    Veterinario findVeterinarioByMascotaId(@Param("mascotaId") Long mascotaId);

    int countByEstado(boolean estado);
    
}
