package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.TransactionsFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public enum TransactionsQueries {
    Create("CREATE TABLE "+ Tables.Transactions.getName() + " (" +
            TransactionsFields.ID.getKey() + " "+TransactionsFields.ID.getDataType() + ", " +
            TransactionsFields.TYPE_TRANSACTION.getKey() + " " + TransactionsFields.TYPE_TRANSACTION.getDataType() + ", " +
            TransactionsFields.RECEIVER.getKey() + " " + TransactionsFields.RECEIVER.getDataType() +", "+
            TransactionsFields.TRANSMITTER_ACCOUNT.getKey()+" "+TransactionsFields.TRANSMITTER_ACCOUNT.getDataType()+", "+
            TransactionsFields.TRANSMITTER_ADMIN.getKey()+" "+TransactionsFields.TRANSMITTER_ADMIN.getDataType()+", "+
            TransactionsFields.DATE_TRANSACTION.getKey()+" "+TransactionsFields.DATE_TRANSACTION.getDataType()+", "+
            TransactionsFields.AMOUNT.getKey()+" "+TransactionsFields.AMOUNT.getDataType()+
            ");"),
    Drop("DROP TABLE IF EXISTS "+ Tables.Transactions.getName() +";"),
    SelectById("SELECT * FROM "+ Tables.Transactions.getName() +" WHERE " + TransactionsFields.ID.getKey() + " = %d;"),
    SelectByReceiver("SELECT * FROM "+ Tables.Transactions.getName() +" WHERE " + TransactionsFields.RECEIVER.getKey() +" = '%d';"),
    SelectByTransmitterAccount("SELECT * FROM "+ Tables.Transactions.getName() +" WHERE " + TransactionsFields.TRANSMITTER_ACCOUNT.getKey() +" = '%d';"),
    SelectByTransmitterAdmin("SELECT * FROM "+ Tables.Transactions.getName() +" WHERE " + TransactionsFields.TRANSMITTER_ADMIN.getKey() +" = '%d';"),
    SelectAll("SELECT * FROM "+ Tables.Transactions.getName() +";");

    private String query;

    TransactionsQueries(String query) {
        this.query = query;
    }

    public String getFormat(Object[] formatArgs) {
        return String.format(query, formatArgs);
    }

    public String getQuery() {
        return query;
    }
}
