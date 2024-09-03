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
    MascotaService mascotaService;
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public String mostrarMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.searchAll());
        return "listadoMascotas";
    }

    @GetMapping("/find/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") Long identificacion) {

        Mascota mascota = mascotaService.searchById(identificacion);

        if (mascota != null) {
            model.addAttribute("mascota", mascotaService.searchById(identificacion));
            Cliente cliente;
            if(mascota.getCliente() == null) {
                cliente = new Cliente( "", "", "", "");
            }
            else {
                cliente = clienteService.searchByCedula(mascota.getCliente().getCedula());
            }
            model.addAttribute("cliente", cliente);
        } else {
            //throw new NotFoundException(identificacion);
        }

        return "datosMascota";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Mascota mascota = new Mascota("", "", 0, 0, "", "", "");

        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.searchAll());

        model.addAttribute("clienteSeleccionado", "");


        return "crearMascota";
    }

    @PostMapping("/add")
    public String agregarMascota(@ModelAttribute("mascota") Mascota mascota, @ModelAttribute("clienteSeleccionado") String cliente) throws Exception { 
        Cliente aux = clienteService.searchByCedula(cliente);
        mascota.setCliente(aux);
        mascotaService.add(mascota);
        clienteService.addMascota(mascota.getCliente().getCedula(), mascota);
        return "redirect:/mascota/all";
    }

    @GetMapping("/delete/{id}")
    public String eliminarMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
        return "redirect:/mascota/all";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.searchById(id));
        model.addAttribute("clientes", clienteService.searchAll());
        model.addAttribute("cliente", mascotaService.searchById(id).getCliente());
        model.addAttribute("clienteSeleccionado", "");
        return "modificarMascota";
    }

    @PostMapping("/update/{id}")
    public String modificarMascota(@ModelAttribute("mascota") Mascota mascota, @PathVariable("id") Long id, @ModelAttribute("cliente") Cliente cliente, @ModelAttribute("clienteSeleccionado") String clienteSeleccionado) {
        if(cliente.getCedula() != null)
        {
            clienteService.deleteMascota(cliente.getCedula(), id);
        }
        Cliente aux = clienteService.searchByCedula(clienteSeleccionado);
        mascota.setCliente(aux);
        mascotaService.update(mascota);
        clienteService.addMascota(clienteSeleccionado, mascota);
        return "redirect:/mascota/all";
    }

}
