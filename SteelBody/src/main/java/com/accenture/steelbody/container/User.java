package com.accenture.steelbody.container;

import com.accenture.steelbody.TableContainer;

public class User extends TableContainer {

    private int id;
    private int status;
    private String name;
    private String email;
    private String password;

    public User() {
        this.id = 0;
        this.status = 0;
        this.name = null;
        this.email = null;
        this.password = null;
    }

    public User(int id, int status, String name, String email, String password) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}