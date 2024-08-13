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
        data.put(1, new Mascota(1,"pepe", "pitbull", 10, 10.f,"pepe.jpg", "ninguna", "bien"));
        data.put(2, new Mascota(2,"luna", "labrador", 5, 15.f, "luna.jpg", "ninguna", "excelente"));
        data.put(3, new Mascota(3,"rocky", "bulldog", 8, 12.f, "rocky.jpg", "alergia al polvo", "bueno"));
        data.put(4, new Mascota(4, "bella", "beagle", 3, 7.5f, "bella.jpg", "ninguna", "muy bien"));
        data.put(5, new Mascota(5,"max", "pastor alemán", 6, 20.f, "max.jpg", "displasia de cadera", "regular"));
        data.put(6, new Mascota(6, "toby", "chihuahua", 2, 4.f, "toby.jpg", "ninguna", "excelente"));
    }


    public Mascota findById(int id) {
        return data.get(id);
    }

    public Collection<Mascota> findAll() {
        return data.values();
    }
}
