package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.LoginRequest;
import com.example.demo.entidades.Veterinario;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.VeterinarioService;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    ClienteService service;

    @Autowired
    VeterinarioService vetService;

    @PostMapping("/loginVeterinario")
    public ResponseEntity<Veterinario> confirmarLoginVet(@RequestBody LoginRequest loginRequest) {
        Veterinario vet = vetService.searchByCedula(loginRequest.getCedula());
        if(vet != null && vet.getContrasenia().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(vet);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> confirmarLogin(@RequestBody LoginRequest loginRequest) {
        Cliente aux = service.searchByCedula(loginRequest.getCedula());
        if(aux != null){
            return ResponseEntity.ok(aux);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
