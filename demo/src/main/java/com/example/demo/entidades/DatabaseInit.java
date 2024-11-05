package com.example.demo.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.AdminRepository;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.TratamientoRepository;
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


        @Override
        public void run(ApplicationArguments args) throws Exception {
                adminRepository.save(new Admin("admin", "admin"));

                Cliente clienteEntity =  Cliente.builder().cedula("0000000000").nombre("Juan Angarita").correo("angarita@example.com").celular("000-0000").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("0000000001").nombre("Nicolas Camacho").correo("nicoCamacho@example.com").celular("000-1111").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("1234567890").nombre("Miguel Angel").correo("mangel@example.com").celular("555-1234").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("2345678901").nombre("Juan Perez").correo("juan@example.com").celular("555-2345").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("3456789012").nombre("Sebastian Lopez").correo("sebastian@example.com").celular("555-3456").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("4567890123").nombre("Carlos Martinez").correo("carlos@example.com").celular("555-4567").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("5678901234").nombre("Luis Rodriguez").correo("luis@example.com").celular("555-5678").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("6789012345").nombre("Ana Garcia").correo("ana@example.com").celular("555-6789").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("7890123456").nombre("Maria Sanchez").correo("maria@example.com").celular("555-7890").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("8901234567").nombre("Lucia Ramirez").correo("lucia@example.com").celular("555-8901").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("9012345678").nombre("Sofia Torres").correo("sofia@example.com").celular("555-9012").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("0123456789").nombre("Laura Flores").correo("laura@example.com").celular("555-0123").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("1123456789").nombre("Pedro Gomez").correo("pedro@example.com").celular("555-1123").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("2123456789").nombre("Jorge Diaz").correo("jorge@example.com").celular("555-2123").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("3123456789").nombre("Raul Fernandez").correo("raul@example.com").celular("555-3123").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("4123456789").nombre("Andres Morales").correo("andres@example.com").celular("555-4123").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("5123456789").nombre("Diego Herrera").correo("diego@example.com").celular("555-5123").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("6123456789").nombre("Oscar Castro").correo("oscar@example.com").celular("555-6123").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("7123456789").nombre("Ricardo Vargas").correo("ricardo@example.com").celular("555-7123").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("8123456789").nombre("Fernando Rojas").correo("fernando@example.com").celular("555-8123").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("9123456789").nombre("Alberto Mendoza").correo("alberto@example.com").celular("555-9123").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("1023456789").nombre("Rafael Guzman").correo("rafael@example.com").celular("555-1023").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("2023456789").nombre("Victor Ortiz").correo("victor@example.com").celular("555-2023").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("3023456789").nombre("Hector Soto").correo("hector@example.com").celular("555-3023").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("4023456789").nombre("Eduardo Silva").correo("eduardo@example.com").celular("555-4023").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("5023456789").nombre("Francisco Reyes").correo("francisco@example.com").celular("555-5023").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("6023456789").nombre("Manuel Ruiz").correo("manuel@example.com").celular("555-6023").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("7023456789").nombre("Javier Paredes").correo("javier@example.com").celular("555-7023").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("8023456789").nombre("Rodrigo Campos").correo("rodrigo@example.com").celular("555-8023").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("9023456789").nombre("Adrian Vega").correo("adrian@example.com").celular("555-9023").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("1034567890").nombre("Pablo Navarro").correo("pablo@example.com").celular("555-1034").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("2034567890").nombre("Gustavo Peña").correo("gustavo@example.com").celular("555-2034").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("3034567890").nombre("Felipe Salazar").correo("felipe@example.com").celular("555-3034").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("4034567890").nombre("Santiago Aguilar").correo("santiago@example.com").celular("555-4034").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("5034567890").nombre("Antonio Cardenas").correo("antonio@example.com").celular("555-5034").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("6034567890").nombre("Mario Espinoza").correo("mario@example.com").celular("555-6034").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("7034567890").nombre("Alejandro Fuentes").correo("alejandro@example.com").celular("555-7034").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("8034567890").nombre("Guillermo Nunez").correo("guillermo@example.com").celular("555-8034").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("9034567890").nombre("Hugo Cabrera").correo("hugo@example.com").celular("555-9034").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("1045678901").nombre("Emilio Leon").correo("emilio@example.com").celular("555-1045").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("2045678901").nombre("Ivan Molina").correo("ivan@example.com").celular("555-2045").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("3045678901").nombre("Julio Ramos").correo("julio@example.com").celular("555-3045").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("4045678901").nombre("Ruben Romero").correo("ruben@example.com").celular("555-4045").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("5045678901").nombre("Angel Medina").correo("angel@example.com").celular("555-5045").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("6045678901").nombre("Martin Ortiz").correo("martin@example.com").celular("555-6045").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("7045678901").nombre("Samuel Delgado").correo("samuel@example.com").celular("555-7045").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("8045678901").nombre("Cristian Herrera").correo("cristian@example.com").celular("555-8045").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("9045678901").nombre("Joaquin Vargas").correo("joaquin@example.com").celular("555-9045").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("1056789012").nombre("Vicente Castro").correo("vicente@example.com").celular("555-1056").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("2056789012").nombre("Elias Rojas").correo("elias@example.com").celular("555-2056").build();
                clienteRepository.save(clienteEntity);

                clienteEntity = Cliente.builder().cedula("3056789012").nombre("Nicolas Guzman").correo("nicolas@example.com").celular("555-3056").build();
                clienteRepository.save(clienteEntity);



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
                veterinarioRepository.save(new Veterinario("VET123456", "pass123", "Cardiología", "foto1.jpg", 50, "Dr. Juan Pérez"));
                veterinarioRepository.save(new Veterinario("VET123457", "secure456", "Dermatología", "foto2.jpg", 30, "Dra. María Gómez"));
                veterinarioRepository.save(new Veterinario("VET123458", "vetsecure789", "Oncología", "foto3.jpg", 80, "Dr. Luis Martínez"));
                veterinarioRepository.save(new Veterinario("VET123459", "petsrule", "Neurología", "foto4.jpg", 100, "Dra. Ana Rodríguez"));
                veterinarioRepository.save(new Veterinario("VET123460", "dogcat123", "Oftalmología", "foto5.jpg", 40, "Dr. Carlos Fernández"));
                veterinarioRepository.save(new Veterinario("VET123461", "securevet", "Cirugía", "foto6.jpg", 120, "Dra. Laura González"));
                veterinarioRepository.save(new Veterinario("VET123462", "mypassword1", "Medicina Interna", "foto7.jpg", 90, "Dr. Jorge Ruiz"));
                veterinarioRepository.save(new Veterinario("VET123463", "passvet2", "Radiología", "foto8.jpg", 65, "Dra. Andrea Morales"));
                veterinarioRepository.save(new Veterinario("VET123464", "supersecure", "Ortopedia", "foto9.jpg", 55, "Dr. Santiago López"));
                veterinarioRepository.save(new Veterinario("VET123465", "clinicvet", "Dermatología", "foto10.jpg", 70, "Dra. Paula Jiménez"));
                veterinarioRepository.save(new Veterinario("VET123466", "vetclinic456", "Endocrinología", "foto11.jpg", 45, "Dr. Roberto Ortiz"));
                veterinarioRepository.save(new Veterinario("VET123467", "password789", "Reproducción Animal", "foto12.jpg", 110, "Dra. Gabriela Soto"));
                veterinarioRepository.save(new Veterinario("VET123468", "vetpass321", "Oncología", "foto13.jpg", 95, "Dr. Manuel García"));
                veterinarioRepository.save(new Veterinario("VET123469", "safepass1", "Anestesiología", "foto14.jpg", 105, "Dra. Elena Castillo"));
                veterinarioRepository.save(new Veterinario("VET123470", "mypassword2", "Urgencias", "foto15.jpg", 75, "Dr. Daniel Morales"));
                veterinarioRepository.save(new Veterinario("VET123471", "supervet123", "Medicina General", "foto16.jpg", 85, "Dra. Cecilia Paredes"));
                veterinarioRepository.save(new Veterinario("VET123472", "pass123456", "Nutrición", "foto17.jpg", 60, "Dr. Esteban Ramírez"));
                veterinarioRepository.save(new Veterinario("VET123473", "securepass", "Comportamiento Animal", "foto18.jpg", 125, "Dra. Verónica Herrera"));
                veterinarioRepository.save(new Veterinario("VET123474", "vetsecure001", "Geriatría", "foto19.jpg", 100, "Dr. Enrique Vargas"));
                veterinarioRepository.save(new Veterinario("VET123475", "clinicpass789", "Nefrología", "foto20.jpg", 115, "Dra. Patricia Mendoza"));

                ArrayList<Veterinario> veterinarios = new ArrayList<>(veterinarioRepository.findAll());

                for (Tratamiento tratamiento : tratamientos) {
                        int randomIndex = (int) (Math.random() * veterinarios.size());    
                        Veterinario veterinario = veterinarios.get(randomIndex);
                        tratamiento.setVeterinario(veterinario);
                        tratamientoRepository.save(tratamiento);
                }


        
        }
}