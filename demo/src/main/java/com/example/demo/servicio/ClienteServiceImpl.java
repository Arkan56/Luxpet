package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository repo;

    @Override
    public Cliente searchById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Collection<Cliente> searchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        repo.save(cliente);
    }

    @Override
    public void add(Cliente cliente) {
        repo.save(cliente);
    }

    @Override
    public Cliente searchByCedula(String cedula) {
        return repo.findByCedula(cedula);
    }

    @Override
    public void addMascota(String cedula, Mascota mascota){
        repo.addMascota(cedula, mascota);
    }

    @Override
    public void deleteMascota(String cedula, Long id){
        repo.deleteMascota(cedula, id);
    }
}
