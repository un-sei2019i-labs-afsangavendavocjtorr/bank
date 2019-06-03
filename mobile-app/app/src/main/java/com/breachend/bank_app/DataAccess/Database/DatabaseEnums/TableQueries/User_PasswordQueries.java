package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.User_PasswordFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UsersFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public enum User_PasswordQueries {
    Create("CREATE TABLE "+ Tables.User_Password.getName() + " (" +
            User_PasswordFields.ID.getKey() + " "+User_PasswordFields.ID.getDataType() + ", " +
            User_PasswordFields.ID_USER.getKey() + " " + User_PasswordFields.ID_USER.getDataType() + ", " +
            User_PasswordFields.PASSWORD_USER.getKey() + " " + User_PasswordFields.PASSWORD_USER.getDataType() +", "+
            User_PasswordFields.STATUS_PASSWORD.getKey()+" "+User_PasswordFields.STATUS_PASSWORD.getDataType()+", "+
            User_PasswordFields.CREATED_DATE.getKey()+" "+User_PasswordFields.CREATED_DATE.getDataType()+
                       ");"),
    Drop("DROP TABLE IF EXISTS "+ Tables.User_Password.getName() +";"),
    SelectById("SELECT * FROM "+ Tables.User_Password.getName() +" WHERE " + User_PasswordFields.ID.getKey() + " = %d;"),

    SelectAll("SELECT * FROM "+ Tables.User_Password.getName() +";"),
    Add_FK_USERS("ALTER TABLE "+Tables.User_Password.getName()+" add constraint FK_USER_PAS_RELATIONS_USER foreign key ("+
            User_PasswordFields.ID_USER.getKey()+") references "+Tables.Users.getName()+
            "("+UsersFields.Id.getKey()+");"),
    DROP_FK_USERS("ALTER TABLE "+Tables.User_Password.getName()+" DROP constraint FK_USER_PAS_RELATIONS_USER ;")
    ;

    private String query;

    User_PasswordQueries(String query) {
        this.query = query;
    }

    public String getFormat(Object[] formatArgs) {
        return String.format(query, formatArgs);
    }

    public String getQuery() {
        return query;
    }

}
