package com.example.demo.servicio;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public Cliente searchById(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public List<Cliente> searchAll() {
        return clienteRepository.findAll();
    }

  @Override
public void deleteById(Long id) {
    // Obtener el cliente por su ID
    Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

    // Obtener la lista de mascotas asociadas al cliente
    List<Mascota> mascotas = cliente.getMascotas();

    // Borrar cada mascota de la lista
    for (Mascota mascota : mascotas) {
        mascotaRepository.deleteById(mascota.getId());
    }

    // Borrar el cliente
    clienteRepository.deleteById(id);
}

    @Override
    public void update(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void add(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente searchByCedula(String cedula) {
        return clienteRepository.findByCedula(cedula);
    }

    @Override
    public void addMascota(String cedula, Mascota mascota){
        Cliente cliente = clienteRepository.findByCedula(cedula);
        cliente.getMascotas().add(mascota);
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteMascota(String cedula, Long id){
        Cliente cliente = clienteRepository.findByCedula(cedula);
        cliente.getMascotas().removeIf(mascota -> mascota.getId() == id);
        clienteRepository.save(cliente);
    }
}
