package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", clienteService.searchAll());
        return "listadoClientes";
    }

    @GetMapping("/find/{id}")
    public String mostrarCliente(Model model, @PathVariable("id") Long identificacion) {

        Cliente cliente = clienteService.searchById(identificacion);
        System.out.println(cliente.toString());

        if (cliente != null) {
            model.addAttribute("cliente", clienteService.searchById(identificacion));
        } else {
            // throw new NotFoundException(identificacion);
        }
        return "datosCliente";
    }

    @GetMapping("/portal/{id}")
    public String mostrarClientePortal(Model model, @PathVariable("id") Long identificacion) {

        Cliente cliente = clienteService.searchById(identificacion);
        System.out.println(cliente.toString());

        if (cliente != null) {
            model.addAttribute("cliente", clienteService.searchById(identificacion));
        } else {
            // throw new NotFoundException(identificacion);
        }
        return "portalCliente";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Cliente cliente = new Cliente("", "", "", "");

        model.addAttribute("cliente", cliente);

        return "crearCliente";
    }

    @PostMapping("/add")
    public String agregarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.add(cliente);
        return "redirect:/cliente/all";
    }

    @GetMapping("/delete/{id}")
    public String eliminarCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
        return "redirect:/cliente/all";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(Model model, @PathVariable("id") Long id) {
        model.addAttribute("cliente", clienteService.searchById(id));
        return "modificarCliente";
    }

    @PostMapping("/update/{id}")
    public String modificarCliente(@ModelAttribute("cliente") Cliente cliente, @PathVariable("id") int id) {
        clienteService.update(cliente);
        return "redirect:/cliente/all";
    }
}
