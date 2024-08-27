package com.example.demo.servicio;
import java.util.Collection;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;


public interface ClienteService  {
    public Cliente searchById(int id);

    public Collection<Cliente> searchAll();

    public void deleteById(int id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);

    public Cliente searchByCedula(String cedula);

    public void addMascota(String cedula, Mascota mascota);

    public void deleteMascota(String cedula, int id);
}
