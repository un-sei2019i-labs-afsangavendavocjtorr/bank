package com.breachend.bank_app.DataAccess.Models;

public class UserModel {
    private int id;
    private String name;
    private String created_date;//en la aplicacion se manejara como String con cierto formato para su insercion en BD
    private String status_user;
    private int created_by;
    private String email;

    public UserModel(int id, String name, String created_date, String status_user, int created_by, String email) {
        this.id = id;
        this.name = name;
        this.created_date = created_date;
        this.status_user = status_user;
        this.created_by = created_by;
        this.email = email;
    }

    public UserModel(String name, String created_date, String status_user, int created_by, String email) {
        this.name = name;
        this.created_date = created_date;
        this.status_user = status_user;
        this.created_by = created_by;
        this.email = email;
    }

    public UserModel() {
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

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getStatus_user() {
        return status_user;
    }

    public void setStatus_user(String status_user) {
        this.status_user = status_user;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
