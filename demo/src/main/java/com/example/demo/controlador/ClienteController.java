package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/all")
    public List<Cliente> mostrarClientes() {
        return service.findAll();
    }

    
    @GetMapping("/find/{id}")
    public Cliente mostrarCliente(@PathVariable("id") Long identificacion) {
        return service.findById(identificacion);
    }

    @GetMapping("/cedula/{cedula}")
    public Cliente mostrarClienteByCedula(@PathVariable("cedula") int cedula) {
        return service.findByCedula(cedula);
    }

    
    @GetMapping("/all/{id}/mascotas")
    public List<Mascota> mostrarMascotasCliente(@PathVariable("id") Long identificacion) {
        return mascotaService.findByDuenoId(identificacion);
    }

    
    @GetMapping("/add")
    public String agregarCliente(Model model, @RequestParam("veterinarioId") Long veterinarioId) {
        Cliente cliente = new Cliente(0, "", "", 0);

        model.addAttribute("veterinarioId", veterinarioId);
        model.addAttribute("cliente", cliente);

        return "agregar_cliente";
    }

    
    @PostMapping("/add")
    public void agregarCliente(@RequestBody Cliente cliente) {
        service.add(cliente);
    }

   
    @DeleteMapping("/delete/{id}")
    public void eliminarCliente(@PathVariable("id") Long identificacion) {
        service.deleteById(identificacion);
    }

    
    @GetMapping("/update/{id}")
    public String modificarCliente(Model model, @PathVariable("id") Long identificacion,
            @RequestParam("veterinarioId") Long veterinarioId) {
        model.addAttribute("veterinarioId", veterinarioId);
        model.addAttribute("cliente", service.findById(identificacion));
        return "modificar_cliente";
    }

    
    @PutMapping("/update")
    public void modificarCliente(@RequestBody Cliente cliente) {
        Cliente original = service.findById(cliente.getId());
        cliente.setMascotas(original.getMascotas());
        service.update(cliente);
    }
}
