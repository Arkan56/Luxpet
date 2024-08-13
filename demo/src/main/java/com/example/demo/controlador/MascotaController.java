package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidades.Mascota;
import com.example.demo.servicio.MascotaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired MascotaService service;

    @GetMapping("/all")
    public String mostrarMascotas(Model model) {
        model.addAttribute("mascotas", service.searchAll());
        return "mostrar_todas_mascotas";
    }

    @GetMapping("/find/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") int identificacion) {
        model.addAttribute("mascota", service.searchById(identificacion));
        return "datos_mascota";
    }

}
