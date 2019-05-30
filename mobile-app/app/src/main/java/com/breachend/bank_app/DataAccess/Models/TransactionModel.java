package com.breachend.bank_app.DataAccess.Models;

import java.util.Date;

public class TransactionModel {
    private int id;
    private int type;
    private int receiver;
    private int TransmitterAccount;
    private int TransmitterAdmin;
    private Date date;
    private String status;
    private double money;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getTransmitterAccount() {
        return TransmitterAccount;
    }

    public void setTransmitterAccount(int transmitterAccount) {
        TransmitterAccount = transmitterAccount;
    }

    public int getTransmitterAdmin() {
        return TransmitterAdmin;
    }

    public void setTransmitterAdmin(int transmitterAdmin) {
        TransmitterAdmin = transmitterAdmin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
