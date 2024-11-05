package com.example.demo.DTOS;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.entidades.Admin;
import com.example.demo.entidades.Veterinario;

@Mapper
public interface AdminMapper {

     AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

     AdminDTO convert(Admin admin);
}
