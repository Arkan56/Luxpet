package com.example.demo.repositorio;


import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entidades.Droga;
import com.example.demo.entidades.DrogaTratamientoCount;
import com.example.demo.entidades.Mascota;
import com.example.demo.entidades.Tratamiento;
import com.example.demo.entidades.Veterinario;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
    List<Tratamiento> findByMascota(Mascota mascota); 
    List<Tratamiento> findByDroga(Droga droga); 
    List<Tratamiento> findByVeterinario(Veterinario veterinario);

    @Query("SELECT t FROM Tratamiento t WHERE t.fecha >= :ultimoMes")
    List<Tratamiento> findTratamientosVendidosUltimoMes(@Param("ultimoMes") LocalDate ultimoMes);

    @Query("SELECT t.droga.nombre AS nombreDroga, COUNT(t) AS cantidadTratamientos " +
       "FROM Tratamiento t " +
       "WHERE t.fecha >= :ultimoMes " +
       "GROUP BY t.droga.nombre")
    List<DrogaTratamientoCount> countTratamientosByDrogaLastMonth(@Param("ultimoMes") LocalDate ultimoMes);

    @Query("SELECT SUM(d.precioVenta) FROM Tratamiento t JOIN t.droga d")
    Double calcularVentasTotales();

    @Query("SELECT SUM(d.precioVenta - d.precioCompra) FROM Tratamiento t JOIN t.droga d")
    Double calcularGananciasTotales();

    @Query("SELECT d FROM Droga d JOIN d.tratamientos t GROUP BY d ORDER BY COUNT(t) DESC")
    List<Droga> findTop3DrogasByUso();

    @Query("SELECT t FROM Tratamiento t WHERE t.mascota.id = :id")
    List<Tratamiento> findTratamientosByMascota(@Param("id") Long id);

}

