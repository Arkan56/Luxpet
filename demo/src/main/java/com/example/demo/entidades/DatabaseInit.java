package com.example.demo.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.AdminRepository;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.RoleRepository;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.repositorio.UserRepository;
import com.example.demo.repositorio.VeterinarioRepository;
import com.example.demo.repositorio.DrogaRepository;
import com.example.demo.entidades.Cliente;

import jakarta.transaction.Transactional;

@Controller
@Transactional
@Profile("default")
public class DatabaseInit implements ApplicationRunner {
        @Autowired
        ClienteRepository clienteRepository;

        @Autowired
        MascotaRepository mascotaRepository;

        @Autowired 
        TratamientoRepository tratamientoRepository;

        @Autowired
        DrogaRepository drogaRepository;

        @Autowired
        VeterinarioRepository veterinarioRepository;

        @Autowired
        AdminRepository adminRepository;

          //Seguridad
         @Autowired
        PasswordEncoder passwordEncoder;

        @Autowired
        RoleRepository roleRepository;

        @Autowired
        UserRepository userRepository;


        @Override
        public void run(ApplicationArguments args) throws Exception {

         //Roles
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("VETERINARIO"));
        roleRepository.save(new Role("CLIENTE"));

        Cliente clienteSave;
        UserEntity userEntity; 
        
        Admin adminSave = new Admin("admin", "admin");
        userEntity = saveUserAdministrador(adminSave);
        adminSave.setUserEntity(userEntity);
        adminRepository.save(adminSave);


               


             
        clienteSave = new Cliente("0000000000", "Juan Angarita", "angarita@example.com", "000-0000");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("0000000001", "Nicolas Camacho", "nicoCamacho@example.com", "000-1111");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("1234567890", "Miguel Angel", "mangel@example.com", "555-1234");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("2345678901", "Juan Perez", "juan@example.com", "555-2345");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("3456789012", "Sebastian Lopez", "sebastian@example.com", "555-3456");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("4567890123", "Carlos Martinez", "carlos@example.com", "555-4567");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("5678901234", "Luis Rodriguez", "luis@example.com", "555-5678");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("6789012345", "Ana Garcia", "ana@example.com", "555-6789");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("7890123456", "Maria Sanchez", "maria@example.com", "555-7890");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("8901234567", "Lucia Ramirez", "lucia@example.com", "555-8901");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("9012345678", "Sofia Torres", "sofia@example.com", "555-9012");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("0123456789", "Laura Flores", "laura@example.com", "555-0123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("1123456789", "Pedro Gomez", "pedro@example.com", "555-1123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("2123456789", "Jorge Diaz", "jorge@example.com", "555-2123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("3123456789", "Raul Fernandez", "raul@example.com", "555-3123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("4123456789", "Andres Morales", "andres@example.com", "555-4123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("5123456789", "Diego Herrera", "diego@example.com", "555-5123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("6123456789", "Oscar Castro", "oscar@example.com", "555-6123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("7123456789", "Ricardo Vargas", "ricardo@example.com", "555-7123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("8123456789", "Fernando Rojas", "fernando@example.com", "555-8123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("9123456789", "Alberto Mendoza", "alberto@example.com", "555-9123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("1023456789", "Rafael Guzman", "rafael@example.com", "555-1023");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("2023456789", "Victor Ortiz", "victor@example.com", "555-2023");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("3023456789", "Hector Soto", "hector@example.com", "555-3023");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("4023456789", "Eduardo Silva", "eduardo@example.com", "555-4023");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("5023456789", "Francisco Reyes", "francisco@example.com", "555-5023");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("6023456789", "Manuel Ruiz", "manuel@example.com", "555-6023");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("7023456789", "Javier Paredes", "javier@example.com", "555-7023");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("8023456789", "Rodrigo Campos", "rodrigo@example.com", "555-8023");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("9023456789", "Adrian Vega", "adrian@example.com", "555-9023");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("1034567890", "Pablo Navarro", "pablo@example.com", "555-1034");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("2034567890", "Gustavo Peña", "gustavo@example.com", "555-2034");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("3034567890", "Felipe Salazar", "felipe@example.com", "555-3034");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("4034567890", "Santiago Aguilar", "santiago@example.com", "555-4034");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("5034567890", "Antonio Cardenas", "antonio@example.com", "555-5034");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("6034567890", "Mario Espinoza", "mario@example.com", "555-6034");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("7034567890", "Alejandro Fuentes", "alejandro@example.com", "555-7034");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("8034567890", "Guillermo Nunez", "guillermo@example.com", "555-8034");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("9034567890", "Hugo Cabrera", "hugo@example.com", "555-9034");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);

        clienteSave = new Cliente("1045678901", "Emilio Leon", "emilio@example.com", "555-1045");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("2045678901", "Ivan Molina", "ivan@example.com", "555-2045");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("3045678901", "Julio Ramos", "julio@example.com", "555-3045");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("4045678901", "Ruben Romero", "ruben@example.com", "555-4045");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("5045678901", "Angel Medina", "angel@example.com", "555-5045");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("6045678901", "Martin Ortiz", "martin@example.com", "555-6045");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("7045678901", "Samuel Delgado", "samuel@example.com", "555-7045");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("8045678901", "Cristian Herrera", "cristian@example.com", "555-8045");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("9045678901", "Joaquin Vargas", "joaquin@example.com", "555-9045");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("1056789012", "Vicente Castro", "vicente@example.com", "555-1056");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("2056789012", "Elias Rojas", "elias@example.com", "555-2056");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        
        clienteSave = new Cliente("3056789012", "Nicolas Guzman", "nicolas@example.com", "555-3056");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        

                mascotaRepository.save(new Mascota("Pepe", "Pitbull", 10, 10.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Luna", "Labrador", 5, 15.f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Rocky", "Bulldog", 8, 12.f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo", "Inactivo"));
                mascotaRepository.save(new Mascota("Bella", "Beagle", 3, 7.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Max", "Pastor alemán", 6, 20.f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera", "Inactivo"));
                mascotaRepository.save(new Mascota("Toby", "Chihuahua", 2, 4.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Charlie", "Poodle", 4, 6.f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Milo", "Boxer", 7, 18.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna", "Inactivo"));
                mascotaRepository.save(new Mascota("Coco", "Dachshund", 5, 9.f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Buddy", "Shih Tzu", 3, 5.f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Duke", "Pitbull", 6, 16.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Bailey", "Labrador", 4, 14.f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Jack", "Bulldog", 7, 13.f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo", "Inactivo"));
                mascotaRepository.save(new Mascota("Daisy", "Beagle", 2, 8.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Oliver", "Pastor alemán", 5, 22.f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera", "Inactivo"));
                mascotaRepository.save(new Mascota("Riley", "Chihuahua", 3, 3.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Buster", "Poodle", 6, 7.f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Lucky", "Boxer", 8, 19.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna", "Inactivo"));
                mascotaRepository.save(new Mascota("Lola", "Dachshund", 4, 10.f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Sadie", "Shih Tzu", 5, 6.f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Rex", "Pitbull", 9, 17.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Maggie", "Labrador", 6, 16.f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Zeus", "Bulldog", 5, 11.f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo", "Inactivo"));
                mascotaRepository.save(new Mascota("Chloe", "Beagle", 4, 7.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Oscar", "Pastor alemán", 7, 21.f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera", "Inactivo"));
                mascotaRepository.save(new Mascota("Gizmo", "Chihuahua", 2, 4.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Rusty", "Poodle", 3, 6.5f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Bruno", "Boxer", 6, 18.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna", "Inactivo"));
                mascotaRepository.save(new Mascota("Molly", "Dachshund", 5, 9.5f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Sophie", "Shih Tzu", 3, 5.5f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Thor", "Pitbull", 8, 15.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Nala", "Labrador", 4, 14.5f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Tank", "Bulldog", 7, 12.5f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo", "Inactivo"));
                mascotaRepository.save(new Mascota("Ruby", "Beagle", 3, 8.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(
                                new Mascota("Ace", "Pastor alemán", 6, 20.5f,
                                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                                "displasia de cadera", "Inactivo"));
                mascotaRepository.save(new Mascota("Ginger", "Chihuahua", 2, 3.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Shadow", "Poodle", 4, 7.2f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Simba", "Boxer", 5, 17.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna", "Inactivo"));
                mascotaRepository.save(new Mascota("Zoe", "Dachshund", 4, 10.2f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Lilly", "Shih Tzu", 3, 5.3f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Diesel", "Pitbull", 9, 16.5f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Roxy", "Labrador", 6, 15.5f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Gus", "Bulldog", 5, 11.5f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo", "Inactivo"));
                mascotaRepository.save(new Mascota("Penny", "Beagle", 4, 7.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(
                                new Mascota("Finn", "Pastor alemán", 7, 21.5f,
                                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                                "displasia de cadera", "Inactivo"));
                mascotaRepository.save(new Mascota("Bambi", "Chihuahua", 3, 4.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Moose", "Poodle", 2, 6.8f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Apollo", "Boxer", 6, 19.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna", "Inactivo"));
                mascotaRepository.save(new Mascota("Ellie", "Dachshund", 5, 9.2f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Mimi", "Shih Tzu", 4, 5.7f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Duke", "Pitbull", 6, 16.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Bailey", "Labrador", 4, 14.f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Jake", "Bulldog", 7, 13.f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo", "Inactivo"));
                mascotaRepository.save(new Mascota("Daisy", "Beagle", 2, 8.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Oliver", "Pastor alemán", 5, 22.f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera", "Inactivo"));
                mascotaRepository.save(new Mascota("Riley", "Chihuahua", 3, 3.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Buster", "Poodle", 6, 7.f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Lucky", "Boxer", 8, 19.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna", "Inactivo"));
                mascotaRepository.save(new Mascota("Lola", "Dachshund", 4, 10.f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Sadie", "Shih Tzu", 5, 6.f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Rex", "Pitbull", 9, 17.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Maggie", "Labrador", 6, 16.f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Zeus", "Bulldog", 5, 11.f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo", "Inactivo"));
                mascotaRepository.save(new Mascota("Chloe", "Beagle", 4, 7.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(
                                new Mascota("Oscar", "Pastor alemán", 7, 21.f,
                                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                                "displasia de cadera", "Inactivo"));
                mascotaRepository.save(new Mascota("Gizmo", "Chihuahua", 2, 4.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Rusty", "Poodle", 3, 6.5f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Bruno", "Boxer", 6, 18.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna", "Inactivo"));
                mascotaRepository.save(new Mascota("Molly", "Dachshund", 5, 9.5f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Sophie", "Shih Tzu", 3, 5.5f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Thor", "Pitbull", 8, 15.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Nala", "Labrador", 4, 14.5f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Tank", "Bulldog", 7, 12.5f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo", "Inactivo"));
                mascotaRepository.save(new Mascota("Ruby", "Beagle", 3, 8.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(
                                new Mascota("Ace", "Pastor alemán", 6, 20.5f,
                                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                                "displasia de cadera", "Inactivo"));
                mascotaRepository.save(new Mascota("Ginger", "Chihuahua", 2, 3.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Shadow", "Poodle", 4, 7.2f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Simba", "Boxer", 5, 17.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna", "Inactivo"));
                mascotaRepository.save(new Mascota("Zoe", "Dachshund", 4, 10.2f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Lilly", "Shih Tzu", 3, 5.3f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Diesel", "Pitbull", 9, 16.5f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Roxy", "Labrador", 6, 15.5f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Gus", "Bulldog", 5, 11.5f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo", "Inactivo"));
                mascotaRepository.save(new Mascota("Penny", "Beagle", 4, 7.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(
                                new Mascota("Finn", "Pastor alemán", 7, 21.5f,
                                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                                "displasia de cadera", "Inactivo"));
                mascotaRepository.save(new Mascota("Bambi", "Chihuahua", 3, 4.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Moose", "Poodle", 2, 6.8f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Apollo", "Boxer", 6, 19.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna", "Inactivo"));
                mascotaRepository.save(new Mascota("Ellie", "Dachshund", 5, 9.2f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Mimi", "Shih Tzu", 4, 5.7f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Benjy", "Pitbull", 9, 16.5f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Freddy", "Labrador", 6, 15.5f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna", "Activo"));
                mascotaRepository
                                .save(new Mascota("Kongo", "Bulldog", 5, 11.5f,
                                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                                "alergia al polvo", "Inactivo"));
                mascotaRepository.save(new Mascota("Spyke", "Beagle", 4, 7.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Rexona", "Pastor alemán", 7, 21.5f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera", "Inactivo"));
                mascotaRepository.save(new Mascota("Tuca", "Chihuahua", 3, 4.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Canelita", "Poodle", 2, 6.8f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Hueco", "Boxer", 6, 19.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna", "Inactivo"));
                mascotaRepository.save(new Mascota("Maximiliano", "Dachshund", 5, 9.2f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Fifi", "Shih Tzu", 4, 5.7f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));
                mascotaRepository.save(new Mascota("Logan", "Shih Tzu", 4, 5.7f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna", "Activo"));

                                drogaRepository.save(new Droga("Carprofeno", 180000, 200000, 50, 30));
                                drogaRepository.save(new Droga("Tramadol", 140000, 150000, 40, 25));
                                drogaRepository.save(new Droga("Apoquel (Oclacitinib)", 290000, 300000, 60, 35));
                                drogaRepository.save(new Droga("Gabapentina", 100000, 120000, 45, 20));
                                drogaRepository.save(new Droga("Metronidazol", 95000, 100000, 35, 15));
                                drogaRepository.save(new Droga("Prednisona", 160000, 170000, 55, 25));
                                drogaRepository.save(new Droga("Cerenia (Maropitant)", 220000, 240000, 50, 30));
                                drogaRepository.save(new Droga("Benazepril", 200000, 210000, 60, 40));
                                drogaRepository.save(new Droga("Fluoxetina", 140000, 160000, 45, 20));
                                drogaRepository.save(new Droga("Fenobarbital", 150000, 180000, 50, 25));
                              

        ArrayList<Droga> drogas = new ArrayList<>(drogaRepository.findAll());

        for (int i = 0; i < 10; i++) {
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setFecha(LocalDate.now().minusDays(i));
                tratamientoRepository.save(tratamiento);
            }


            ArrayList<Tratamiento> tratamientos = new ArrayList<>(tratamientoRepository.findAll());

            
            int drogaIndex = 0;

                        for (Tratamiento tratamiento : tratamientos) {
                                if (drogaIndex < drogas.size()) {
                                    Droga droga = drogas.get(drogaIndex++);
                                    tratamiento.setDroga(droga);
                                    tratamientoRepository.save(tratamiento);
                                }





                ArrayList<Cliente> clientes = new ArrayList<>(clienteRepository.findAll());
                ArrayList<Mascota> mascotas = new ArrayList<>(mascotaRepository.findAll());


                

                                for(Tratamiento tratamiento2 : tratamientos){
                                        int randomIndex = (int) (Math.random() * mascotas.size());
                                        Mascota mascota = mascotas.get(randomIndex);
                                        tratamiento2.setMascota(mascota);
                                        tratamientoRepository.save(tratamiento2);
                                }

                int mascotaIndex = 0;
                for (Cliente cliente : clientes) {
                        if (mascotaIndex < mascotas.size()) {
                                Mascota mascota1 = mascotas.get(mascotaIndex++);
                                mascota1.setCliente(cliente);
                                mascotaRepository.save(mascota1);
                        }
                        if (mascotaIndex < mascotas.size()) {
                                Mascota mascota2 = mascotas.get(mascotaIndex++);
                                mascota2.setCliente(cliente);
                                mascotaRepository.save(mascota2);
                        }
                }
        }


        Veterinario veterinarioSave;


        
        veterinarioSave = Veterinario.builder().nombre("Dr. House").cedula("9991234").especialidad("Tratamientos Oculares").numAtenciones(18).contrasenia("contrasenia123").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dra. María Gómez").cedula("9991235").especialidad("Dermatología").numAtenciones(30).contrasenia("secure456").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dr. Luis Martínez").cedula("9991236").especialidad("Oncología").numAtenciones(80).contrasenia("vetsecure789").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dra. Ana Rodríguez").cedula("9991237").especialidad("Neurología").numAtenciones(100).contrasenia("petsrule").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dr. Carlos Fernández").cedula("9991238").especialidad("Oftalmología").numAtenciones(40).contrasenia("dogcat123").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dra. Laura González").cedula("9991239").especialidad("Cirugía").numAtenciones(120).contrasenia("securevet").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dr. Jorge Ruiz").cedula("9991240").especialidad("Medicina Interna").numAtenciones(90).contrasenia("mypassword1").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dra. Andrea Morales").cedula("9991241").especialidad("Radiología").numAtenciones(65).contrasenia("passvet2").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dr. Santiago López").cedula("9991242").especialidad("Ortopedia").numAtenciones(55).contrasenia("supersecure").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dra. Paula Jiménez").cedula("9991243").especialidad("Dermatología").numAtenciones(70).contrasenia("clinicvet").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dr. Roberto Ortiz").cedula("9991244").especialidad("Endocrinología").numAtenciones(45).contrasenia("vetclinic456").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dra. Gabriela Soto").cedula("9991245").especialidad("Reproducción Animal").numAtenciones(110).contrasenia("password789").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dr. Manuel García").cedula("9991246").especialidad("Oncología").numAtenciones(95).contrasenia("vetpass321").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dra. Elena Castillo").cedula("9991247").especialidad("Anestesiología").numAtenciones(105).contrasenia("safepass1").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dr. Daniel Morales").cedula("9991248").especialidad("Urgencias").numAtenciones(75).contrasenia("mypassword2").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dra. Cecilia Paredes").cedula("9991249").especialidad("Medicina General").numAtenciones(85).contrasenia("supervet123").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dr. Esteban Ramírez").cedula("9991250").especialidad("Nutrición").numAtenciones(60).contrasenia("pass123456").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dra. Verónica Herrera").cedula("9991251").especialidad("Comportamiento Animal").numAtenciones(125).contrasenia("securepass").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dr. Enrique Vargas").cedula("9991252").especialidad("Geriatría").numAtenciones(100).contrasenia("vetsecure001").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        
        veterinarioSave = Veterinario.builder().nombre("Dra. Patricia Mendoza").cedula("9991253").especialidad("Nefrología").numAtenciones(115).contrasenia("clinicpass789").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);

                ArrayList<Veterinario> veterinarios = new ArrayList<>(veterinarioRepository.findAll());

                for (Tratamiento tratamiento : tratamientos) {
                        int randomIndex = (int) (Math.random() * veterinarios.size());    
                        Veterinario veterinario = veterinarios.get(randomIndex);
                        tratamiento.setVeterinario(veterinario);
                        tratamientoRepository.save(tratamiento);
                }


        }
     

        private UserEntity saveUserCliente(Cliente cliente) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(String.valueOf(cliente.getCedula()));
                userEntity.setPassword(passwordEncoder.encode("123"));
                Role roles = roleRepository.findByName("CLIENTE").get();
                userEntity.setRoles(List.of(roles));
                return userRepository.save(userEntity);
            }
        
            private UserEntity saveUserVeterinario(Veterinario veterinario) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(String.valueOf(veterinario.getCedula()));
                userEntity.setPassword(passwordEncoder.encode(veterinario.getContrasenia())); 
                Role roles = roleRepository.findByName("VETERINARIO").get();
                userEntity.setRoles(List.of(roles));
                return userRepository.save(userEntity);
            }
        
            private UserEntity saveUserAdministrador(Admin administrador) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(String.valueOf(administrador.getCedula()));
                userEntity.setPassword(passwordEncoder.encode(administrador.getContrasenia())); 
                Role roles = roleRepository.findByName("ADMIN").get();
                userEntity.setRoles(List.of(roles));
                return userRepository.save(userEntity);
            }

        }

     