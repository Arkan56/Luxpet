package com.example.demo.servicio;
import java.util.List;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;
import com.example.demo.entidades.Veterinario;

public interface VeterinarioService {
    public Veterinario searchById(Long id);

    public List<Veterinario> searchAll();

    public void deleteById(Long id);

    public void update(Veterinario veterinario);

    public void add(Veterinario veterinario);

    public Veterinario searchByCedula(String cedula);

    public void addMascota(String cedula, Mascota mascota);

    public void deleteMascota(String cedula, Long id);
}
