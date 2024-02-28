package com.rest.api.superhero.service;

import com.rest.api.superhero.dto.SuperheroDTO;
import com.rest.api.superhero.mapper.SuperheroMapper;
import com.rest.api.superhero.model.Superhero;
import com.rest.api.superhero.repository.SuperheroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SuperheroService {

    private SuperheroRepository superheroRepository;

    private SuperheroMapper superheroMapper;

    SuperheroService(SuperheroRepository superheroRepository, SuperheroMapper superheroMapper) {
        this.superheroRepository = superheroRepository;
        this.superheroMapper = superheroMapper;
    }

    public void init() {
        Superhero batman = new Superhero("Batman", "Ciudad Gotica", "Ninguno", true);
        superheroRepository.save(batman);

        Superhero superman = new Superhero("Superman", "Metropolis", "Volar", true);
        superheroRepository.save(superman);

        Superhero spiderman = new Superhero("Spiderman", "Nueva York", "Telarañas", false);
        superheroRepository.save(spiderman);

        Superhero flechaVerde = new Superhero("Flecha Verde", "Starling", "Ninguno", false);
        superheroRepository.save(flechaVerde);

        Superhero thor = new Superhero("Thor", "Asgard", "Trueno", true);
        superheroRepository.save(thor);

        Superhero ironman = new Superhero("Ironman", "Nueva York", "Ninguno", false);
        superheroRepository.save(ironman);
    }


    public List<SuperheroDTO> findAll() {
        return superheroMapper.toDTOList(superheroRepository.findAll());
    }

    public Optional<SuperheroDTO> findSuperhero(String name) {
        SuperheroDTO ret = null;

        if (superheroRepository.findById(name).isPresent())
            ret = superheroMapper.toDTO(superheroRepository.findById(name).get());

        return Optional.ofNullable(ret);
    }

    public List<SuperheroDTO> findByNameContaining(String partialName) {
        return superheroMapper.toDTOList(superheroRepository.findByNameContaining(partialName));
    }

    public void createSuperhero(SuperheroDTO superhero) {
        superheroRepository.save(superheroMapper.toEntity(superhero));
    }

    public void updateSuperhero(SuperheroDTO superheroDTO) {
        Superhero updatedSuperhero = null;
        Optional<Superhero> opt = superheroRepository.findById(superheroDTO.getName());

        if (opt.isPresent()) {
            updatedSuperhero = opt.get();
            updatedSuperhero.setPower(superheroDTO.getPower());
            updatedSuperhero.setCity(superheroDTO.getCity());
            updatedSuperhero.setWearsCape(superheroDTO.wearsCape());

            superheroRepository.save(updatedSuperhero);
        }
    }

    public void deleteSuperhero(String name) {
        Optional<Superhero> superhero = superheroRepository.findById(name);
        superhero.ifPresent(value -> superheroRepository.delete(value));
    }

    public void deleteAll() {
        superheroRepository.deleteAll();
    }

    public boolean superheroExists(String name) {
        return superheroRepository.existsById(name);
    }

}
