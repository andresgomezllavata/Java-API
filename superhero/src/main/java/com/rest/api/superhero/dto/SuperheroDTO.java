package com.rest.api.superhero.dto;

public class SuperheroDTO {

    private String name;
    private String city;
    private String power;
    private boolean wearsCape;

    public SuperheroDTO(String name, String city, String power, boolean wearsCape) {
        this.setName(name);
        this.setCity(city);
        this.setPower(power);
        this.setWearsCape(wearsCape);
    }

    public SuperheroDTO() { }

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
