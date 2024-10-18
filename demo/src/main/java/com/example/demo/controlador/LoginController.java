package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Cliente;
import com.example.demo.servicio.ClienteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    ClienteService service;

    /*
    @GetMapping("/")
    public String mostrarLogin(Model model) {
        model.addAttribute("cedula", "");
        return "inicioSesion";
    }*/

    /*
    @GetMapping("/loginVeterinario")
    public String mostrarPortalVet(Model model) {
        model.addAttribute("cedula", "");
        model.addAttribute("password", "");
        return "inicioSesionVeterinario";
    }*/

    @PostMapping("/loginVeterinario")
    public String confirmarLoginVet() {
        return "redirect:/cliente/all";
    }

    @PostMapping("/")
    public Cliente confirmarLogin(@RequestBody String cedula) {
        Cliente aux = service.findByCedula(Integer.parseInt(cedula));
        return aux; //SI encuentra el usuario lo devuelve, de lo contrario es null
    }
}
