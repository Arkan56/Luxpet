package com.example.demo.repositorio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Mascota;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;


    @BeforeEach
    void setUp(){
        clienteRepository.save(new Cliente("123456", "miguelito", "miguelelpro@gmail.com", "3184872521"));
        clienteRepository.save(new Cliente("123489", "juan", "juanjo28@gmail.com", "3184406521"));
        clienteRepository.save(new Cliente("123476", "pedro", "pedror23@gmail.com", "3184878521"));
        clienteRepository.save(new Cliente("145603", "ciro", "cirogamer@gmail.com", "3204872521"));
    }
    

    @Test
    public void ClienteRepository_save_Cliente(){
        //arrange
        Cliente cliente = new Cliente("123489", "juan", "juanjo28@gmail.com", "3184406521");
        //act
        Cliente savedCliente = clienteRepository.save(cliente);
        //assert
        Assertions.assertThat(savedCliente).isNotNull();
    }

    @Test
    public void ClienteRepository_FindAll_NotEmptyList(){
        //arrange
        Cliente cliente = new Cliente("123456", "miguelito", "miguelelpro@gmail.com", "3184872521");
        Cliente cliente2 = new Cliente("145603", "ciro", "cirogamer@gmail.com", "3204872521");

        //act
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        List<Cliente> clientes = clienteRepository.findAll();
        //assert
        Assertions.assertThat(clientes).isNotNull();
        Assertions.assertThat(clientes.size()).isEqualTo(6);
        Assertions.assertThat(clientes.size()).isGreaterThan(0);
        
    }  
    @Test
    public void ClienteRepository_findById_FindWrongIndex(){
        //arrange
        Long index = -1l;

        //act
        Optional<Cliente> cliente = clienteRepository.findById(index);
        //assert
        Assertions.assertThat(cliente).isEmpty();

    }
    @Test
    public void ClienteRepository_deleteById_EmptyCliente(){
        //arrange
        Long index = 2l;
        //act
        clienteRepository.deleteById(index);
        //assert
        Assertions.assertThat(clienteRepository.findById(index)).isEmpty();
    }
    @Test
    void ClienteRepository_findByCedula_Cliente(){
        //arrange
        String cedula = "123489";
        //act
        Cliente cliente = clienteRepository.findByCedula(cedula);
        //assert
        Assertions.assertThat(cliente).isNotNull();
        
    }

    @Test
    void ClienteRepository_findByName_Cliente(){
        //arrange
        String nombre = "miguelito";
        //act
        Cliente cliente = clienteRepository.findByNombre(nombre);
        cliente.setNombre("modificado");
        Cliente updated = clienteRepository.save(cliente);
        //assert
        Assertions.assertThat(updated).isNotNull();
        Assertions.assertThat(updated.getNombre()).isEqualTo("modificado");
    }

    //Prueba Consulta 1
    @Test
    void ClienteRepository_findByEmail_Cliente() {
    // arrange
    String email = "cirogamer@gmail.com";
    
    // act
    Cliente cliente = clienteRepository.findByCorreo(email);
    
    // assert
    Assertions.assertThat(cliente).isNotNull();
    Assertions.assertThat(cliente.getCorreo()).isEqualTo(email);
    }

    //Prueba Consulta 2
    @Test
    void ClienteRepository_findByCelular_Cliente() {
        // arrange
        String celular = "3184406521";
        
        // act
        Cliente cliente = clienteRepository.findByCelular(celular);
        
        // assert
        Assertions.assertThat(cliente).isNotNull();
        Assertions.assertThat(cliente.getCelular()).isEqualTo(celular);
    }

    //Prueba Consulta 3
    @Test
    void ClienteRepository_findByMascotasIsEmpty_Clientes() {
    // act
    List<Cliente> clientes = clienteRepository.findByMascotasIsEmpty();
    
    // assert
    Assertions.assertThat(clientes).isNotEmpty();
    for (Cliente cliente : clientes) {
        Assertions.assertThat(cliente.getMascotas()).isEmpty();
    }
    }


    
    //Prueba Consulta 4
    @Test
    void ClienteRepository_findByNombreAndCorreo_Cliente() {
    // arrange
    String nombre = "miguelito";
    String correo = "miguelelpro@gmail.com";
    
    // act
    Cliente cliente = clienteRepository.findByNombreAndCorreo(nombre, correo);
    
    // assert
    Assertions.assertThat(cliente).isNotNull();
    Assertions.assertThat(cliente.getNombre()).isEqualTo(nombre);
    Assertions.assertThat(cliente.getCorreo()).isEqualTo(correo);
    }

    @Test
    void ClienteRepository_findByCorreoContaining_CorreoParcial() {
    // arrange
    Cliente cliente1 = new Cliente("789012", "luis", "luisito@gmail.com", "3101234567");
    Cliente cliente2 = new Cliente("654321", "carlos", "carlitos@yahoo.com", "3127654321");

    clienteRepository.save(cliente1);
    clienteRepository.save(cliente2);

    // act
    List<Cliente> clientesConGmail = clienteRepository.findByCorreoContaining("gmail");

    // assert
    Assertions.assertThat(clientesConGmail).isNotEmpty();
    Assertions.assertThat(clientesConGmail).contains(cliente1);
    Assertions.assertThat(clientesConGmail).doesNotContain(cliente2);
    }

}
