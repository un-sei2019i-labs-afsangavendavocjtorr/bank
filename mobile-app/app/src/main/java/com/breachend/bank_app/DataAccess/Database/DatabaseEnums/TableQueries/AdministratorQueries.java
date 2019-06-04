package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.AdministratorFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public enum AdministratorQueries {
    Create("CREATE TABLE "+ Tables.Administrator.getName() + " (" +
            AdministratorFields.ID.getKey() + " "+AdministratorFields.ID.getDataType() + ", " +
            AdministratorFields.EMAIL.getKey() + " " + AdministratorFields.EMAIL.getDataType() + ", " +
            AdministratorFields.PASSWORD_ADMINISTRATOR.getKey() + " " + AdministratorFields.PASSWORD_ADMINISTRATOR.getDataType() +", "+
            AdministratorFields.CREATED_DATE.getKey()+ " "+AdministratorFields.CREATED_DATE.getDataType()+
            ");"),
    Drop("DROP TABLE IF EXISTS "+ Tables.Administrator.getName() +";"),
    SelectById("SELECT * FROM "+ Tables.Administrator.getName() +" WHERE " + AdministratorFields.ID.getKey() + " = %d;"),
    SelectByEmail("SELECT * FROM "+ Tables.Administrator.getName() +" WHERE " + AdministratorFields.EMAIL.getKey() +" = '%s';"),
    SelectAll("SELECT * FROM "+ Tables.Administrator.getName() +";");

    private String query;

    private AdministratorQueries(String query) {
        this.query = query;
    }

    public String getFormat(Object[] formatArgs) {
        return String.format(query, formatArgs);
    }

    public String getQuery() {
        return query;
    }
}
