package com.example.demo.controlador;

import java.util.List;

import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOS.VeterinarioDTO;
import com.example.demo.DTOS.VeterinarioMapper;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.UserEntity;
import com.example.demo.entidades.Veterinario;
import com.example.demo.repositorio.UserRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.VeterinarioService;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin("http://localhost:4200")
public class VeterinarioController {
    @Autowired
    VeterinarioService veterinarioService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    @GetMapping("/all")
    public List<Veterinario> mostrarVeterinarios() {
        return veterinarioService.searchAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VeterinarioDTO> mostrarVeterinario(@PathVariable("id") Long identificacion) {

        Veterinario veterinario = veterinarioService.searchById(identificacion);
        VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);

        if (veterinario != null) {
            //model.addAttribute("cliente", clienteService.searchById(identificacion));
            //return clienteService.searchById(identificacion);
        } else {
            // throw new NotFoundException(identificacion);
        }
        return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VeterinarioDTO> addVeterinario(@RequestBody Veterinario veterinario) {

        if(userRepository.existsByUsername(veterinario.getCedula())) {
            return new ResponseEntity<VeterinarioDTO>(HttpStatus.BAD_REQUEST);
        }

        UserEntity user = customUserDetailService.VeterinarioToUser(veterinario);
        veterinario.setUserEntity(user);

        Veterinario newVeterinario = veterinarioService.add(veterinario);
    
        VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(newVeterinario);
        if (newVeterinario == null) {
            return new ResponseEntity<>(veterinarioDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(veterinarioDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity loginVeterinario(@RequestBody() Veterinario veterinario) {
                Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(veterinario.getCedula(), veterinario.getContrasenia()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public void eliminarVeterinario(@PathVariable("id") Long id) {
        veterinarioService.deleteById(id);
    }
    
    @PutMapping("/update/{id}")
    public void modificarVeterinario(@RequestBody Veterinario veterinario, @PathVariable("id") Long id) {
        veterinarioService.update(veterinario);
    }


      @GetMapping("/details")
    public ResponseEntity<Veterinario> buscarVeterinario() {
        Veterinario veterinario = veterinarioService.searchByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );

        if (veterinario == null) {
            return new ResponseEntity<Veterinario>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Veterinario>(veterinario, HttpStatus.OK);
    } 
}
