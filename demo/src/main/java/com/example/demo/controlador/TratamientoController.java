package com.example.demo.controlador;

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
import com.example.demo.entidades.Droga;
import com.example.demo.entidades.Tratamiento;
import com.example.demo.servicio.DrogaService;
import com.example.demo.servicio.TratamientoService;
import java.util.List;

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {
    @Autowired
    TratamientoService tratamientoService;

    @GetMapping("/all")
    public ResponseEntity<List<Tratamiento>> mostrarTratamientos() {

        List<Tratamiento> tratamientos = tratamientoService.searchAll();

        ResponseEntity<List<Tratamiento>> response  = new ResponseEntity<>(tratamientos, HttpStatus.OK);

        return response;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Tratamiento> mostrarTratamiento(@PathVariable("id") Long identificacion) {

        Tratamiento tratamiento = tratamientoService.searchById(identificacion);

        if(tratamiento == null){
            return new ResponseEntity<Tratamiento>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Tratamiento>(tratamiento, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Tratamiento> agregarTratamiento(@RequestBody Tratamiento tratamiento) {
        Tratamiento newTratamiento = tratamientoService.add(tratamiento);

        if(newTratamiento == null){
            return new ResponseEntity<Tratamiento>(newTratamiento, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Tratamiento>(newTratamiento, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarTratamiento(@PathVariable("id") Long id) {
        tratamientoService.deleteById(id);
        return new ResponseEntity<>("DELETED", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tratamiento> modificarTratamiento(@RequestBody Tratamiento tratamiento, @PathVariable("id") Long id) {
        
        Tratamiento tratamientoFind = tratamientoService.searchById(id);
        tratamiento.setId(tratamientoFind.getId());
        Tratamiento tramientoUpdated = tratamientoService.update(tratamiento);

        return new ResponseEntity<>(tramientoUpdated, HttpStatus.OK);
    }
    
}
