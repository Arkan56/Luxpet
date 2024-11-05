package com.example.demo.entidades;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {

    private int id;

    public NotFoundException(int id) {
        this.id = id;
    }

   
}
