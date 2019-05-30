package com.breachend.bank_app.DataAccess.Database.DatabaseEnums;

public enum Tables {
    Users("USERS");

    private String name;

    Tables(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
