package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields;


public enum UsersFields {
   /* Id(0, "ID", "INTEGER PRIMARY KEY AUTOINCREMENT"),
    Email(1, "EMAIL", "VARCHAR(100) UNIQUE NOT NULL"),
    Password(2, "PASSWORD", "VARCHAR(100) NOT NULL");
*/
   Id(0, "ID", "INTEGER PRIMARY KEY AUTOINCREMENT"),
    NAME(1, "NAME", "varchar(50) NOT null"),
    CREATED_DATE(2,"CREATED_DATE","datetime null"),
    STATUS_USER(3,"STATUS_USER","varchar(10) null"),
    CREATED_BY(4,"CREATED_BY","INTEGER NOT null"),
    EMAIL(5,"EMAIL","varchar(50) UNIQUE NOT null");

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

