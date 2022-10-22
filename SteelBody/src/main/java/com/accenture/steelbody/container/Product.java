package com.accenture.steelbody.container;

import com.accenture.steelbody.TableContainer;

public class Product extends TableContainer {

    private int id;
    private String name;
    private int idManufacturer;
    private String description;
    private int price;


    public Product()
    {
        this.id = 0;
        this.name = null;
        this.idManufacturer = 0;
        this.description = null;
        this.price = 0;
    }

    public Product(int id, String name, int idManufacturer, String description, int price) {
        this.id = id;
        this.name = name;
        this.idManufacturer = idManufacturer;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}