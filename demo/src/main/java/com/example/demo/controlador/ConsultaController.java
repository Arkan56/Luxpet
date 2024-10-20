package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Consulta;

@RestController
@RequestMapping("/consultas")
@CrossOrigin("http://localhost:4200")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/ver")
    public List<Consulta> verConsultas() {
        return consultaService.findAll();
    }
    @GetMapping("/ver/{id}")
    public Consulta verConsulta(@PathVariable Long id) {
        return consultaService.findById(id);
    }

    @PostMapping("/agregar")
    public void agregar(@RequestBody Consulta consulta) {
        consultaService.add(consulta);

    }

    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id) {
        consultaService.deleteById(id);

    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody Consulta consulta) {
        consultaService.update(consulta);

    }

    @GetMapping("/mascota/{mascotaId}")
    public List<Consulta> getConsultasByMascota(@PathVariable Long mascotaId) {
        return (List<Consulta>) consultaService.findById(mascotaId);
    }
}