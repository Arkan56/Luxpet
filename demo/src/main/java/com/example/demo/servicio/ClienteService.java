package com.example.demo.servicio;
import java.util.Collection;
import java.util.List;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;


public interface ClienteService  {
    public Cliente searchById(Long id);

    public List<Cliente> searchAll();

    public void deleteById(Long id);

    public void update(Cliente cliente); //Sirve, pero no estamos buscando el Cliente por su ID

    public void add(Cliente cliente);

    public Cliente searchByCedula(String cedula);

    public void addMascota(String cedula, Mascota mascota);

    public void deleteMascota(String cedula, Long id);

    Cliente searchByCorreo(String correo);

    Cliente searchByCelular(String celular);

    List<Cliente> searchByClientesSinMascotas();

    Cliente searchByNombreAndCorreo(String nombre, String correo);
    
    public List<Cliente> searchByCorreoContaining(String dominio);

}