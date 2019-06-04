package com.breachend.bank_app.DataAccess.Models;

public class AccountDataModel {
    private int acCode;
    private double balance;
    private int id_user;

    public AccountDataModel() {
    }

    public AccountDataModel(int acCode, double balance, int id_user) {
        this.acCode = acCode;
        this.balance = balance;
        this.id_user = id_user;
    }

    public AccountDataModel(double balance, int id_user) {
        this.balance = balance;
        this.id_user = id_user;
    }

    public int getAcCode() {
        return acCode;
    }

    public void setAcCode(int acCode) {
        this.acCode = acCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
