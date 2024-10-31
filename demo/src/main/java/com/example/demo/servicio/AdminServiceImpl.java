package com.example.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Admin;
import com.example.demo.repositorio.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin searchByCedula(String cedula) {
        return adminRepository.findByCedula(cedula);
    }
    
}
