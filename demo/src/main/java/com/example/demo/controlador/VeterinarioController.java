package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Veterinario;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin("http://localhost:4200")
public class VeterinarioController {
    @Autowired
    VeterinarioService veterinarioService;

    @GetMapping("/all")
    @Operation(summary = "Encuentra a todos los veterinarios")
    public ResponseEntity<List<Veterinario>> mostrarVeterinarios() {
        List<Veterinario> veterinarios = veterinarioService.searchAll();
        ResponseEntity<List<Veterinario>> response = new ResponseEntity<>(veterinarios, HttpStatus.OK);
        return response;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Veterinario> mostrarVeterinario(@PathVariable("id") Long identificacion) {

        Veterinario veterinario = veterinarioService.searchById(identificacion);
        if(veterinario == null){
            return new ResponseEntity<Veterinario>(veterinario, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Veterinario>(veterinario, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Veterinario> agregarVeterinario(@RequestBody Veterinario veterinario) {
        Veterinario newVeterinario = veterinarioService.add(veterinario);

        if(newVeterinario == null){
            return new ResponseEntity<Veterinario>(newVeterinario, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Veterinario>(newVeterinario, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarVeterinario(@PathVariable("id") Long id) {
        veterinarioService.deleteById(id);
        return new ResponseEntity<String>("Veterinario eliminado", HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/update/{id}")
    public void modificarVeterinario(@RequestBody Veterinario veterinario, @PathVariable("id") Long id) {
        veterinarioService.update(veterinario);
    }
}
