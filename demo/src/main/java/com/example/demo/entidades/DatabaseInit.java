package com.example.demo.entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.entidades.Cliente;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        clienteRepository.save(new Cliente("1234", "Miguel", "mangel@example.com", "123456"));
        clienteRepository.save(new Cliente("1243", "Juan", "juan@example.com", "123456"));
        clienteRepository.save(new Cliente("1235", "Sebastian", "sebastian@example.com", "123456"));

        mascotaRepository.save(
                new Mascota("Pepe", "Pitbull", 10, 10.f,
                        "https://d2yoo3qu6vrk5d.cloudfront.net/pulzo-lite/images-resized/PP2804546A-s-o.webp",
                        "ninguna", "bien"));
        mascotaRepository.save( new Mascota("Luna", "Labrador", 5, 15.f, "luna.jpg", "ninguna", "excelente"));
        mascotaRepository.save( new Mascota("Rocky", "Bulldog", 8, 12.f, "rocky.jpg", "alergia al polvo", "bueno"));
        mascotaRepository.save( new Mascota("Bella", "Beagle", 3, 7.5f, "bella.jpg", "ninguna", "muy bien"));
        mascotaRepository.save( new Mascota("Max", "Pastor alemán", 6, 20.f, "max.jpg", "displasia de cadera", "regular"));
        mascotaRepository.save(new Mascota("Toby", "Chihuahua", 2, 4.f, "toby.jpg", "ninguna", "excelente"));
    }
}