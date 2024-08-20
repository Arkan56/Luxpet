package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.example.demo.entidades.Mascota;

@Repository
public class MascotaRepository {
    private Map<Integer, Mascota> data = new HashMap<>();

    public MascotaRepository() {
        data.put(1,
                new Mascota(1, "Pepe", "Pitbull", 10, 10.f,
                        "https://d2yoo3qu6vrk5d.cloudfront.net/pulzo-lite/images-resized/PP2804546A-s-o.webp",
                        "ninguna", "bien"));
        data.put(2, new Mascota(2, "Luna", "Labrador", 5, 15.f, "luna.jpg", "ninguna", "excelente"));
        data.put(3, new Mascota(3, "Rocky", "Bulldog", 8, 12.f, "rocky.jpg", "alergia al polvo", "bueno"));
        data.put(4, new Mascota(4, "Bella", "Beagle", 3, 7.5f, "bella.jpg", "ninguna", "muy bien"));
        data.put(5, new Mascota(5, "Max", "Pastor alemán", 6, 20.f, "max.jpg", "displasia de cadera", "regular"));
        data.put(6, new Mascota(6, "Toby", "Chihuahua", 2, 4.f, "toby.jpg", "ninguna", "excelente"));
    }

    public Mascota findById(int id) {
        return data.get(id);
    }

    public Collection<Mascota> findAll() {
        return data.values();
    }

    public void deleteById(int id) {
        data.remove(id);
    }

    public void update(Mascota mascota) {
        data.put(mascota.getId(), mascota);
    }

    public void add(Mascota mascota) {
        int tam = data.size();
        int lastId = data.get(tam).getId();
        mascota.setId(lastId + 1);
        data.put(mascota.getId(), mascota);
    }
}
