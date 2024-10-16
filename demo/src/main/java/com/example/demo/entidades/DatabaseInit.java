package com.example.demo.entidades;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.ConsultaRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.repositorio.VeterinarioRepository;
import com.example.demo.repositorio.DrogaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {
    
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    VeterinarioRepository veterinarioRepository;    

    @Autowired 
    TratamientoRepository tratamientoRepository;

    @Autowired
    DrogaRepository drogaRepository;

    @Autowired
    ConsultaRepository consultaRepository;

        @Override
        public void run(ApplicationArguments args) throws Exception {
                clienteRepository.save(new Cliente("0000000000", "Juan Angarita", "angarita@example.com", "000-0000"));
                clienteRepository.save(
                                new Cliente("0000000001", "Nicolas Camacho", "nicoCamacho@example.com", "000-1111"));
                clienteRepository.save(new Cliente("1234567890", "Miguel Angel", "mangel@example.com", "555-1234"));
                clienteRepository.save(new Cliente("2345678901", "Juan Perez", "juan@example.com", "555-2345"));
                clienteRepository.save(
                                new Cliente("3456789012", "Sebastian Lopez", "sebastian@example.com", "555-3456"));
                clienteRepository.save(new Cliente("4567890123", "Carlos Martinez", "carlos@example.com", "555-4567"));
                clienteRepository.save(new Cliente("5678901234", "Luis Rodriguez", "luis@example.com", "555-5678"));
                clienteRepository.save(new Cliente("6789012345", "Ana Garcia", "ana@example.com", "555-6789"));
                clienteRepository.save(new Cliente("7890123456", "Maria Sanchez", "maria@example.com", "555-7890"));
                clienteRepository.save(new Cliente("8901234567", "Lucia Ramirez", "lucia@example.com", "555-8901"));
                clienteRepository.save(new Cliente("9012345678", "Sofia Torres", "sofia@example.com", "555-9012"));
                clienteRepository.save(new Cliente("0123456789", "Laura Flores", "laura@example.com", "555-0123"));
                clienteRepository.save(new Cliente("1123456789", "Pedro Gomez", "pedro@example.com", "555-1123"));
                clienteRepository.save(new Cliente("2123456789", "Jorge Diaz", "jorge@example.com", "555-2123"));
                clienteRepository.save(new Cliente("3123456789", "Raul Fernandez", "raul@example.com", "555-3123"));
                clienteRepository.save(new Cliente("4123456789", "Andres Morales", "andres@example.com", "555-4123"));
                clienteRepository.save(new Cliente("5123456789", "Diego Herrera", "diego@example.com", "555-5123"));
                clienteRepository.save(new Cliente("6123456789", "Oscar Castro", "oscar@example.com", "555-6123"));
                clienteRepository.save(new Cliente("7123456789", "Ricardo Vargas", "ricardo@example.com", "555-7123"));
                clienteRepository.save(new Cliente("8123456789", "Fernando Rojas", "fernando@example.com", "555-8123"));
                clienteRepository.save(new Cliente("9123456789", "Alberto Mendoza", "alberto@example.com", "555-9123"));
                clienteRepository.save(new Cliente("1023456789", "Rafael Guzman", "rafael@example.com", "555-1023"));
                clienteRepository.save(new Cliente("2023456789", "Victor Ortiz", "victor@example.com", "555-2023"));
                clienteRepository.save(new Cliente("3023456789", "Hector Soto", "hector@example.com", "555-3023"));
                clienteRepository.save(new Cliente("4023456789", "Eduardo Silva", "eduardo@example.com", "555-4023"));
                clienteRepository.save(
                                new Cliente("5023456789", "Francisco Reyes", "francisco@example.com", "555-5023"));
                clienteRepository.save(new Cliente("6023456789", "Manuel Ruiz", "manuel@example.com", "555-6023"));
                clienteRepository.save(new Cliente("7023456789", "Javier Paredes", "javier@example.com", "555-7023"));
                clienteRepository.save(new Cliente("8023456789", "Rodrigo Campos", "rodrigo@example.com", "555-8023"));
                clienteRepository.save(new Cliente("9023456789", "Adrian Vega", "adrian@example.com", "555-9023"));
                clienteRepository.save(new Cliente("1034567890", "Pablo Navarro", "pablo@example.com", "555-1034"));
                clienteRepository.save(new Cliente("2034567890", "Gustavo Peña", "gustavo@example.com", "555-2034"));
                clienteRepository.save(new Cliente("3034567890", "Felipe Salazar", "felipe@example.com", "555-3034"));
                clienteRepository.save(
                                new Cliente("4034567890", "Santiago Aguilar", "santiago@example.com", "555-4034"));
                clienteRepository
                                .save(new Cliente("5034567890", "Antonio Cardenas", "antonio@example.com", "555-5034"));
                clienteRepository.save(new Cliente("6034567890", "Mario Espinoza", "mario@example.com", "555-6034"));
                clienteRepository.save(
                                new Cliente("7034567890", "Alejandro Fuentes", "alejandro@example.com", "555-7034"));
                clienteRepository.save(
                                new Cliente("8034567890", "Guillermo Nunez", "guillermo@example.com", "555-8034"));
                clienteRepository.save(new Cliente("9034567890", "Hugo Cabrera", "hugo@example.com", "555-9034"));
                clienteRepository.save(new Cliente("1045678901", "Emilio Leon", "emilio@example.com", "555-1045"));
                clienteRepository.save(new Cliente("2045678901", "Ivan Molina", "ivan@example.com", "555-2045"));
                clienteRepository.save(new Cliente("3045678901", "Julio Ramos", "julio@example.com", "555-3045"));
                clienteRepository.save(new Cliente("4045678901", "Ruben Romero", "ruben@example.com", "555-4045"));
                clienteRepository.save(new Cliente("5045678901", "Angel Medina", "angel@example.com", "555-5045"));
                clienteRepository.save(new Cliente("6045678901", "Martin Ortiz", "martin@example.com", "555-6045"));
                clienteRepository.save(new Cliente("7045678901", "Samuel Delgado", "samuel@example.com", "555-7045"));
                clienteRepository.save(
                                new Cliente("8045678901", "Cristian Herrera", "cristian@example.com", "555-8045"));
                clienteRepository.save(new Cliente("9045678901", "Joaquin Vargas", "joaquin@example.com", "555-9045"));
                clienteRepository.save(new Cliente("1056789012", "Vicente Castro", "vicente@example.com", "555-1056"));
                clienteRepository.save(new Cliente("2056789012", "Elias Rojas", "elias@example.com", "555-2056"));
                clienteRepository.save(new Cliente("3056789012", "Nicolas Guzman", "nicolas@example.com", "555-3056"));

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
                                // Cargar datos desde el archivo Excel
        InputStream inputStream = getClass().getResourceAsStream("/static/excel/MEDICAMENTOS_VETERINARIA.xlsx");

        // Leer el archivo Excel
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Leer la primera hoja

        // Iterar sobre las filas del archivo Excel
        Iterator<Row> rows = sheet.iterator();
        while (rows.hasNext()) {
            Row row = rows.next();

            // Omitir la fila de encabezados
            if (row.getRowNum() == 0) {
                continue;
            }

            // Leer los valores de las celdas
            String nombre = row.getCell(0).getStringCellValue();
            double precioVenta = row.getCell(1).getNumericCellValue();
            double precioCompra = row.getCell(2).getNumericCellValue();
            int unidadesDisponibles = (int) row.getCell(3).getNumericCellValue();
            int unidadesVendidas = (int) row.getCell(4).getNumericCellValue();

            // Crear una nueva instancia de Droga
            Droga droga = new Droga();
            droga.setNombre(nombre);
            droga.setPrecioVenta(precioVenta);
            droga.setPrecioCompra(precioCompra);
            droga.setUnidadesDisponibles(unidadesDisponibles);
            droga.setUnidadesVendidas(unidadesVendidas);

            // Guardar la droga en la base de datos
            drogaRepository.save(droga);
        }

        // Cerrar el workbook y el InputStream
        workbook.close();
        inputStream.close();

        // Asociar mascotas a clientes
        List<Mascota> mascotas = mascotaRepository.findAll();
        List<Cliente> clientes = clienteRepository.findAll();
        
        int indiceMascota = 0;
        for (Cliente cliente : clientes) {
            for (int i = 0; i < 2 && indiceMascota < mascotas.size(); i++) {
                Mascota mascota = mascotas.get(indiceMascota);
                mascota.setCliente(cliente);
                mascotaRepository.save(mascota);
                indiceMascota++;
            }
        }

        // Crear instancias de Consulta con fechas fijas
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.MAY, 10);
        consultaRepository.save(new Consulta(calendar.getTime()));

        calendar.set(2023, Calendar.JUNE, 15);
        consultaRepository.save(new Consulta(calendar.getTime()));

        calendar.set(2023, Calendar.JULY, 20);
        consultaRepository.save(new Consulta(calendar.getTime()));

        calendar.set(2023, Calendar.AUGUST, 25);
        consultaRepository.save(new Consulta(calendar.getTime()));

        calendar.set(2023, Calendar.SEPTEMBER, 30);
        consultaRepository.save(new Consulta(calendar.getTime()));

        // Crear consultas futuras
        calendar.set(2024, Calendar.JANUARY, 20);
        consultaRepository.save(new Consulta(calendar.getTime()));

        calendar.set(2024, Calendar.FEBRUARY, 25);
        consultaRepository.save(new Consulta(calendar.getTime()));

        // Asignar aleatoriamente veterinarios, mascotas y drogas a las consultas
        int cantidadMascotas = mascotaRepository.findAll().size();
        int cantidadVeterinarios = veterinarioRepository.findAll().size();
        int cantidadDrogas = drogaRepository.findAll().size();

        for (Consulta consulta : consultaRepository.findAll()) {
            int mascotaId = ThreadLocalRandom.current().nextInt(1, cantidadMascotas);
            int vetId = ThreadLocalRandom.current().nextInt(1, cantidadVeterinarios);
            int drogaId = ThreadLocalRandom.current().nextInt(1, cantidadDrogas);

            Mascota mascota = mascotaRepository.findById(Long.valueOf(mascotaId)).orElse(null);
            Veterinario veterinario = veterinarioRepository.findById(Long.valueOf(vetId)).orElse(null);
            Droga droga = drogaRepository.findById(Long.valueOf(drogaId)).orElse(null);

            consulta.setMascota(mascota);
            consulta.setVeterinario(veterinario);
            consulta.setDroga(droga);
            consulta.setCantidad(1); // Asigna una cantidad por defecto
            consultaRepository.save(consulta);
        }
    }
                                
                
 }






