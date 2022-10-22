package com.accenture.steelbody.container;

import com.accenture.steelbody.TableContainer;

public class Manufacturer extends TableContainer {

    private int id;
    private String name;

    public Manufacturer() {
        this.id = 0;
        this.name = null;
    }

    public Manufacturer(int id, String name) {
        this.id = id;
        this.name = name;
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
}