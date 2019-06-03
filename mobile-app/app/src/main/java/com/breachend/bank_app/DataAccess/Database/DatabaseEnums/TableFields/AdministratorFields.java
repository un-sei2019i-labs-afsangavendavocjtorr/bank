package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields;

public enum AdministratorFields {
    ID(0, "ID", "bigint  identity primary key"),
    EMAIL(1, "BALANCE", "varchar(50) UNIQUE NOT null"),
    PASSWORD_ADMINISTRATOR(2,"PASSWORD_ADMINISTRATOR","varchar(6) null"),
    CREATED_DATE(3,"CREATED_DATE","datetime null");

    private int position;
    private String Key;
    private String dataType;
    private AdministratorFields(int position, String Key, String dataType){
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
