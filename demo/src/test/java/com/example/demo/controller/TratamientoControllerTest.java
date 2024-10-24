package com.example.demo.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cglib.core.Local;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.controlador.TratamientoController;
import com.example.demo.entidades.Tratamiento;
import com.example.demo.servicio.TratamientoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.List;


@WebMvcTest(controllers = TratamientoController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class TratamientoControllerTest{

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private TratamientoService tratamientoService;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void TratamientoController_agregarTratamiento_Tratamiento() throws JsonProcessingException, Exception{

        LocalDate fecha = LocalDate.of(2023, 10, 19); 
        
        Tratamiento tratamiento = new Tratamiento(fecha);

        when(tratamientoService.add(Mockito.any(Tratamiento.class))).thenReturn(tratamiento);

        ResultActions response = mockMvc.perform(
            post("/tratamiento/add")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(tratamiento)));

        response.andExpect(status().isCreated())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.id").value(tratamiento.getId()));    

    }

    @Test
    public void TratamientoController_mostrarTratamiento_Tratamiento() throws JsonProcessingException, Exception{

        LocalDate fecha = LocalDate.of(2023, 10, 19); 
        
        Tratamiento tratamiento = new Tratamiento(fecha);

        when(tratamientoService.searchById(Mockito.anyLong())).thenReturn(tratamiento);

        ResultActions response = mockMvc.perform(
            get("/tratamiento/find/1")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(tratamiento)));

        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.id").value(tratamiento.getId()));    

    }

    @Test 
    public void TratamientoController_mostrarTratamientos_TratamientoList() throws JsonProcessingException, Exception{

        LocalDate fecha = LocalDate.of(2023, 10, 19); 
        

        when(tratamientoService.searchAll()).thenReturn(List.of(
            new Tratamiento(fecha), new Tratamiento(fecha)
        ));

        ResultActions response = mockMvc.perform(get("/tratamiento/all"));

        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.size()").value(2));    

    }


    @Test
    public void TratamientoController_mostrarTratamiento_TratamientoNotFound() throws Exception {
        when(tratamientoService.searchById(anyLong())).thenReturn(null);

        ResultActions response = mockMvc.perform(
            get("/tratamiento/find/").param("id", "1")
        );

        response.andExpect(status().isNotFound());
    }

   
  @Test
  public void TratamientoController_modificarTratamiento_Tratamiento() throws Exception {
    LocalDate fecha = LocalDate.of(2023, 10, 19);
    Tratamiento tratamiento = new Tratamiento(fecha);
    tratamiento.setId(1L);

    when(tratamientoService.searchById(anyLong())).thenReturn(tratamiento);
    when(tratamientoService.update(Mockito.any(Tratamiento.class))).thenReturn(tratamiento);

    ResultActions response = mockMvc.perform(
        put("/tratamiento/update/1")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(tratamiento))
    );

    response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.id").value(tratamiento.getId()));
    }


}