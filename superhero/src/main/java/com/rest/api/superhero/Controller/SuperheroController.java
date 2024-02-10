package com.rest.api.superhero.controller;

import com.rest.api.superhero.error.SuperheroAlreadyExistedException;
import com.rest.api.superhero.error.SuperheroNotFoundException;
import com.rest.api.superhero.model.Superhero;
import com.rest.api.superhero.service.SuperheroService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    @GetMapping(value = "/init")
    public ResponseEntity<Object> init(){
        superheroService.init();
        return new ResponseEntity<>("La base de datos ha sido inicializada correctamente.", HttpStatus.OK);
    };

    @GetMapping(value = "/findAll")
    public ResponseEntity<Object> findAll(){
        List<Superhero> list = superheroService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    };

    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name){
        if (superheroService.superheroExists(name)) {
            Optional<Superhero> superhero = superheroService.findSuperhero(name);
            return superhero.<ResponseEntity<Object>>map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Ha ocurrido un error inesperado, vuelva a intentar.", HttpStatus.INTERNAL_SERVER_ERROR));
        } else {
            throw new SuperheroNotFoundException(name);
        }
    };

    @GetMapping(value = "/findByNameContaining/{partialName}")
    public ResponseEntity<Object> findByNameContaining(@PathVariable String partialName){
        List<Superhero> list = superheroService.findByNameContaining(partialName);
        return new ResponseEntity<>(list, HttpStatus.OK);
    };

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createSuperhero(@RequestBody Superhero superhero) {
        if (!superheroService.superheroExists(superhero.getName())) {
            superheroService.createSuperhero(superhero);
            return new ResponseEntity<>(superhero.getName() + " ha sido dado de alta correctamente.", HttpStatus.CREATED);
        } else {
            throw new SuperheroAlreadyExistedException(superhero.getName());
        }
    };

    @PutMapping(value = "/update")
    public ResponseEntity<Object>  updateSuperhero(@RequestBody Superhero superhero) {
        if (superheroService.superheroExists(superhero.getName())) {
            superheroService.updateSuperhero(superhero);
            return new ResponseEntity<>(superhero.getName() + " ha sido actualizado correctamente.", HttpStatus.OK);
        } else {
            throw new SuperheroNotFoundException(superhero.getName());
        }
    };

    @DeleteMapping(value = "/delete/{name}")
    public ResponseEntity<Object> deleteSuperhero(@PathVariable String name) {
        if (superheroService.superheroExists(name)) {
            superheroService.deleteSuperhero(name);
            return new ResponseEntity<>(name + " ha sido eliminado correctamente de nuestra base de datos.", HttpStatus.OK);
        } else {
            throw new SuperheroNotFoundException(name);
        }
    };

    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        superheroService.deleteAll();
        return new ResponseEntity<>("Todos los superheroes fueron eliminados de la base de datos.", HttpStatus.OK);
    };
}
