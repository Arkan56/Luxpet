package com.example.demo.servicio;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Mascota;
import com.example.demo.repositorio.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {
    @Autowired
    MascotaRepository repo;

    @Override
    public Mascota searchById(Long id) {
        return repo.findById(id).get(); 
    }

    @Override
    public List<Mascota> searchAll() {
        return repo.findAll(); //repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Mascota update(Mascota mascota) {
        repo.save(mascota);
        return mascota;
    }

    @Override
    public Mascota add(Mascota mascota) {
        repo.save(mascota);
        return mascota;
    }

}
