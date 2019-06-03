package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UserPasswordFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UsersFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public enum UserPasswordQueries {
    Create("CREATE TABLE "+ Tables.User_Password.getName() + " (" +
            UserPasswordFields.ID.getKey() + " "+ UserPasswordFields.ID.getDataType() + ", " +
            UserPasswordFields.ID_USER.getKey() + " " + UserPasswordFields.ID_USER.getDataType() + ", " +
            UserPasswordFields.PASSWORD_USER.getKey() + " " + UserPasswordFields.PASSWORD_USER.getDataType() +", "+
            UserPasswordFields.STATUS_PASSWORD.getKey()+" "+ UserPasswordFields.STATUS_PASSWORD.getDataType()+", "+
            UserPasswordFields.CREATED_DATE.getKey()+" "+ UserPasswordFields.CREATED_DATE.getDataType()+
                       ");"),
    Drop("DROP TABLE IF EXISTS "+ Tables.User_Password.getName() +";"),
    SelectById("SELECT * FROM "+ Tables.User_Password.getName() +" WHERE " + UserPasswordFields.ID.getKey() + " = %d;"),

    SelectAll("SELECT * FROM "+ Tables.User_Password.getName() +";"),
    Add_FK_USERS("ALTER TABLE "+Tables.User_Password.getName()+" add constraint FK_USER_PAS_RELATIONS_USER foreign key ("+
            UserPasswordFields.ID_USER.getKey()+") references "+Tables.Users.getName()+
            "("+UsersFields.Id.getKey()+");"),
    DROP_FK_USERS("ALTER TABLE "+Tables.User_Password.getName()+" DROP constraint FK_USER_PAS_RELATIONS_USER ;")
    ;

    private String query;

    UserPasswordQueries(String query) {
        this.query = query;
    }

    public String getFormat(Object[] formatArgs) {
        return String.format(query, formatArgs);
    }

    public String getQuery() {
        return query;
    }

}
