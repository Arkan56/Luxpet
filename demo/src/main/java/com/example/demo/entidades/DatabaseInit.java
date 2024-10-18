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
                clienteRepository.save(new Cliente( 000000, "Juan Angarita", "angarita@example.com", 0000000));
                clienteRepository.save(new Cliente( 000000, "Nicolas Camacho", "nicoCamacho@example.com", 0001111));
                clienteRepository.save(new Cliente(000000, "Juan Angarita", "angarita@example.com", 0000000));
                clienteRepository.save(new Cliente(123456, "Miguel Angel", "mangel@example.com", 5551234));
                clienteRepository.save(new Cliente(234567, "Juan Perez", "juan@example.com", 5552345));
                clienteRepository.save(new Cliente(345678, "Sebastian Lopez", "sebastian@example.com", 5553456));
                clienteRepository.save(new Cliente(456789, "Carlos Martinez", "carlos@example.com", 5554567));
                clienteRepository.save(new Cliente(567890, "Luis Rodriguez", "luis@example.com", 5555678));
                clienteRepository.save(new Cliente(678901, "Ana Garcia", "ana@example.com", 5556789));
                clienteRepository.save(new Cliente(789012, "Maria Sanchez", "maria@example.com", 5557890));
                clienteRepository.save(new Cliente(890123, "Lucia Ramirez", "lucia@example.com", 5558901));
                clienteRepository.save(new Cliente(901234, "Sofia Torres", "sofia@example.com", 5559012));
                clienteRepository.save(new Cliente(012345, "Laura Flores", "laura@example.com", 5550123));
                clienteRepository.save(new Cliente(112345, "Pedro Gomez", "pedro@example.com", 5551123));
                clienteRepository.save(new Cliente(212345, "Jorge Diaz", "jorge@example.com", 5552123));
                clienteRepository.save(new Cliente(312345, "Raul Fernandez", "raul@example.com", 5553123));
                clienteRepository.save(new Cliente(412345, "Andres Morales", "andres@example.com", 5554123));
                clienteRepository.save(new Cliente(512345, "Diego Herrera", "diego@example.com", 5555123));
                clienteRepository.save(new Cliente(612345, "Oscar Castro", "oscar@example.com", 5556123));
                clienteRepository.save(new Cliente(712345, "Ricardo Vargas", "ricardo@example.com", 5557123));
                clienteRepository.save(new Cliente(812345, "Fernando Rojas", "fernando@example.com", 5558123));
                clienteRepository.save(new Cliente(912345, "Alberto Mendoza", "alberto@example.com", 5559123));
                clienteRepository.save(new Cliente(102345, "Rafael Guzman", "rafael@example.com", 5551023));
                clienteRepository.save(new Cliente(202345, "Victor Ortiz", "victor@example.com", 5552023));
                clienteRepository.save(new Cliente(302345, "Hector Soto", "hector@example.com", 5553023));
                clienteRepository.save(new Cliente(402345, "Eduardo Silva", "eduardo@example.com", 5554023));
                clienteRepository.save(new Cliente(502345, "Francisco Reyes", "francisco@example.com", 5555023));
                clienteRepository.save(new Cliente(602345, "Manuel Ruiz", "manuel@example.com", 5556023));
                clienteRepository.save(new Cliente(702345, "Javier Paredes", "javier@example.com", 5557023));
                clienteRepository.save(new Cliente(802345, "Rodrigo Campos", "rodrigo@example.com", 5558023));
                clienteRepository.save(new Cliente(902345, "Adrian Vega", "adrian@example.com", 5559023));
                clienteRepository.save(new Cliente(103456, "Pablo Navarro", "pablo@example.com", 5551034));
                clienteRepository.save(new Cliente(203456, "Gustavo Peña", "gustavo@example.com", 5552034));
                clienteRepository.save(new Cliente(303456, "Felipe Salazar", "felipe@example.com", 5553034));
                clienteRepository.save(new Cliente(403456, "Santiago Aguilar", "santiago@example.com", 5554034));
                clienteRepository.save(new Cliente(503456, "Antonio Cardenas", "antonio@example.com", 5555034));
                clienteRepository.save(new Cliente(603456, "Mario Espinoza", "mario@example.com", 5556034));
                clienteRepository.save(new Cliente(703456, "Alejandro Fuentes", "alejandro@example.com", 5557034));
                clienteRepository.save(new Cliente(803456, "Guillermo Nunez", "guillermo@example.com", 5558034));
                clienteRepository.save(new Cliente(903456, "Hugo Cabrera", "hugo@example.com", 5559034));
                clienteRepository.save(new Cliente(104567, "Emilio Leon", "emilio@example.com", 5551045));
                clienteRepository.save(new Cliente(204567, "Ivan Molina", "ivan@example.com", 5552045));
                clienteRepository.save(new Cliente(304567, "Julio Ramos", "julio@example.com", 5553045));
                clienteRepository.save(new Cliente(404567, "Ruben Romero", "ruben@example.com", 5554045));
                clienteRepository.save(new Cliente(504567, "Angel Medina", "angel@example.com", 5555045));
                clienteRepository.save(new Cliente(604567, "Martin Ortiz", "martin@example.com", 5556045));
                clienteRepository.save(new Cliente(704567, "Samuel Delgado", "samuel@example.com", 5557045));
                clienteRepository.save(new Cliente(804567, "Cristian Herrera", "cristian@example.com", 5558045));
                clienteRepository.save(new Cliente(904567, "Joaquin Vargas", "joaquin@example.com", 5559045));
                clienteRepository.save(new Cliente(105678, "Vicente Castro", "vicente@example.com", 5551056));
                clienteRepository.save(new Cliente(205678, "Elias Rojas", "elias@example.com", 5552056));
                clienteRepository.save(new Cliente(305678, "Nicolas Guzman", "nicolas@example.com", 5553056));

           

                mascotaRepository.save(new Mascota("Pepe", "Pitbull", 10, 10.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Luna", "Labrador", 5, 15.f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Rocky", "Bulldog", 8, 12.f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo"));
                mascotaRepository.save(new Mascota("Bella", "Beagle", 3, 7.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Max", "Pastor alemán", 6, 20.f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera"));
                mascotaRepository.save(new Mascota("Toby", "Chihuahua", 2, 4.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Charlie", "Poodle", 4, 6.f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Milo", "Boxer", 7, 18.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Coco", "Dachshund", 5, 9.f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Buddy", "Shih Tzu", 3, 5.f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Duke", "Pitbull", 6, 16.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Bailey", "Labrador", 4, 14.f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Jack", "Bulldog", 7, 13.f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo"));
                mascotaRepository.save(new Mascota("Daisy", "Beagle", 2, 8.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Oliver", "Pastor alemán", 5, 22.f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera"));
                mascotaRepository.save(new Mascota("Riley", "Chihuahua", 3, 3.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Buster", "Poodle", 6, 7.f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Lucky", "Boxer", 8, 19.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Lola", "Dachshund", 4, 10.f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Sadie", "Shih Tzu", 5, 6.f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Rex", "Pitbull", 9, 17.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Maggie", "Labrador", 6, 16.f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Zeus", "Bulldog", 5, 11.f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo"));
                mascotaRepository.save(new Mascota("Chloe", "Beagle", 4, 7.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Oscar", "Pastor alemán", 7, 21.f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera"));
                mascotaRepository.save(new Mascota("Gizmo", "Chihuahua", 2, 4.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Rusty", "Poodle", 3, 6.5f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Bruno", "Boxer", 6, 18.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Molly", "Dachshund", 5, 9.5f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Sophie", "Shih Tzu", 3, 5.5f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Thor", "Pitbull", 8, 15.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Nala", "Labrador", 4, 14.5f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Tank", "Bulldog", 7, 12.5f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo"));
                mascotaRepository.save(new Mascota("Ruby", "Beagle", 3, 8.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Ace", "Pastor alemán", 6, 20.5f,"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera"));
                mascotaRepository.save(new Mascota("Ginger", "Chihuahua", 2, 3.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Shadow", "Poodle", 4, 7.2f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Simba", "Boxer", 5, 17.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Zoe", "Dachshund", 4, 10.2f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Lilly", "Shih Tzu", 3, 5.3f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Diesel", "Pitbull", 9, 16.5f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Roxy", "Labrador", 6, 15.5f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Gus", "Bulldog", 5, 11.5f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo"));
                mascotaRepository.save(new Mascota("Penny", "Beagle", 4, 7.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Finn", "Pastor alemán", 7, 21.5f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera"));
                mascotaRepository.save(new Mascota("Bambi", "Chihuahua", 3, 4.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Moose", "Poodle", 2, 6.8f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Apollo", "Boxer", 6, 19.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Ellie", "Dachshund", 5, 9.2f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Mimi", "Shih Tzu", 4, 5.7f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Duke", "Pitbull", 6, 16.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Bailey", "Labrador", 4, 14.f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Jake", "Bulldog", 7, 13.f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo"));
                mascotaRepository.save(new Mascota("Daisy", "Beagle", 2, 8.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Oliver", "Pastor alemán", 5, 22.f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera"));
                mascotaRepository.save(new Mascota("Riley", "Chihuahua", 3, 3.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Buster", "Poodle", 6, 7.f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Lucky", "Boxer", 8, 19.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Lola", "Dachshund", 4, 10.f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Sadie", "Shih Tzu", 5, 6.f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Rex", "Pitbull", 9, 17.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Maggie", "Labrador", 6, 16.f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Zeus", "Bulldog", 5, 11.f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo"));
                mascotaRepository.save(new Mascota("Chloe", "Beagle", 4, 7.f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Oscar", "Pastor alemán", 7, 21.f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera"));
                mascotaRepository.save(new Mascota("Gizmo", "Chihuahua", 2, 4.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Rusty", "Poodle", 3, 6.5f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Bruno", "Boxer", 6, 18.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Molly", "Dachshund", 5, 9.5f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Sophie", "Shih Tzu", 3, 5.5f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Thor", "Pitbull", 8, 15.f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Nala", "Labrador", 4, 14.5f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Tank", "Bulldog", 7, 12.5f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo"));
                mascotaRepository.save(new Mascota("Ruby", "Beagle", 3, 8.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna"));
                mascotaRepository.save(
                                new Mascota("Ace", "Pastor alemán", 6, 20.5f,
                                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                                "displasia de cadera"));
                mascotaRepository.save(new Mascota("Ginger", "Chihuahua", 2, 3.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Shadow", "Poodle", 4, 7.2f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Simba", "Boxer", 5, 17.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Zoe", "Dachshund", 4, 10.2f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Lilly", "Shih Tzu", 3, 5.3f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Diesel", "Pitbull", 9, 16.5f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Roxy", "Labrador", 6, 15.5f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Gus", "Bulldog", 5, 11.5f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                "alergia al polvo"));
                mascotaRepository.save(new Mascota("Penny", "Beagle", 4, 7.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna"));
                mascotaRepository.save(
                                new Mascota("Finn", "Pastor alemán", 7, 21.5f,
                                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                                "displasia de cadera"));
                mascotaRepository.save(new Mascota("Bambi", "Chihuahua", 3, 4.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Moose", "Poodle", 2, 6.8f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Apollo", "Boxer", 6, 19.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Ellie", "Dachshund", 5, 9.2f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Mimi", "Shih Tzu", 4, 5.7f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Benjy", "Pitbull", 9, 16.5f,
                                "https://images.ctfassets.net/denf86kkcx7r/339lIrj1wg9bpirJBfHn3X/a2be2e619c8c6dea173b50b6b2c80356/pitbull_seguro_santevet-33",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Freddy", "Labrador", 6, 15.5f,
                                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                                "ninguna"));
                mascotaRepository
                                .save(new Mascota("Kongo", "Bulldog", 5, 11.5f,
                                                "https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
                                                "alergia al polvo"));
                mascotaRepository.save(new Mascota("Spyke", "Beagle", 4, 7.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDf7WZQyhVJPJFFIn_CCvlr7tDi_lGiAc1Fw&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Rexona", "Pastor alemán", 7, 21.5f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "displasia de cadera"));
                mascotaRepository.save(new Mascota("Tuca", "Chihuahua", 3, 4.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj7cJKytBxmyhF5WjhCq0EzLteXw5QGvUL-w&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Canelita", "Poodle", 2, 6.8f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me._%285898350017%29.jpg",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Hueco", "Boxer", 6, 19.2f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ28UVVo8dO_LyUOLPSUi0lkvCiPk_FQht58Q&s",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Maximiliano", "Dachshund", 5, 9.2f,
                                "https://www.poochandmutt.co.uk/cdn/shop/articles/download_11.jpg?v=1627313486",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Fifi", "Shih Tzu", 4, 5.7f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
                mascotaRepository.save(new Mascota("Logan", "Shih Tzu", 4, 5.7f,
                                "https://www.orchardroadanimalhospital.com/sites/default/files/styles/large/public/shih-tzu-dog-breed-info.jpg?itok=CwWMOPs2",
                                "ninguna"));
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






