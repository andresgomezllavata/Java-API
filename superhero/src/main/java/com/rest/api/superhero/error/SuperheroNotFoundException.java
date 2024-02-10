package com.rest.api.superhero.error;

public class SuperheroNotFoundException extends RuntimeException{
    private String name;

    public SuperheroNotFoundException(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return "El superheroe " + this.name + " no se ha encontrado en nuestra base de datos.";
    }

}
