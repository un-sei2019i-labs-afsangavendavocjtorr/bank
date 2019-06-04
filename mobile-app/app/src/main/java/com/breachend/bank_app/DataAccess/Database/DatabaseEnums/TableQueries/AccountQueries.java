package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.AccountFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UsersFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public enum AccountQueries {
    Create("CREATE TABLE "+Tables.AccountData.getName() +"("+
            AccountFields.AC_CODE.getKey()+" "+ AccountFields.AC_CODE.getDataType()+","+
            AccountFields.BALANCE.getKey()+" "+AccountFields.BALANCE.getDataType()+","+
            AccountFields.ID_USER.getKey()+" "+AccountFields.ID_USER.getDataType()+" );"
    ),
    Drop("DROP TABLE IF EXISTS "+ Tables.AccountData.getName() +";"),
    SelectByIdUser("SELECT * FROM "+Tables.AccountData.getName() +" where "+AccountFields.ID_USER.getKey()+"= %d;"),
    SelectByAC_CODE("SELECT * FROM "+Tables.AccountData.getName()+ "WHERE "+AccountFields.AC_CODE.getKey()+"= %d;"),
    Add_FK_USERS("alter table "+Tables.AccountData.getName()+" add constraint FK_ACCOUNT__RELATIONS_USER foreign key("+
    AccountFields.ID_USER.getKey()+") references "+Tables.Users.getName()+"("+UsersFields.Id.getKey()+");"),
    Drop_FK_USERS("alter table "+Tables.AccountData.getName()+" DROP CONSTRAINT FK_ACCOUNT__RELATIONS_USER;"),
    Update("UPDATE "+Tables.AccountData.getName()+" SET "+AccountFields.AC_CODE.getKey()+"=%d ,"
            +AccountFields.BALANCE.getKey()+"= %f ,"+AccountFields.ID_USER.getKey()+" =%d ;" )
    ;

    private String query;
    private AccountQueries(String query){
        this.query=query;
    }


    public String getFormat(Object []args ){
        return String.format(query,args);
    }
    public String getQuery(){
        return this.query;
    }



}
