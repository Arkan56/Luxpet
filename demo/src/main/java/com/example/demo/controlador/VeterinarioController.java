package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Veterinario;
import com.example.demo.servicio.VeterinarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {
    @Autowired
    VeterinarioService veterinarioService; @GetMapping("/{id}")
    public Veterinario home(@PathVariable("id") Long id) {
        return veterinarioService.findById(id);
    }

   

    @GetMapping("/all")
    public List<Veterinario> mostrarVeterinarios() {
        return veterinarioService.findAll();
    }

    
    @GetMapping("/find/{cedula}")
    public Veterinario mostrarClienteByCedula(@PathVariable("cedula") int cedula) {
        return veterinarioService.findByCedula(cedula);
    }

    
    @GetMapping("/add")
    public String agregar(Model model) {
        Veterinario veterinario = new Veterinario("", 0, "", "", "", 0);

        model.addAttribute("veterinario", veterinario);

        return "agregar_vet";
    }

    
    @PostMapping("/add")
    public void agregar(@RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
    }

    
    @GetMapping("/update/{id}")
    public String modificar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("veterinario", veterinarioService.findById(id));
        return "modificar_vet";
    }

    
    @PutMapping("/update")
    public void modificar(@RequestBody Veterinario veterinario) {
        Veterinario original = veterinarioService.findById(veterinario.getId());
        veterinario.setConsulta(original.getConsulta());
        veterinarioService.update(veterinario);
    }

    
    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        veterinarioService.deleteById(id);
    }

   
    @GetMapping("/activosInactivos")
    public Map<String, Integer> getActivosInactivos() {
        Map<String, Integer> response = new HashMap<>();
        response.put("activos", veterinarioService.countByEstado(true));
        response.put("inactivos", veterinarioService.countByEstado(false));
        return response;
    }
}
