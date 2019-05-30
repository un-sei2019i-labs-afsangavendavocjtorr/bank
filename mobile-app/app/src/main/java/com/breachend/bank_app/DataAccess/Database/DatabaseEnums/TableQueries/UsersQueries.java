package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

public enum UsersQueries {
    SelectById(0),
    SelectByEmail(1),
    SelectAll(2);

    private int value;

    UsersQueries(int value){
        this.value = value;
    }

    public int val(){
        return value;
    }
}
