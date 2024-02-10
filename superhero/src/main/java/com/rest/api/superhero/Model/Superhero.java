package com.rest.api.superhero.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "SUPERHEROES")
public class Superhero {

    @Id
    private String name;
    @Column
    private String city;
    @Column
    private String power;
    @Column
    private boolean wearsCape;

    public Superhero(String name, String city, String power, boolean wearsCape) {
        this.setName(name);
        this.setCity(city);
        this.setPower(power);
        this.setWearsCape(wearsCape);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public boolean wearsCape() {
        return wearsCape;
    }

    public void setWearsCape(boolean wearsCape) {
        this.wearsCape = wearsCape;
    }

    public Superhero() {
    }
}
