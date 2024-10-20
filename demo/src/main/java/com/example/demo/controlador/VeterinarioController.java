package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/veterinario")
@CrossOrigin("http://localhost:4200")
public class VeterinarioController {
    @Autowired
    VeterinarioService veterinarioService;

    @GetMapping("/all")
    public List<Veterinario> mostrarVeterinarios() {
        return veterinarioService.searchAll();
    }

    @GetMapping("/find/{id}")
    public Veterinario mostrarVeterinario(@PathVariable("id") Long identificacion) {

        Veterinario veterinario = veterinarioService.searchById(identificacion);

        if (veterinario != null) {
            //model.addAttribute("cliente", clienteService.searchById(identificacion));
            //return clienteService.searchById(identificacion);
        } else {
            // throw new NotFoundException(identificacion);
        }
        return veterinario;
    }

    @PostMapping("/add")
    public void agregarVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarVeterinario(@PathVariable("id") Long id) {
        veterinarioService.deleteById(id);
    }
    
    @PutMapping("/update/{id}")
    public void modificarVeterinario(@RequestBody Veterinario veterinario, @PathVariable("id") Long id) {
        veterinarioService.update(veterinario);
    }
}
