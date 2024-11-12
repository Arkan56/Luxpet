package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOS.AdminDTO;
import com.example.demo.DTOS.AdminMapper;
import com.example.demo.DTOS.VeterinarioDTO;
import com.example.demo.DTOS.VeterinarioMapper;
import com.example.demo.entidades.Admin;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.LoginRequest;
import com.example.demo.entidades.Veterinario;
import com.example.demo.security.JWTGenerator;
import com.example.demo.servicio.AdminService;
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

    @Autowired
    AdminService adminService;


       @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator JWTGenerator;

    @PostMapping("/loginVeterinario")
    public ResponseEntity confirmarLoginVet(@RequestBody LoginRequest loginRequest) {
        Veterinario vet = vetService.searchByCedula(loginRequest.getCedula());
        
        if (vet == null) {
            return new ResponseEntity<>(("Usuario no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        VeterinarioDTO vetDTO = VeterinarioMapper.INSTANCE.convert(vet);
        if (vet.getContrasenia().equals(loginRequest.getPassword())) {
            return new ResponseEntity<>(vetDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(vetDTO, HttpStatus.BAD_REQUEST);
        }
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

    @PostMapping("/loginAdmin")
    public ResponseEntity confirmarLoginAdmin(@RequestBody LoginRequest loginRequest) {
        Admin admin = adminService.searchByCedula(loginRequest.getCedula());
        
        if (admin == null) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
        
        AdminDTO adminDTO = AdminMapper.INSTANCE.convert(admin);
        if (admin.getContrasenia().equals(loginRequest.getPassword())) {
            return new ResponseEntity<>(adminDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(adminDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<Admin> buscarAdministrador() {
        Admin administrador = adminService.searchByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );
        
        if (administrador == null) {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Admin>(administrador, HttpStatus.OK);
    }



}
