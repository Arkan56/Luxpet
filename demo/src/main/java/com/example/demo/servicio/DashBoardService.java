package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.Droga;
import com.example.demo.entidades.DrogaTratamientoCount;
import com.example.demo.entidades.Tratamiento;

public interface DashBoardService {
    public long numTratamientos();
    public List<DrogaTratamientoCount> numTratamientosPorDroga();
    public long numVetActivos();
    public long numVetInactivos();
    public long numMascotas();
    public long numMascotasActivas();
    public long numMascotasInactivas();
    public List<Droga> numDrogas();
    public double ventasTotales();
    public double gananciasTotales();
    public List<Droga> top3DrogasTratamientos();
}
