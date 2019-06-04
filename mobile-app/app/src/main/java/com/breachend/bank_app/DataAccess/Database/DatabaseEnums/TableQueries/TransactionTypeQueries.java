package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.TransactionTypeFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public enum TransactionTypeQueries {
    Create("CREATE TABLE "+ Tables.TransactionType.getName() + " (" +
            TransactionTypeFields.ID.getKey() + " "+ TransactionTypeFields.ID.getDataType() + ", " +
            TransactionTypeFields.NAME.getKey() + " " + TransactionTypeFields.NAME.getDataType() + ", " +
            TransactionTypeFields.CREATED_DATE.getKey() + " " + TransactionTypeFields.CREATED_DATE.getDataType() +
            ");"),
    Drop("DROP TABLE IF EXISTS "+ Tables.TransactionType.getName() +";"),
    SelectById("SELECT * FROM "+ Tables.TransactionType.getName() +" WHERE " + TransactionTypeFields.ID.getKey() + " = %d;"),
       SelectAll("SELECT * FROM "+ Tables.TransactionType.getName() +";");

    private String query;

   TransactionTypeQueries(String query) {
        this.query = query;
    }

    public String getFormat(Object[] formatArgs) {
        return String.format(query, formatArgs);
    }

    public String getQuery() {
        return query;
    }
}
