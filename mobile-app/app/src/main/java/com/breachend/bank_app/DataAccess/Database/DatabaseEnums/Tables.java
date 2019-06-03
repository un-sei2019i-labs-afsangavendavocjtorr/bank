package com.breachend.bank_app.DataAccess.Database.DatabaseEnums;

public enum Tables {
    Users("USERS"),
     Account_Data("ACCOUNT_DATA"),
    Administrator("ADMINISTRATOR"),
    Transactions("TRANSACTIONS"),
    Transaction_Type("TRANSACTION_TYPE"),
    User_Password("USER_PASSWORD")  ;

    private String name;

    Tables(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
