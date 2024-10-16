package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public List<Mascota> mostrarMascotas() {
        //model.addAttribute("mascotas", mascotaService.searchAll());
        return mascotaService.searchAll();
    }

    @GetMapping("/find/{id}")
    public Mascota mostrarMascota(@PathVariable("id") Long identificacion) {

        Mascota mascota = mascotaService.searchById(identificacion);
        return mascota;
    }

    /* 
    @GetMapping("/portal/{id}")
    public String mostrarMascotaPortal(Model model, @PathVariable("id") Long identificacion) {

        Mascota mascota = mascotaService.searchById(identificacion);

        if (mascota != null) {
            model.addAttribute("mascota", mascotaService.searchById(identificacion));
            Cliente cliente;
            if (mascota.getCliente() == null) {
                cliente = new Cliente("", "", "", "");
            } else {
                cliente = clienteService.searchByCedula(mascota.getCliente().getCedula());
            }
            model.addAttribute("cliente", cliente);
        } else {
            // throw new NotFoundException(identificacion);
        }

        return "portalMascota";
    }*/

    /*
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Mascota mascota = new Mascota("", "", 0, 0, "", "", "");

        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.searchAll());

        model.addAttribute("clienteSeleccionado", "");

        return "crearMascota";
    }*/

    @PostMapping("/add")
    public void agregarMascota(@RequestBody Mascota mascota,
            @RequestParam String cliente) throws Exception {
        Cliente aux = clienteService.searchByCedula(cliente);
        mascota.setCliente(aux);
        mascotaService.add(mascota);
        clienteService.addMascota(mascota.getCliente().getCedula(), mascota);
        return;
    }

    @GetMapping("/delete/{id}")
    public String eliminarMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
        return "redirect:/mascota/all";
    }

    /*
    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.searchById(id));
        model.addAttribute("clientes", clienteService.searchAll());
        model.addAttribute("cliente", mascotaService.searchById(id).getCliente());
        model.addAttribute("clienteSeleccionado", "");
        return "modificarMascota";
    }*/

    @PostMapping("/update/{id}")
    public void modificarMascota(@RequestBody Mascota mascota, @PathVariable("id") Long id,
            @RequestBody Cliente cliente,
            @RequestBody String clienteSeleccionado) {
        if (cliente.getCedula() != null) {
            clienteService.deleteMascota(cliente.getCedula(), id);
        }
        Cliente aux = clienteService.searchByCedula(clienteSeleccionado);
        mascota.setCliente(aux);
        mascotaService.update(mascota);
        clienteService.addMascota(clienteSeleccionado, mascota);
        return;
    }

}
