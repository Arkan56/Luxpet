package com.example.demo.repositorio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.entidades.Cliente;
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
        Assertions.assertThat(clientes.size()).isEqualTo(2);
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
   
    

   
       
}
