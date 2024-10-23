package com.example.demo.controlador;

import org.attoparser.dom.DocType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Droga;
import com.example.demo.entidades.Tratamiento;
import com.example.demo.servicio.DrogaService;
import java.util.List;

@RestController
@RequestMapping("/droga")
@CrossOrigin(origins = "http://localhost:4200")
public class DrogaController {

    @Autowired
    DrogaService drogaService;

    @GetMapping("/all")
    public List<Droga> mostrarDrogas() {
        return drogaService.searchAll();
    }

    @GetMapping("/find/{id}")
    public Droga mostrarDroga(@PathVariable("id") Long identificacion) {

        Droga droga = drogaService.searchById(identificacion);

        if (droga != null) {
            //model.addAttribute("cliente", clienteService.searchById(identificacion));
            //return clienteService.searchById(identificacion);
        } else {
            // throw new NotFoundException(identificacion);
        }
        return droga;
    }

    @PostMapping("/add")
    public void agregarDroga(@RequestBody Droga droga) {
        drogaService.add(droga);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarDroga(@PathVariable("id") Long id) {
        drogaService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void modificarDroga(@RequestBody Droga droga, @PathVariable("id") int id) {
        drogaService.update(droga);
    }




    
}
