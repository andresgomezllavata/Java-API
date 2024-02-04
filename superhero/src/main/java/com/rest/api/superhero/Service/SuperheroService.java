package com.rest.api.superhero.Service;

import com.rest.api.superhero.Model.Superhero;
import com.rest.api.superhero.Repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class SuperheroService {

    @Autowired
    private SuperheroRepository superheroRepository;

    public String init(){
        Superhero superhero = new Superhero();

        superhero.setName("Batman");
        superhero.setPower("Ninguno");
        superhero.setCity("Ciudad Gotica");
        superhero.setWearsCape(true);
        superheroRepository.save(superhero);

        superhero.setName("Superman");
        superhero.setPower("Volar");
        superhero.setCity("Metropolis");
        superhero.setWearsCape(true);
        superheroRepository.save(superhero);

        superhero.setName("Spiderman");
        superhero.setPower("Telarañas");
        superhero.setCity("Nueva York");
        superhero.setWearsCape(false);
        superheroRepository.save(superhero);

        superhero.setName("Flecha Verde");
        superhero.setPower("Ninguno");
        superhero.setCity("Starling");
        superhero.setWearsCape(false);
        superheroRepository.save(superhero);

        superhero.setName("Thor");
        superhero.setPower("Trueno");
        superhero.setCity("Asgard");
        superhero.setWearsCape(true);
        superheroRepository.save(superhero);

        superhero.setName("Ironman");
        superhero.setPower("Ninguno");
        superhero.setCity("Nueva York");
        superhero.setWearsCape(true);
        superheroRepository.save(superhero);


        return "La base de datos ha sido inicializada correctamente.";
    };


    public List<Superhero> findAll(){
        return superheroRepository.findAll();
    };


    public Optional<Superhero> findSuperhero(@PathVariable String name){
        return superheroRepository.findById(name);
    };


    public String createSuperhero(@RequestBody Superhero superhero) {
        Optional<Superhero> opt = superheroRepository.findById(superhero.getName());

        if (!opt.isPresent()) {
            superheroRepository.save(superhero);
            return superhero.getName() + " ha sido dado de alta correctamente.";
        } else {
            return superhero.getName() + " ya se encontraba dado de alta en nuestra base de datos.";
        }
    };

    public String  updateSuperhero(@RequestBody Superhero superhero) {
        Superhero updatedSuperhero = null;
        Optional<Superhero> opt = superheroRepository.findById(superhero.getName());

        if (opt.isPresent()) {
            updatedSuperhero = opt.get();
            updatedSuperhero.setPower(superhero.getPower());
            updatedSuperhero.setCity(superhero.getCity());
            updatedSuperhero.setWearsCape(superhero.wearsCape());

            superheroRepository.save(updatedSuperhero);
            return superhero.getName() + " ha sido actualizado correctamente.";
        } else {
            return "No hemos encontrado a " + superhero.getName() + " en nuestra base de datos.";
        }
    };


    public String deleteSuperhero(@PathVariable String name) {
        Optional<Superhero> opt = superheroRepository.findById(name);

        if (opt.isPresent()) {
            superheroRepository.delete(opt.get());
            return name + " ha sido eliminado correctamente de nuestra base de datos.";
        } else {
            return name + " no se encuentra dado de alta en nuestra base de datos.";
        }
    };

    public String deleteAll() {
        superheroRepository.deleteAll();
        return "Todos los superheroes fueron eliminados de la base de datos.";
    };

    public List<Superhero> findByNameContaining(String partialName) {
        return superheroRepository.findByNameContaining(partialName);
    };
}
