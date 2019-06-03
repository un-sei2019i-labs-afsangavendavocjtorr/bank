package com.breachend.bank_app.DataAccess.Database.DatabaseEnums;

public enum Tables {
    Users("USERS"),
    AccountData("ACCOUNT_DATA"),
    Administrator("ADMINISTRATOR"),
    Transactions("TRANSACTIONS"),
    TransactionType("TRANSACTION_TYPE"),
    User_Password("USER_PASSWORD")  ;

    private String name;

    Tables(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
