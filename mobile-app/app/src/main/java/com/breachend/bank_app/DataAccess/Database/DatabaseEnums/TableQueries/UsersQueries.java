package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.AdministratorFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UsersFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public enum UsersQueries {
    Create("CREATE TABLE "+ Tables.Users.getName() + " (" +
            UsersFields.Id.getKey() + " "+UsersFields.Id.getDataType() + ", " +
            UsersFields.NAME.getKey() + " " + UsersFields.NAME.getDataType() + ", " +
            UsersFields.CREATED_DATE.getKey() + " " + UsersFields.CREATED_DATE.getDataType() +", "+
            UsersFields.STATUS_USER.getKey()+" "+UsersFields.STATUS_USER.getDataType()+", "+
            UsersFields.CREATED_BY.getKey()+" "+UsersFields.CREATED_BY.getDataType()+", "+
            UsersFields.EMAIL.getKey()+" "+UsersFields.EMAIL.getDataType()+
            ");"),
    Drop("DROP TABLE IF EXISTS "+ Tables.Users.getName() +";"),
    SelectById("SELECT * FROM "+ Tables.Users.getName() +" WHERE " + UsersFields.Id.getKey() + " = %d;"),
    SelectByEmail("SELECT * FROM "+ Tables.Users.getName() +" WHERE " + UsersFields.EMAIL.getKey() +" = '%s';"),
    SelectAll("SELECT * FROM "+ Tables.Users.getName() +";"),
    Add_FK_ADMINISTRATOR("ALTER TABLE "+Tables.Users.getName()+" add constraint FK_USER_RELATIONS_ADMINIST foreign key ("+
            UsersFields.CREATED_BY.getKey()+") references "+Tables.Administrator.getName()+
            "("+AdministratorFields.ID.getKey()+");"),
    ;

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
