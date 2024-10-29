package com.example.demo.servicio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Droga;
import com.example.demo.entidades.DrogaTratamientoCount;
import com.example.demo.entidades.Mascota;
import com.example.demo.entidades.Tratamiento;
import com.example.demo.entidades.Veterinario;
import com.example.demo.repositorio.DrogaRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.repositorio.VeterinarioRepository;

@Service
public class DashBoardServiceImpl implements DashBoardService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;


    

    @Override
    public long numTratamientos() {
        LocalDate ultimoMes = LocalDate.now().minusMonths(1);

        List<Tratamiento> tratamientos = tratamientoRepository.findTratamientosVendidosUltimoMes(ultimoMes);
        return tratamientos.size();
        
    }

    @Override
    public List<DrogaTratamientoCount> numTratamientosPorDroga() {
        LocalDate ultimoMes = LocalDate.now().minusMonths(1);
        List<DrogaTratamientoCount> resultados = tratamientoRepository.countTratamientosByDrogaLastMonth(ultimoMes);
        return resultados;
    }

    @Override
    public long numVetActivos() {
        List<Veterinario> veterinarios = veterinarioRepository.findAll();
        return veterinarios.size();   
    }

    @Override
    public long numVetInactivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numVetInactivos'");
    }

    @Override
    public long numMascotasActivas() {
        return mascotaRepository.countMascotasActivas("Activo");
    }

    @Override
    public long numMascotasInactivas() {
        return mascotaRepository.countMascotasActivas("Inactivo");
    }

    @Override
    public List<Droga> numDrogas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numDrogas'");
    }

    @Override
    public long numMascotas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numMascotas'");
    }

    @Override
    public double ventasTotales() {
        return tratamientoRepository.calcularVentasTotales();
    }

    @Override
    public double gananciasTotales() {
        return tratamientoRepository.calcularGananciasTotales();
    }

    @Override
    public List<Droga> top3DrogasTratamientos() {
        List<Droga> drogas = tratamientoRepository.findTop3DrogasByUso();
        List<Droga> aux = drogas.subList(0, 3);
        return aux;
    }
    
}
