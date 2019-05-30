package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UsersFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public enum UsersQueries {
    Create("CREATE TABLE "+ Tables.Users.getName() + " (" +
            UsersFields.Id.getKey() + " "+UsersFields.Id.getDataType() + ", " +
            UsersFields.Email.getKey() + " " + UsersFields.Email.getDataType() + ", " +
            UsersFields.Password.getKey() + " " + UsersFields.Password.getDataType() +
            ");"),
    Drop("DROP TABLE IF EXISTS "+ Tables.Users.getName() +";"),
    SelectById("SELECT * FROM "+ Tables.Users.getName() +" WHERE " + UsersFields.Id.getKey() + " = %d;"),
    SelectByEmail("SELECT * FROM "+ Tables.Users.getName() +" WHERE " + UsersFields.Email.getKey() +" = '%s';"),
    SelectAll("SELECT * FROM "+ Tables.Users.getName() +";");

    private String query;

    UsersQueries(String query) {
        this.query = query;
    }

    public String getFormat(Object[] formatArgs) {
        return String.format(query, formatArgs);
    }

    public String getQuery() {
        return query;
    }
}
