package com.accenture.steelbody.container;

import com.accenture.steelbody.TableContainer;

public class UserOrder extends TableContainer {

    private int id;
    private int idUser;
    private int idAvailability;
    private int numOf;

    public UserOrder() {
        this.id = 0;
        this.idUser = 0;
        this.idAvailability = 0;
        this.numOf = 0;
    }

    public UserOrder(int id, int idUser, int idAvailability, int numOf) {
        this.id = id;
        this.idUser = idUser;
        this.idAvailability = idAvailability;
        this.numOf = numOf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdAvailability() {
        return idAvailability;
    }

    public void setIdAvailability(int idAvailability) {
        this.idAvailability = idAvailability;
    }

    public int getNumOf() {
        return numOf;
    }

    public void setNumOf(int numOf) {
        this.numOf = numOf;
    }
}