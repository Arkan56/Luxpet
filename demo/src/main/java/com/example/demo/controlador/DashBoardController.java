package com.example.demo.controlador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Droga;
import com.example.demo.entidades.DrogaTratamientoCount;
import com.example.demo.servicio.DashBoardService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashBoardController {

    @Autowired
    private DashBoardService dashBoardService;


    @GetMapping("/nTratamientos")
    public long numTratamientos() {
        return dashBoardService.numTratamientos();
    }

    @GetMapping("/nTratamientosPorDroga")
    public List<DrogaTratamientoCount> numTratamientosPorDroga() {
        return dashBoardService.numTratamientosPorDroga();
    }

    @GetMapping("/nVetActivos")
    public long numVetActivos() {
        return dashBoardService.numVetActivos();
    }

    @GetMapping("/nMascotasActivas")
    public long numMascotas() {
        return dashBoardService.numMascotasActivas();
    }

    @GetMapping("/nMascotasInactivas")
    public long numMascotasInactivas() {
        return dashBoardService.numMascotasInactivas();
    }

    @GetMapping("/ventasTotales")
    public double ventasTotales() {
        return dashBoardService.ventasTotales();
    }

    @GetMapping("/gananciaTotales")
    public double gananciaTotales() {
        return dashBoardService.gananciasTotales();
    }

    @GetMapping("/top3Drogas")
    public List<Droga> top3Drogas() {
        return dashBoardService.top3DrogasTratamientos();
    }
    



    
}
