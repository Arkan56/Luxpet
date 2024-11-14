package com.example.demo.controlador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Admin;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Droga;
import com.example.demo.entidades.DrogaTratamientoCount;
import com.example.demo.security.JWTGenerator;
import com.example.demo.servicio.DashBoardService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashBoardController {

    @Autowired
    private DashBoardService dashBoardService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTGenerator jtwGenerator;

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
    
    @PostMapping("/login")
    public ResponseEntity loginAdmin(@RequestBody() Admin admin) {
                Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(admin.getCedula(), admin.getContrasenia()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jtwGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }



    
}
