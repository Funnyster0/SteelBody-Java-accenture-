package com.accenture.steelbody.container;

import com.accenture.steelbody.TableContainer;

public class Shop extends TableContainer {

    private int id;
    private String name;
    private int idAddress;

    public Shop()
    {
        this.id = 0;
        this.name = null;
        this.idAddress = 0;
    }

    public Shop(int id, String name, int idAddress) {
        this.id = id;
        this.name = name;
        this.idAddress = idAddress;
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

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }
}