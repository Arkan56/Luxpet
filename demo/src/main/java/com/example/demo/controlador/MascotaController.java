package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaService service;
    @Autowired
    ClienteService service2;

    @GetMapping("/all")
    public String mostrarMascotas(Model model) {
        model.addAttribute("mascotas", service.searchAll());
        return "listadoMascotas";
    }

    @GetMapping("/find/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") Long identificacion) {

        Mascota mascota = service.searchById(identificacion);

        if (mascota != null) {
            model.addAttribute("mascota", service.searchById(identificacion));
            Cliente cliente;
            if(mascota.getCliente() == null) {
                cliente = new Cliente( "", "", "", "");
            }
            else {
                cliente = service2.searchByCedula(mascota.getCliente().getCedula());
            }
            model.addAttribute("cliente", cliente);
        } else {
            //throw new NotFoundException(identificacion);
        }

        return "datos_mascota";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Mascota mascota = new Mascota("", "", 0, 0, "", "", "");

        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", service2.searchAll());

        return "crear_mascota";
    }

    @PostMapping("/agregar")
    public String agregarMascota(@ModelAttribute("mascota") Mascota mascota) {
        System.out.println("Mascota: " + mascota.toString());
        service.add(mascota);
        service2.addMascota(mascota.getCliente().getCedula(), mascota);
        return "redirect:/mascota/all";
    }

    @GetMapping("/delete/{id}")
    public String eliminarMascota(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/mascota/all";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", service.searchById(id));
        model.addAttribute("clientes", service2.searchAll());
        model.addAttribute("cliente", service.searchById(id).getCliente());
        return "modificar_mascota";
    }

    @PostMapping("/update/{id}")
    public String modificarMascota(@ModelAttribute("mascota") Mascota mascota, @PathVariable("id") Long id, @ModelAttribute("cliente") Cliente cliente) {
        service2.deleteMascota(cliente.getCedula(), id);
        service.update(mascota);
        service2.addMascota(mascota.getCliente().getCedula(), mascota);
        return "redirect:/mascota/all";
    }

}
