package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields;


public enum UsersFields {
    Id(0),
    Name(1),
    Email(2),
    Password(3);

    private int value;

    UsersFields(int value){
        this.value = value;
    }

    public int val(){
        return value;
    }
}
