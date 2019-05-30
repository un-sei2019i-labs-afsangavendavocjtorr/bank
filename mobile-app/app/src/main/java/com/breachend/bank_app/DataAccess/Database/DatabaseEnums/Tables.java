package com.breachend.bank_app.DataAccess.Database.DatabaseEnums;

public enum Tables {
    Users(0);

    private int value;

    Tables(int value){
        this.value = value;
    }

    public int val(){
        return value;
    }

}
