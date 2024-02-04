package com.rest.api.superhero.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.util.List;

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
}
