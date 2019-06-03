package com.breachend.bank_app.DataAccess.Models;

import java.util.Date;

public class UserModel {
    private int id;
    private String name;
    private Date created_date;
    private String status_user;
    private int created_by
    private String email;
    private String password;

    public UserModel(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
