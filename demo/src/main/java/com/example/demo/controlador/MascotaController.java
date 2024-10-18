package com.example.demo.controlador;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public List<Mascota> verMascotas() {
        return mascotaService.findAll();
    }

    // http://localhost:8080/mascotas/buscar/{id}
    @GetMapping("/find/{id}")
    public Mascota mostrarMascota(@PathVariable("id") Long identificacion) {
        return mascotaService.findById(identificacion);
    }

    // http://localhost:8080/mascotas/agregar
    @GetMapping("/add")
    public String agregarMascota(Model model, @ModelAttribute("veterinarioId") Long veterinarioId) {
        model.addAttribute("veterinarioId", veterinarioId);
        Mascota mascota = new Mascota("", "", 0, 0, "", "");
        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.findAll());
        return "agregar_mascota";
    }

    private static final Logger logger = LoggerFactory.getLogger(MascotaController.class);

    
    @PostMapping("/add")
    public void agregarMascotaForm(@RequestBody Mascota mascota) {
        // Usar el logger para imprimir los detalles de la mascota
        logger.info("Mascota recibida: {}", mascota);
        logger.info("Cliente: {}", mascota.getCliente());

        // Guardar la mascota
        mascotaService.add(mascota);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarMascota(@PathVariable("id") Long identificacion) {
        mascotaService.deleteById(identificacion);
    }

    
    @GetMapping("/update/{id}")
    public String modificarMascota(Model model, @PathVariable("id") Long identificacion) {
        Mascota mascota = mascotaService.findById(identificacion);
        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.findAll());
        return "modificar_mascota";
    }

    @PutMapping("/update")
    public void modificarMascota(@RequestBody Mascota mascota) {
        mascotaService.update(mascota);
    }

    
    @GetMapping("/total")
    public ResponseEntity<Long> getTotalMascotas() {
        long total = mascotaService.getTotalMascotas();
        return ResponseEntity.ok(total);
    }

    // http://localhost:8080/mascotas/en-tratamiento
    @GetMapping("/en-tratamiento")
    public ResponseEntity<Long> mascotasEnTratamiento() {
        long totalEnTratamiento = mascotaService.mascotasEnTratamiento();
        return ResponseEntity.ok(totalEnTratamiento);
    }
}
