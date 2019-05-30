package com.breachend.bank_app.DataAccess.Models;

public class AccountDataModel {
    private int AC_Code;
    private int user_id;
    private double balance;

    public int getAC_Code() {
        return AC_Code;
    }

    public void setAC_Code(int AC_Code) {
        this.AC_Code = AC_Code;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
