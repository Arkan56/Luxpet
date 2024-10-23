package com.example.demo.controlador;

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
import com.example.demo.entidades.Droga;
import com.example.demo.entidades.Tratamiento;
import com.example.demo.servicio.DrogaService;
import com.example.demo.servicio.TratamientoService;
import java.util.List;

@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {
    @Autowired
    TratamientoService tratamientoService;

    @GetMapping("/all")
    public List<Tratamiento> mostrarTratamientos() {
        return tratamientoService.searchAll();
    }

    @GetMapping("/find/{id}")
    public Tratamiento mostrarTratamiento(@PathVariable("id") Long identificacion) {

        Tratamiento tratamiento = tratamientoService.searchById(identificacion);

        if (tratamiento != null) {
            //model.addAttribute("cliente", clienteService.searchById(identificacion));
            //return clienteService.searchById(identificacion);
        } else {
            // throw new NotFoundException(identificacion);
        }
        return tratamiento;
    }

    @PostMapping("/add")
    public void agregarTratamiento(@RequestBody Tratamiento tratamiento) {
        tratamientoService.add(tratamiento);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarTratamiento(@PathVariable("id") Long id) {
        tratamientoService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void modificarTratamiento(@RequestBody Tratamiento tratamiento, @PathVariable("id") int id) {
        tratamientoService.update(tratamiento);
    }
    
}
