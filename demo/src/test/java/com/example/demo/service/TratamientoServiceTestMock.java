package com.example.demo.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entidades.Tratamiento;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.servicio.TratamientoService;
import com.example.demo.servicio.TratamientoServiceImpl;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TratamientoServiceTestMock {


    @InjectMocks  
    private TratamientoServiceImpl tratamientoService;

    @Mock
    TratamientoRepository tratamientoRepository;

    @BeforeEach
    public void init(){
    }

    @Test
    public void tratamientoService_add_Tratamiento(){
        //arrange
        LocalDate fecha = LocalDate.of(2023, 10, 19); // Ejemplo de fecha
        Tratamiento tratamiento = new Tratamiento(fecha);
        Tratamiento tratamiento2 = new Tratamiento(fecha);

        when(tratamientoRepository.save(tratamiento)).thenReturn(tratamiento);
        when(tratamientoRepository.save(tratamiento2)).thenReturn(tratamiento2);

        //act
        Tratamiento newTratamiento = tratamientoService.add(tratamiento);
        newTratamiento = tratamientoService.add(tratamiento2);

        //assert
        Assertions.assertThat(newTratamiento).isNotNull();

    }

    @Test
    public void tratamientoService_findAll_TratamientoList(){

        //arrange
        when(tratamientoRepository.findAll()).thenReturn(List.of(new Tratamiento(), new Tratamiento()));

        //act
        List<Tratamiento> tratamientos = tratamientoService.searchAll();
        //assert
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(2);

    }


    @Test
    public void tratamientoService_update_Tratamiento(){
        //arrange
        LocalDate fecha = LocalDate.of(2023, 10, 19); // Ejemplo de fecha
        Tratamiento tratamiento = new Tratamiento(fecha);
        Tratamiento tratamiento2 = new Tratamiento(fecha);

        //act
        when(tratamientoRepository.save(tratamiento)).thenReturn(tratamiento);
        when(tratamientoRepository.save(tratamiento2)).thenReturn(tratamiento2);
        Tratamiento newTratamiento = tratamientoService.add(tratamiento);
        newTratamiento = tratamientoService.add(tratamiento2);
        newTratamiento.setFecha(LocalDate.of(2023, 10, 20));
        tratamientoService.update(newTratamiento);

        when(tratamientoRepository.findById(newTratamiento.getId())).thenReturn(java.util.Optional.of(newTratamiento));

        //assert
        Assertions.assertThat(tratamientoService.searchById(newTratamiento.getId()).getFecha()).isEqualTo(LocalDate.of(2023, 10, 20));
    }


    @Test
    public void tratamientoService_findById_Tratamiento(){
        //arrange
        LocalDate fecha = LocalDate.of(2023, 10, 19); // Ejemplo de fecha
        Tratamiento tratamiento = new Tratamiento(fecha);
        Tratamiento tratamiento2 = new Tratamiento(fecha);

        when(tratamientoRepository.save(tratamiento)).thenReturn(tratamiento);
        when(tratamientoRepository.save(tratamiento2)).thenReturn(tratamiento2);
        when(tratamientoRepository.findById(tratamiento.getId())).thenReturn(java.util.Optional.of(tratamiento));

        //act
        Tratamiento newTratamiento = tratamientoService.add(tratamiento);
        newTratamiento = tratamientoService.add(tratamiento2);

        //assert
        Assertions.assertThat(tratamientoService.searchById(newTratamiento.getId())).isNotNull();
    }
    

}
