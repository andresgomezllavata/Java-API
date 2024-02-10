package com.rest.api.superhero.error;

public class SuperheroAlreadyExistedException extends RuntimeException {

    private String name;

    public SuperheroAlreadyExistedException(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return "El superheroe " + this.name + " ya se encontraba dado de alta en nuestra base de datos.";
    }
}
