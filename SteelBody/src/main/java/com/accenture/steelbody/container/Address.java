package com.accenture.steelbody.container;
import com.accenture.steelbody.TableContainer;

public class Address extends TableContainer {

    private int id;
    private String country;
    private String town;
    private String street;
    private int house;

    public Address() {
        this.id = 0;
        this.country = null;
        this.town = null;
        this.street = null;
        this.house = 0;
    }

    public Address(int id, String country, String town, String street, int house) {
        this.id = id;
        this.country = country;
        this.town = town;
        this.street = street;
        this.house = house;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }
}