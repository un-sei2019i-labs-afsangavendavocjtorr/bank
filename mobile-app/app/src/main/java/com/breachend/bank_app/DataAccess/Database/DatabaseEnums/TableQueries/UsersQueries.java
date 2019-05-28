package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

public enum UsersQueries {
    SelectById(0),
    SelectByEmil(1);

    private int value;

    UsersQueries(int value){
        this.value = value;
    }

    public int Val(){
        return value;
    }
}
