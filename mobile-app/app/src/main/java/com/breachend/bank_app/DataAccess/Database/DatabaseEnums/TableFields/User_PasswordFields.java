package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields;

public enum User_PasswordFields {
    ID(0, "ID", "INTEGER PRIMARY KEY AUTOINCREMENT"),
    ID_USER(1, "ID_USER", "INTEGER not null"),
    PASSWORD_USER(2, "PASSWORD_USER", " INTEGER NOT null"),
    STATUS_PASSWORD(3,"STATUS_PASSWORD","varchar(15) NOT null"),
    CREATED_DATE(4,"CREATED_DATE","datetime NOT null");

    private int position;
    private String key;
    private String dataType;

    User_PasswordFields (int position, String key, String dataType) {
        this.position = position;
        this.key = key;
        this.dataType = dataType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
