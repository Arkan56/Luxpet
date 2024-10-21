package com.example.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.entidades.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCedula(String cedula);

    Cliente findByNombre(String nombre);

    Cliente findByCorreo(String correo);

    Cliente findByCelular(String celular);

    List<Cliente> findByMascotasIsEmpty();

    Cliente findByNombreAndCorreo(String nombre, String correo);

    List<Cliente> findByCorreoContaining(String dominio);
    

}
