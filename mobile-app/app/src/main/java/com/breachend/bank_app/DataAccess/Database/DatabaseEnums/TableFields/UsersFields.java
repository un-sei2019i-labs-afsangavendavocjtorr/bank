package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields;


public enum UsersFields {
    Id(0, "ID", "INTEGER PRIMARY KEY AUTOINCREMENT"),
    Email(1, "EMAIL", "VARCHAR(100) UNIQUE NOT NULL"),
    Password(2, "PASSWORD", "VARCHAR(100) NOT NULL");

    private int position;
    private String key;
    private String dataType;

    UsersFields(int position, String key, String dataType) {
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

