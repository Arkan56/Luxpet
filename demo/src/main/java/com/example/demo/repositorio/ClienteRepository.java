package com.example.demo.repositorio;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;

@Repository
public class ClienteRepository {
    private Map<Integer, Cliente> data = new HashMap<>();

    public ClienteRepository() {
        data.put(1, new Cliente(1,"12345678", "Luis", "Luis@example.com", "12345671"));
        data.put(2, new Cliente(2,"12345679", "Andres", "Andres@example.com", "12345672"));
        data.put(3, new Cliente(3,"12345698", "Camilo", "Camilo@example.com", "12345673"));
    }

    public Cliente findById(int id) {
        return data.get(id);
    }

    public Collection<Cliente> findAll() {
        return data.values();
    }

    public void deleteById(int id) {
        data.remove(id);
    }

    public void update(Cliente cliente) {
        data.put(cliente.getId(), cliente);
    }

    public void add(Cliente cliente) {
        int tam = data.size();
        int lastId = data.get(tam).getId();
        cliente.setId(lastId + 1);
        data.put(cliente.getId(), cliente);
    }

    public Cliente findByCedula(String cedula) {
        for(Cliente cliente : data.values()) {
            if(cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }    
}
