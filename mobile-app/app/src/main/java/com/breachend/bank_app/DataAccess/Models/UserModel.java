package com.breachend.bank_app.DataAccess.Models;

public class UserModel {
    private int id;
    private String name;
    private String createdDate;//en la aplicacion se manejara como String con cierto formato para su insercion en BD
    private String statusUser;
    private int createdBy;
    private String email;

    public UserModel(int id, String name, String createdDate, String statusUser, int createdBy, String email) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.statusUser = statusUser;
        this.createdBy = createdBy;
        this.email = email;
    }

    public UserModel(String name, String createdDate, String statusUser, int createdBy, String email) {
        this.name = name;
        this.createdDate = createdDate;
        this.statusUser = statusUser;
        this.createdBy = createdBy;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(String statusUser) {
        this.statusUser = statusUser;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
