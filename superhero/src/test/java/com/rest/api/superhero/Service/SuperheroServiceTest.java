package com.rest.api.superhero.service;

import com.rest.api.superhero.model.Superhero;
import com.rest.api.superhero.repository.SuperheroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SuperheroServiceTest {
    @Autowired
    private SuperheroRepository repository;

    private SuperheroService service = null;

    @BeforeEach
    void setUp() {
        service = new SuperheroService(repository);
    }

    @Test
    void deleteAllAndResultShouldBeZero() {
        service.deleteAll();
        List<Superhero> result = service.findAll();
        assertEquals(result.size(), 0);
    }

    @Test
    void createOneAndThenDeleteAll() {
        service.deleteAll();

        Superhero superhero = new Superhero("Batman", "Ciudad Gotica", "Ninguno", true);
        service.createSuperhero(superhero);
        service.deleteAll();

        Optional<Superhero> opt = service.findSuperhero(superhero.getName());
        assertTrue(opt.isEmpty());
    }

    @Test
    void createOneAndFindIt() {
        service.deleteAll();

        Superhero superhero = new Superhero("Batman", "Ciudad Gotica", "Ninguno", true);
        service.createSuperhero(superhero);

        List<Superhero> list = service.findAll();
        assertEquals(list.size(), 1);

        Optional<Superhero> opt = service.findSuperhero(superhero.getName());
        assertThat(opt.get()).isEqualToComparingFieldByField(superhero);
    }

    @Test
    void createOneAndThenDeleteIt() {
        service.deleteAll();

        Superhero superhero = new Superhero("Batman", "Ciudad Gotica", "Ninguno", true);
        service.createSuperhero(superhero);
        service.deleteSuperhero(superhero.getName());

        Optional<Superhero> opt = service.findSuperhero(superhero.getName());
        assertTrue(opt.isEmpty());
    }

    @Test
    void updateOneAndCompareToTheNonUpdatedVersion() {
        service.deleteAll();

        Superhero superhero = new Superhero("Batman", "Ciudad Gotica", "Ninguno", true);
        service.createSuperhero(superhero);

        Superhero updatedSuperhero = service.findSuperhero(superhero.getName()).get();
        ;
        updatedSuperhero.setCity("Nueva York");
        service.updateSuperhero(updatedSuperhero);

        Optional<Superhero> opt = service.findSuperhero(superhero.getName());
        assertFalse(opt.get().getCity().equals(superhero.getCity()));
    }

    @Test
    void updateOneAndCompareToTheUpdatedVersion() {
        service.deleteAll();

        Superhero superhero = new Superhero("Batman", "Ciudad Gotica", "Ninguno", true);
        service.createSuperhero(superhero);

        Superhero updatedSuperhero = superhero;
        updatedSuperhero.setCity("Nueva York");
        service.updateSuperhero(updatedSuperhero);

        Optional<Superhero> opt = service.findSuperhero(superhero.getName());
        assertTrue(opt.isPresent());
        assertThat(opt.get()).isEqualToComparingFieldByField(superhero);
    }

    @Test
    void initTest() {
        service.deleteAll();
        service.init();

        List<Superhero> result = service.findAll();
        assertEquals(result.size(), 6);

        Optional<Superhero> batman = service.findSuperhero("Batman");
        Optional<Superhero> superman = service.findSuperhero("Superman");
        Optional<Superhero> spiderman = service.findSuperhero("Spiderman");
        Optional<Superhero> flechaVerde = service.findSuperhero("Flecha Verde");
        Optional<Superhero> thor = service.findSuperhero("Thor");
        Optional<Superhero> ironman = service.findSuperhero("Ironman");

        assertTrue(batman.isPresent());
        assertTrue(superman.isPresent());
        assertTrue(spiderman.isPresent());
        assertTrue(flechaVerde.isPresent());
        assertTrue(thor.isPresent());
        assertTrue(ironman.isPresent());
    }

    @Test
    void findAllTest() {
        service.deleteAll();
        service.init();

        List<Superhero> result = service.findAll();
        assertEquals(result.size(), 6);

        for (int i = 0; i < result.size(); i++) {
            Superhero superhero1 = result.get(i);
            Superhero superhero2 = service.findSuperhero(superhero1.getName()).get();
            assertThat(superhero1).isEqualToComparingFieldByField(superhero2);
        }
    }

    @Test
    void findByNameContainingTest() {
        boolean flag = true;
        service.deleteAll();
        service.init();

        List<Superhero> result = service.findByNameContaining("man");

        for (Superhero superhero : result) {
            flag = flag && superhero.getName().contains("man");
        }

        assertTrue(flag);
    }

}