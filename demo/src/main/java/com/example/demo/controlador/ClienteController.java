package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.entidades.UserEntity;
import com.example.demo.repositorio.UserRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository; 


    @Autowired
    JWTGenerator jtwGenerator;

    @GetMapping("/all")
    public List<Cliente> mostrarClientes(Model model) {
        return clienteService.searchAll();
    }

    @GetMapping("/find/{id}")
    public Cliente mostrarCliente(@PathVariable("id") Long identificacion) {

        Cliente cliente = clienteService.searchById(identificacion);

        if (cliente != null) {
            //model.addAttribute("cliente", clienteService.searchById(identificacion));
            //return clienteService.searchById(identificacion);
        } else {
            // throw new NotFoundException(identificacion);
        }
        return cliente;
    }

    @PostMapping("/add")
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
        if(userRepository.existsByUsername(cliente.getCedula())) {
            return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
        }
        UserEntity user = customUserDetailService.ClienteToUser(cliente);
        cliente.setUserEntity(user);

        Cliente c = clienteService.add(cliente);
        if(c != null) {
            return new ResponseEntity<Cliente>(c, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Cliente>(c, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity loginCliente(@RequestBody() Cliente cliente) {
                Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(cliente.getCedula(), "123"));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jtwGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void modificarCliente(@RequestBody Cliente cliente, @PathVariable("id") int id) {
        clienteService.update(cliente);
    }

    @GetMapping("/mascotas/{id}")
    public List<Mascota> mostrarMascotas(@PathVariable("id") Long id) {
        return clienteService.searchMascotas(id);
    }


     @GetMapping("/details")
    public ResponseEntity<Cliente> buscarCliente() {
        Cliente cliente = clienteService.searchByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );
        
        if (cliente == null) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
    
}