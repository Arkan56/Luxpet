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
    ClienteService clienteService;

    @GetMapping("/all")
    public List<Cliente> mostrarClientes(Model model) {
        return clienteService.searchAll();
    }

    @GetMapping("/find/{id}")
    public Cliente mostrarCliente(Model model, @PathVariable("id") Long identificacion) {

        Cliente cliente = clienteService.searchById(identificacion);
        System.out.println(cliente.toString());

        if (cliente != null) {
            //model.addAttribute("cliente", clienteService.searchById(identificacion));
            //return clienteService.searchById(identificacion);
        } else {
            // throw new NotFoundException(identificacion);
        }
        return cliente;
    }

    @PostMapping("/add")
    public void agregarCliente(@RequestBody Cliente cliente) {
        clienteService.add(cliente);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void modificarCliente(@RequestBody Cliente cliente, @PathVariable("id") int id) {
        clienteService.update(cliente);
    }
    @GetMapping("/findByEmail/{email}")
    public Cliente mostrarClientePorCorreo(@PathVariable("email") String correo) {
        return clienteService.searchByCorreo(correo);
    }

    @GetMapping("/findByCelular/{celular}")
    public Cliente mostrarClientePorCelular(@PathVariable("celular") String celular) {
    return clienteService.searchByCelular(celular);
    }
    @GetMapping("/findByClientesSinMascotas")
    public List<Cliente> mostrarClientesSinMascotas() {
    return clienteService.searchByClientesSinMascotas();
    }

    @GetMapping("/findByNombreAndCorreo/{nombre}/{correo}")
    public Cliente mostrarClientePorNombreYCorreo(@PathVariable("nombre") String nombre, @PathVariable("correo") String correo) {
    return clienteService.searchByNombreAndCorreo(nombre, correo);
    }
    
     // Nuevo endpoint: Buscar clientes por dominio de correo
     @GetMapping("/findByCorreo/{dominio}")
     public List<Cliente> mostrarClientesPorCorreo(@PathVariable("dominio") String dominio) {
         return clienteService.searchByCorreoContaining(dominio);
     }

}