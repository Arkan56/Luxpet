package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin findByCedula(String cedula);
}