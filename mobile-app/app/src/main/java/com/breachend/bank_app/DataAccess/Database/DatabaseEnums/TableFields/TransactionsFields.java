package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields;

public enum TransactionsFields {
    ID(0, "ID", "INTEGER PRIMARY KEY AUTOINCREMENT"),
    TYPE_TRANSACTION(1, "TYPE_TRANSACTION", "INTEGER null"),
    RECEIVER(2, "RECEIVER", "INTEGER null"),
    TRANSMITTER_ACCOUNT(3, "TRANSMITTER_ACCOUNT", "INTEGER null"),
    TRANSMITTER_ADMIN(4, "TRANSMITTER_ADMIN", "INTEGER null"),
    DATE_TRANSACTION(5, "DATE_TRANSACTION", "INTEGER null"),
    STATUS_TRANSACTION(6, "STATUS_TRANSACTION", "varchar(10) null"),
    AMOUNT(7, "AMOUNT", "DOUBLE null")  ;




    private int position;
    private String key;
    private String dataType;

   TransactionsFields(int position, String key, String dataType) {
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
