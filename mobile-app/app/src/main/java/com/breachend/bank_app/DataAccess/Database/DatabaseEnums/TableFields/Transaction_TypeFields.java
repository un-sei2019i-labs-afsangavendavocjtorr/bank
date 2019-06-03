package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields;

public enum Transaction_TypeFields {
    ID(0, "ID", "int PRIMARY KEY"),
    NAME(1, "NAME", "varchar(20) null"),
    CREATED_DATE(2, "CREATED_DATE", "datetime null");

    private int position;
    private String key;
    private String dataType;

   Transaction_TypeFields(int position, String key, String dataType) {
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
