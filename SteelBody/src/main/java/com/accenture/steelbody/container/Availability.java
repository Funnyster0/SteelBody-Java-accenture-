package com.accenture.steelbody.container;

import com.accenture.steelbody.TableContainer;

public class Availability extends TableContainer {

    private int id;
    private int idShop;
    private int idProduct;
    private int numOf;

    public Availability()
    {
        this.id = 0;
        this.idShop = 0;
        this.idProduct = 0;
        this.numOf = 0;
    }

    public Availability(int id, int idShop, int idProduct, int numOf) {
        this.id = id;
        this.idShop = idShop;
        this.idProduct = idProduct;
        this.numOf = numOf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getNumOf() {
        return numOf;
    }

    public void setNumOf(int numOf) {
        this.numOf = numOf;
    }
}