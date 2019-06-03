package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.Transaction_TypeFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public enum Transaction_TypeQueries {
    Create("CREATE TABLE "+ Tables.Transaction_Type.getName() + " (" +
            Transaction_TypeFields.ID.getKey() + " "+Transaction_TypeFields.ID.getDataType() + ", " +
            Transaction_TypeFields.NAME.getKey() + " " + Transaction_TypeFields.NAME.getDataType() + ", " +
            Transaction_TypeFields.CREATED_DATE.getKey() + " " + Transaction_TypeFields.CREATED_DATE.getDataType() +
            ");"),
    Drop("DROP TABLE IF EXISTS "+ Tables.Transaction_Type.getName() +";"),
    SelectById("SELECT * FROM "+ Tables.Transaction_Type.getName() +" WHERE " + Transaction_TypeFields.ID.getKey() + " = %d;"),
       SelectAll("SELECT * FROM "+ Tables.Transaction_Type.getName() +";");

    private String query;

   Transaction_TypeQueries(String query) {
        this.query = query;
    }

    public String getFormat(Object[] formatArgs) {
        return String.format(query, formatArgs);
    }

    public String getQuery() {
        return query;
    }
}
