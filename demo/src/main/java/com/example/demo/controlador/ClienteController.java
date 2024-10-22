package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    @Operation(summary = "Encuentra a todos los clientes")
    public ResponseEntity<List<Cliente>> mostrarClientes(Model model) {
        List<Cliente> clientes = clienteService.searchAll();
        ResponseEntity<List<Cliente>> response = new ResponseEntity<>(clientes, HttpStatus.OK);
        return response;
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Cliente> mostrarCliente(Model model, @PathVariable("id") Long identificacion) {
        Cliente cliente = clienteService.searchById(identificacion);
        
        if(cliente == null){
            return new ResponseEntity<Cliente>(cliente, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.add(cliente);

        if(newCliente == null){
            return new ResponseEntity<Cliente>(newCliente, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Cliente>(newCliente, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
        return new ResponseEntity<>("Cliente eliminado", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> modificarCliente(@RequestBody Cliente cliente, @PathVariable("id") Long id) {
     
        Cliente clientFind = clienteService.searchById(id);
        cliente.setId(clientFind.getId());
        Cliente clienteUpdated = clienteService.update(cliente);
        return new ResponseEntity<>(clienteUpdated, HttpStatus.OK);

    }

}