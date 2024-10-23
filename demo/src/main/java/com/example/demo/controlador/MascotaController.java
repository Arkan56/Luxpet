package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;

import io.swagger.v3.oas.annotations.Operation;

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

@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    @Operation(summary = "Encuentra a todos las mascotas")
    public ResponseEntity<List<Mascota>> mostrarMascotas() {
        List<Mascota> mascotas = mascotaService.searchAll();
        ResponseEntity<List<Mascota>> response = new ResponseEntity<>(mascotas, HttpStatus.OK);
        return response;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Mascota> mostrarMascota(@PathVariable("id") Long identificacion) {
        Mascota mascota = mascotaService.searchById(identificacion);
        
        if(mascota == null){
            return new ResponseEntity<Mascota>(mascota, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Mascota>(mascota, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Mascota> agregarMascota(@RequestBody Mascota mascota, @RequestParam String cedula) throws Exception {
        Mascota newMascota = mascotaService.add(mascota);

        if(newMascota == null){
            return new ResponseEntity<Mascota>(newMascota, HttpStatus.BAD_REQUEST);
        }
        clienteService.addMascota(mascota.getCliente().getCedula(), mascota);
        return new ResponseEntity<Mascota>(newMascota, HttpStatus.CREATED);
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
        return new ResponseEntity<>("Mascota eliminada", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
public ResponseEntity<Mascota> modificarMascota(@RequestBody Mascota mascota, @PathVariable("id") Long id,
                             @RequestParam String clienteSeleccionado) {
    // Buscar la mascota por ID
    Mascota mascotaFind = mascotaService.searchById(id);
    
    // Si la mascota no se encuentra, devolver un error
    if (mascotaFind == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar la mascota antigua del cliente
    clienteService.deleteMascota(mascotaFind.getCliente().getCedula(), id);

    // Buscar el nuevo cliente por cédula
    Cliente nuevoCliente = clienteService.searchByCedula(clienteSeleccionado);
    
    // Si el cliente no se encuentra, devolver un error
    if (nuevoCliente == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Asociar la mascota actualizada con el nuevo cliente
    mascota.setCliente(nuevoCliente);
    
    // Actualizar la mascota
    Mascota mascotaActualizada = mascotaService.update(mascota);
    
    // Añadir la mascota al nuevo cliente
    clienteService.addMascota(clienteSeleccionado, mascotaActualizada);
    
    // Devolver la respuesta con la mascota actualizada
    return new ResponseEntity<>(mascotaActualizada, HttpStatus.OK);
}

}
