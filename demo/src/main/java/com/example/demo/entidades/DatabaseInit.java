package com.example.demo.entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.entidades.Cliente;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    /*/clienteRepository.save(new Cliente("123", "Miguel", "mangel@example.com", "123456"));
    clienteRepository.save(new Cliente("123", "Juan", "juan@example.com", "123456"));
    clienteRepository.save(new Cliente("123", "Sebastian", "sebastian@example.com", "123456"));*/
}
}