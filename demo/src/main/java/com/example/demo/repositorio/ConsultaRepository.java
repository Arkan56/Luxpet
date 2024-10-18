package com.example.demo.repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
      List<Consulta> findByMascotaId(Long mascotaId);
    
    @Query("SELECT d.nombre, SUM(c.cantidad) FROM Consulta c " +
       "JOIN c.droga d " +
       "WHERE c.fechaConsulta >= :inicio AND c.fechaConsulta <= :fin " +
       "GROUP BY d.nombre")
    List<Object[]> getCantidadTratamientosPorDroga(java.util.Date fechas, java.util.Date fechas2);
    Long countTratamientosUltimoMes(java.util.Date inicioMes, java.util.Date finMes);

    


    
}