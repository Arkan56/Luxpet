package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Consulta;

@Service
public interface ConsultaService {

    public Consulta findById(Long id);

    public List<Consulta> findAll();

    public void add(Consulta consulta);

    public void deleteById(Long id);

    public void update(Consulta consulta);

    public List<Consulta> findByMascotaId(Long mascotaId);

    public Long getTratamientosUltimoMes();

    public List<Object[]> getCantidadTratamientosPorDrogaUltimoMes();
}
