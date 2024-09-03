package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidades.Cliente;
import com.example.demo.servicio.ClienteService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    ClienteService service;

    @GetMapping("/")
    public String mostrarLogin(Model model) {
        model.addAttribute("cedula", "");
        return "inicioSesion";
    }

    @GetMapping("/loginVeterinario")
    public String mostrarPortalVet(Model model) {
        model.addAttribute("cedula", "");
        model.addAttribute("password", "");
        return "inicioSesionVeterinario";
    }

    @PostMapping("/loginVeterinario")
    public String confirmarLoginVet() {
        return "redirect:/cliente/all";
    }

    @PostMapping("/")
    public String confirmarLogin(@ModelAttribute("cedula") String cedula, Model model) {
        System.out.println("Todos los atributos del modelo: " + model.asMap());
        System.out.println("La cedula es: " + cedula);
        Cliente aux = service.searchByCedula(cedula);
        if (aux != null) {
            return "redirect:/cliente/portal/" + aux.getId();
        }
        model.addAttribute("error", "No se encontró el cliente");
        return "inicioSesion";
    }
}
