package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entidades.Tratamiento;
import com.example.demo.servicio.TratamientoService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class TratamientoServiceTestNaive {
     @Autowired  
    private TratamientoService tratamientoService;

    @BeforeEach
    public void init(){
        LocalDate fecha = LocalDate.of(2023, 10, 19);
        Tratamiento tratamiento1 = new Tratamiento(fecha);
        Tratamiento tratamiento2 = new Tratamiento(fecha);

        tratamientoService.add(tratamiento1);
        tratamientoService.add(tratamiento2);   
    }

    @Test
    public void tratamientoService_add_Tratamiento(){
        //arrange
        LocalDate fecha = LocalDate.of(2023, 10, 19); // Ejemplo de fecha
        Tratamiento tratamiento = new Tratamiento(fecha);
        Tratamiento tratamiento2 = new Tratamiento(fecha);

        //act
        Tratamiento newTratamiento = tratamientoService.add(tratamiento);
        newTratamiento = tratamientoService.add(tratamiento2);

        //assert
        Assertions.assertThat(newTratamiento).isNotNull();

    }

    @Test
    public void tratamientoService_findAll_TratamientoList(){

        //arrange

        //act
        List<Tratamiento> tratamientos = tratamientoService.searchAll();
        //assert
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(2);

    }

    @Test
    public void tratamientoService_deleteById_Tratamiento(){
        //arrange
       

        //act
        tratamientoService.deleteById(1L);

        //assert
        Assertions.assertThat(tratamientoService.searchAll().size()).isEqualTo(1);
    }

    @Test
    public void tratamientoService_update_Tratamiento(){
        //arrange
        LocalDate fecha = LocalDate.of(2023, 10, 19); // Ejemplo de fecha
        Tratamiento tratamiento = new Tratamiento(fecha);
        Tratamiento tratamiento2 = new Tratamiento(fecha);

        //act
        Tratamiento newTratamiento = tratamientoService.add(tratamiento);
        newTratamiento = tratamientoService.add(tratamiento2);
        newTratamiento.setFecha(LocalDate.of(2023, 10, 20));
        tratamientoService.update(newTratamiento);

        //assert
        Assertions.assertThat(tratamientoService.searchById(newTratamiento.getId()).getFecha()).isEqualTo(LocalDate.of(2023, 10, 20));
    }

    @Test
    public void tratamientoService_findById_Tratamiento(){
        //arrange
        LocalDate fecha = LocalDate.of(2023, 10, 19); // Ejemplo de fecha
        Tratamiento tratamiento = new Tratamiento(fecha);
        Tratamiento tratamiento2 = new Tratamiento(fecha);

        //act
        Tratamiento newTratamiento = tratamientoService.add(tratamiento);
        newTratamiento = tratamientoService.add(tratamiento2);

        //assert
        Assertions.assertThat(tratamientoService.searchById(newTratamiento.getId())).isNotNull();
    }
    

}
