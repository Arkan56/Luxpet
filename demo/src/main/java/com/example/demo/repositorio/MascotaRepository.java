package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entidades.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
      List<Mascota> findByClienteId(Long clienteId);

        @Query("SELECT COUNT(m) FROM Mascota m WHERE m.estado = true")
        int mascotasEnTratamiento();

        // Consulta personalizada para contar todas las mascotas
        @Query("SELECT COUNT(m) FROM Mascota m")
        long getTotalMascotas();
}
