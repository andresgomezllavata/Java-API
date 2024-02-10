package com.rest.api.superhero.service;

import com.rest.api.superhero.model.Superhero;
import com.rest.api.superhero.repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class SuperheroService {

    @Autowired
    private SuperheroRepository superheroRepository;

    SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public void init(){
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
    };

    public List<Superhero> findAll(){
        return superheroRepository.findAll();
    };

    public Optional<Superhero> findSuperhero(String name){
        return superheroRepository.findById(name);
    };
    public List<Superhero> findByNameContaining(String partialName) {
        return superheroRepository.findByNameContaining(partialName);
    };

    public Superhero createSuperhero(Superhero superhero) {
        return superheroRepository.save(superhero);
    };

    public void updateSuperhero(Superhero superhero) {
        Superhero updatedSuperhero = null;
        Optional<Superhero> opt = superheroRepository.findById(superhero.getName());

        if (opt.isPresent()) {
            updatedSuperhero = opt.get();
            updatedSuperhero.setPower(superhero.getPower());
            updatedSuperhero.setCity(superhero.getCity());
            updatedSuperhero.setWearsCape(superhero.wearsCape());

            superheroRepository.save(updatedSuperhero);
        }
    };

    public void deleteSuperhero(String name) {
        Optional<Superhero> superhero = superheroRepository.findById(name);
        superhero.ifPresent(value -> superheroRepository.delete(value));
    };

    public void deleteAll() {
        superheroRepository.deleteAll();
    };

    public boolean superheroExists(String name) {
        return superheroRepository.existsById(name);
    };

}
