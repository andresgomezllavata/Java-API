package com.rest.api.superhero.service;

import com.rest.api.superhero.dto.SuperheroDTO;
import com.rest.api.superhero.mapper.SuperheroMapper;
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
    private SuperheroRepository superheroRepository;
    @Autowired
    private SuperheroMapper superheroMapper;
    private SuperheroService superheroService = null;

    @BeforeEach
    void setUp() {
        superheroService = new SuperheroService(superheroRepository, superheroMapper);
    }

    @Test
    void deleteAllAndResultShouldBeZero() {
        superheroService.deleteAll();
        List<SuperheroDTO> result = superheroService.findAll();
        assertEquals(result.size(), 0);
    }

    @Test
    void createOneAndThenDeleteAll() {
        superheroService.deleteAll();

        SuperheroDTO superhero = new SuperheroDTO("Batman", "Ciudad Gotica", "Ninguno", true);
        superheroService.createSuperhero(superhero);
        superheroService.deleteAll();

        Optional<SuperheroDTO> opt = superheroService.findSuperhero(superhero.getName());
        assertTrue(opt.isEmpty());
    }

    @Test
    void createOneAndFindIt() {
        superheroService.deleteAll();

        SuperheroDTO superhero = new SuperheroDTO("Batman", "Ciudad Gotica", "Ninguno", true);
        superheroService.createSuperhero(superhero);

        List<SuperheroDTO> list = superheroService.findAll();
        assertEquals(list.size(), 1);

        Optional<SuperheroDTO> opt = superheroService.findSuperhero(superhero.getName());
        assertThat(opt.get()).isEqualToComparingFieldByField(superhero);
    }

    @Test
    void createOneAndThenDeleteIt() {
        superheroService.deleteAll();

        SuperheroDTO superhero = new SuperheroDTO("Batman", "Ciudad Gotica", "Ninguno", true);
        superheroService.createSuperhero(superhero);
        superheroService.deleteSuperhero(superhero.getName());

        Optional<SuperheroDTO> opt = superheroService.findSuperhero(superhero.getName());
        assertTrue(opt.isEmpty());
    }

    @Test
    void updateOneAndCompareToTheNonUpdatedVersion() {
        superheroService.deleteAll();

        SuperheroDTO superhero = new SuperheroDTO("Batman", "Ciudad Gotica", "Ninguno", true);
        superheroService.createSuperhero(superhero);

        SuperheroDTO updatedSuperhero = superheroService.findSuperhero(superhero.getName()).get();
        updatedSuperhero.setCity("Nueva York");
        superheroService.updateSuperhero(updatedSuperhero);

        Optional<SuperheroDTO> opt = superheroService.findSuperhero(superhero.getName());
        assertFalse(opt.get().getCity().equals(superhero.getCity()));
    }

    @Test
    void updateOneAndCompareToTheUpdatedVersion() {
        superheroService.deleteAll();

        SuperheroDTO superhero = new SuperheroDTO("Batman", "Ciudad Gotica", "Ninguno", true);
        superheroService.createSuperhero(superhero);

        SuperheroDTO updatedSuperhero = superhero;
        updatedSuperhero.setCity("Nueva York");
        superheroService.updateSuperhero(updatedSuperhero);

        Optional<SuperheroDTO> opt = superheroService.findSuperhero(superhero.getName());
        assertTrue(opt.isPresent());
        assertThat(opt.get()).isEqualToComparingFieldByField(superhero);
    }

    @Test
    void initTest() {
        superheroService.deleteAll();
        superheroService.init();

        List<SuperheroDTO> result = superheroService.findAll();
        assertEquals(result.size(), 6);

        Optional<SuperheroDTO> batman = superheroService.findSuperhero("Batman");
        Optional<SuperheroDTO> superman = superheroService.findSuperhero("Superman");
        Optional<SuperheroDTO> spiderman = superheroService.findSuperhero("Spiderman");
        Optional<SuperheroDTO> flechaVerde = superheroService.findSuperhero("Flecha Verde");
        Optional<SuperheroDTO> thor = superheroService.findSuperhero("Thor");
        Optional<SuperheroDTO> ironman = superheroService.findSuperhero("Ironman");

        assertTrue(batman.isPresent());
        assertTrue(superman.isPresent());
        assertTrue(spiderman.isPresent());
        assertTrue(flechaVerde.isPresent());
        assertTrue(thor.isPresent());
        assertTrue(ironman.isPresent());
    }

    @Test
    void findAllTest() {
        superheroService.deleteAll();
        superheroService.init();

        List<SuperheroDTO> result = superheroService.findAll();
        assertEquals(result.size(), 6);

        for (int i = 0; i < result.size(); i++) {
            SuperheroDTO superhero = result.get(i);
            SuperheroDTO superheroDTO = superheroService.findSuperhero(superhero.getName()).get();
            assertThat(superhero).isEqualToComparingFieldByField(superheroMapper.toEntity(superheroDTO));
        }
    }

    @Test
    void findByNameContainingTest() {
        boolean flag = true;
        superheroService.deleteAll();
        superheroService.init();

        List<SuperheroDTO> result = superheroService.findByNameContaining("man");

        for (SuperheroDTO superheroDTO : result) {
            flag = flag && superheroDTO.getName().contains("man");
        }

        assertTrue(flag);
    }

}