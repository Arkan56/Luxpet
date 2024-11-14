package com.example.demo.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Admin {

       @OneToOne(cascade=CascadeType.ALL)
        private UserEntity userEntity;

    private String cedula;
    @Transient
    private String contrasenia;

    @Id
    @GeneratedValue
    private Long id;

    public Admin(String cedula, String contrasenia) {
        this.cedula = cedula;
        this.contrasenia = contrasenia;
    }

   
    
    
    
}
