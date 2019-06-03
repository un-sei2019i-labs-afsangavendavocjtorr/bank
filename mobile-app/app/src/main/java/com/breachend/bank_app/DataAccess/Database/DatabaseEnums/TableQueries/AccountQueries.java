package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public enum AccountQueries {
    Create("CREATE TABLE "+Tables.Account_Data+
            " ( AC_CODE bigint identity primary key," +
                  "BALANCE  money null,"+
           " ID_USER  bigint null)"





    );
    private String query;
    private AccountQueries(String query){
        this.query=query;
    }
    public String getQuery(){
        return this.query;
    }


}
