package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields;

public enum AccountFields {
    AC_CODE(0, "AC_CODE", "bigint identity primary key"),
    BALANCE(1, "BALANCE", "money null"),
ID_USER(2,"ID_USER","bigint null");


    private int position;
    private String Key;
    private String dataType;
    private AccountFields(int position, String Key, String dataType){
        this.position=position;
        this.Key=Key;
        this.dataType=dataType;
    }

    public int getPosition() {
        return position;
    }

    public String getKey() {
        return Key;
    }

    public String getDataType() {
        return dataType;
    }
}
