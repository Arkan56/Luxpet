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
    ClienteService service;
    @Autowired
    MascotaService service2;

    @GetMapping("/all")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", service.searchAll());
        return "listadoClientes";
    }

    @GetMapping("/find/{id}")
    public String mostrarCliente(Model model, @PathVariable("id") int identificacion) {

        Cliente cliente = service.searchById(identificacion);
        System.out.println(cliente.toString());

        if (cliente != null) {
            model.addAttribute("cliente", service.searchById(identificacion));
        } else {
            throw new NotFoundException(identificacion);
        }
        return "datos_cliente"; //Falta mirar
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Cliente cliente = new Cliente(0, "", "", "", "");

        model.addAttribute("cliente", cliente);

        return "crear_cliente";
    }

    @PostMapping("/agregar")
    public String agregarCliente(@ModelAttribute("cliente") Cliente cliente) {
        service.add(cliente);
        return "redirect:/cliente/all"; //Falta mirar
    }

    @GetMapping("/delete/{id}")
    public String eliminarCliente(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/cliente/all";//Falta mirar
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(Model model, @PathVariable("id") int id) {
        model.addAttribute("cliente", service.searchById(id));
        return "modificar_cliente"; //Falta mirar
    }

    @PostMapping("/update/{id}")
    public String modificarCliente(@ModelAttribute("cliente") Cliente cliente, @PathVariable("id") int id) {
        service.update(cliente);
        return "redirect:/cliente/all"; //Falta mirar
    }

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("cedula", "");
        return "inicioSesion";
    }

    @PostMapping("/login")
    public String confirmarLogin(@ModelAttribute("cedula") String cedula, Model model) {
        System.out.println("Todos los atributos del modelo: " + model.asMap());
        System.out.println("La cedula es: "+cedula);
        Cliente aux = service.searchByCedula(cedula);
        if(aux != null)
        {
            return "redirect:/cliente/find/" + aux.getId();
        }
        return "redirect:/cliente/all";
    }

}
