package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.LoginRequest;
import com.example.demo.entidades.Veterinario;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    ClienteService service;

    @Autowired
    VeterinarioService vetService;

    @PostMapping("/loginveterinario")
    public Veterinario confirmarLoginVet(@RequestBody LoginRequest loginRequest) {
        Veterinario vet = vetService.searchByCedula(loginRequest.getCedula());
        if (vet != null && vet.getContrasenia().equals(loginRequest.getPassword())) {
            return vet;
        }
        return null;    
    }

    @PostMapping("/logincliente")
    public Cliente confirmarLogin(@RequestBody String cedula) {
        Cliente aux = service.searchByCedula(cedula);
        return aux; //SI encuentra el usuario lo devuelve, de lo contrario es null
    }
}
