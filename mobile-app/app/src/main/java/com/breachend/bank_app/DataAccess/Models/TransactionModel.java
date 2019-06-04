package com.breachend.bank_app.DataAccess.Models;

public class TransactionModel {
    private int id;
    private int typeTransaction;
    private int receiver;
    private int transmitterAccount;
    private int transmitterAdmin;
    private String dateTransaction;
    private String statusTransaction;
    private double amount;


    public TransactionModel() {
    }

    public TransactionModel(int typeTransaction, int receiver, int transmitterAccount, int transmitterAdmin, String dateTransaction, String statusTransaction, double amount) {
        this.typeTransaction = typeTransaction;
        this.receiver = receiver;
        this.transmitterAccount = transmitterAccount;
        this.transmitterAdmin = transmitterAdmin;
        this.dateTransaction = dateTransaction;
        this.statusTransaction = statusTransaction;
        this.amount = amount;
    }

    public TransactionModel(int id, int typeTransaction, int receiver, int transmitterAccount, int transmitterAdmin, String dateTransaction, String statusTransaction, double amount) {
        this.id = id;
        this.typeTransaction = typeTransaction;
        this.receiver = receiver;
        this.transmitterAccount = transmitterAccount;
        this.transmitterAdmin = transmitterAdmin;
        this.dateTransaction = dateTransaction;
        this.statusTransaction = statusTransaction;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(int typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getTransmitterAccount() {
        return transmitterAccount;
    }

    public void setTransmitterAccount(int transmitterAccount) {
        this.transmitterAccount = transmitterAccount;
    }

    public int getTransmitterAdmin() {
        return transmitterAdmin;
    }

    public void setTransmitterAdmin(int transmitterAdmin) {
        this.transmitterAdmin = transmitterAdmin;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }

    public void setStatusTransaction(String statusTransaction) {
        this.statusTransaction = statusTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
