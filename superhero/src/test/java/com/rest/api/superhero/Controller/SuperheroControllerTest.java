/*package com.rest.api.superhero.Controller;

import com.rest.api.superhero.Model.Superhero;
import com.rest.api.superhero.Repository.SuperheroRepository;
import com.rest.api.superhero.SuperheroApiApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
//@TestPropertySource("classpath:resources/application.properties")
@SpringBootTest
//@ContextConfiguration(classes = SuperheroApiApplication.class)
//@PropertySource("classpath:resources/application.properties")
class SuperheroControllerTest {
    @Autowired
    private SuperheroRepository repository;

    private SuperheroController controller = null;

    @BeforeEach
    void setUp(){
        //controller = new SuperheroController(repository);
    }

    @Test
    void initTest() {
        //String expectedResult = "[{\"name\":\"Batman\",\"city\":\"Ciudad Gotica\",\"power\":\"Ninguno\"},{\"name\":\"Superman\",\"city\":\"Metropolis\",\"power\":\"Volar\"},{\"name\":\"Spiderman\",\"city\":\"Nueva York\",\"power\":\"Telarañas\"},{\"name\":\"Flecha Verde\",\"city\":\"Starling\",\"power\":\"Ninguno\"},{\"name\":\"Thor\",\"city\":\"Asgard\",\"power\":\"Trueno\"},{\"name\":\"Ironman\",\"city\":\"Nueva York\",\"power\":\"Ninguno\"}]";
        //
        //controller.deleteAll();
        //controller.init();
        //List<Superhero> result = controller.findAll();
        //String s = result.toString();
        //
    }

    @Test
    void findAll() {
    }

    @Test
    void findSuperhero() {
    }

    @Test
    void createSuperhero() {
        Superhero superhero = new Superhero();
        superhero.setName("Batman");
        superhero.setPower("Ninguno");
        superhero.setCity("Ciudad Gotica");
        superhero.setWearsCape(true);

        

    }

    @Test
    void updateSuperhero() {
    }

    @Test
    void deleteSuperhero() {
    }
}*/