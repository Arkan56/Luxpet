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
    public Cliente searchById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Cliente> searchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        repo.update(cliente);
    }

    @Override
    public void add(Cliente cliente) {
        repo.add(cliente);
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
    public void deleteMascota(String cedula, int id){
        repo.deleteMascota(cedula, id);
    }
}
