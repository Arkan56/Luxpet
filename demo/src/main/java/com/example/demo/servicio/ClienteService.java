package com.example.demo.servicio;
import java.util.Collection;
import com.example.demo.entidades.Cliente;


public interface ClienteService  {
    public Cliente searchById(int id);

    public Collection<Cliente> searchAll();

    public void deleteById(int id);

    public void update(Cliente mascota);

    public void add(Cliente mascota);
}
