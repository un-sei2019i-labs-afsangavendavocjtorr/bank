package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields;


public enum UsersFields {
    Id(0),
    Email(1),
    Password(2);

    private int value;

    UsersFields(int value){
        this.value = value;
    }

    public int val(){
        return value;
    }
}
