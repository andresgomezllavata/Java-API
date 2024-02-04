package com.rest.api.superhero.Controller;

import com.rest.api.superhero.Model.Superhero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rest.api.superhero.Service.SuperheroService;
import java.util.List;
import java.util.Optional;

@RestController
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    //SuperheroController(SuperheroService superheroService){
    //    this.superheroService = superheroService;
    //}

    @GetMapping(value = "/init")
    public String init(){
        return superheroService.init();
    };

    @GetMapping(value = "/findAll")
    public List<Superhero> findAll(){
        return superheroService.findAll();
    };

    @GetMapping(value = "/findByName/{name}")
    public Optional<Superhero> findSuperhero(@PathVariable String name){
        return superheroService.findSuperhero(name);
    };

    @GetMapping(value = "/findByNameContaining/{partialName}")
    public List<Superhero> findByNameContaining(@PathVariable String partialName){
        return superheroService.findByNameContaining(partialName);
    };

    @PostMapping(value = "/create")
    public String createSuperhero(@RequestBody Superhero superhero) {
        return superheroService.createSuperhero(superhero);
    };

    @PutMapping(value = "/update")
    public String  updateSuperhero(@RequestBody Superhero superhero) {
        return superheroService.updateSuperhero(superhero);
    };

    @DeleteMapping(value = "/delete/{name}")
    public String deleteSuperhero(@PathVariable String name) {
        return superheroService.deleteSuperhero(name);
    };

    @DeleteMapping(value = "/delete")
    public String deleteAll() {
        return superheroService.deleteAll();
    };
}
