package com.breachend.bank_app.DataAccess.Models;

public class PasswordModel {
    private int id;
    private int idUser;
    private String passwordUser;
    private String statusPassword;
    private String createdDate;//en la aplicacion se manejara como String con cierto formato para su insercion en BD


    public PasswordModel (){

    }

    public PasswordModel(int id, int idUser, String passwordUser, String statusPassword, String createdDate) {
        this.id = id;
        this.idUser = idUser;
        this.passwordUser = passwordUser;
        this.statusPassword = statusPassword;
        this.createdDate = createdDate;
    }


    public PasswordModel(int idUser, String passwordUser, String statusPassword, String createdDate) {
        this.idUser = idUser;
        this.passwordUser = passwordUser;
        this.statusPassword = statusPassword;
        this.createdDate = createdDate;
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

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getStatusPassword() {
        return statusPassword;
    }

    public void setStatusPassword(String statusPassword) {
        this.statusPassword = statusPassword;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
