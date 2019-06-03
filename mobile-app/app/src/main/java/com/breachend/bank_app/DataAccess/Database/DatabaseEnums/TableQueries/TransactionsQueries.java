package com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.AccountFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.AdministratorFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.TransactionTypeFields;
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
    SelectAll("SELECT * FROM "+ Tables.Transactions.getName() +";"),
    Add_FK_RECEIVER_ACCOUNT_DATA("alter table "+Tables.Transactions.getName()+" add constraint FK_TRANSACT_RELATIONS_ACCOUNT_ foreign key ("+
    TransactionsFields.RECEIVER.getKey()+") references "+Tables.AccountData.getName()+"("+AccountFields.AC_CODE.getKey()+");"),
    Add_FK_TRANSMITTER_ADMIN_ACCOUNT_DATA("alter table "+Tables.Transactions.getName()+" add constraint FK_TRANSACT_RELATIONS_ADMINIST foreign key ("+
            TransactionsFields.TRANSMITTER_ADMIN.getKey()+") references "+Tables.Administrator.getName()+"("+AdministratorFields.ID.getKey()+");"),
    Add_FK_TRANSMITTER_ACCOUNT_ACCOUNT_DATA("alter table "+Tables.Transactions.getName()+" add constraint FK_TRANSMITTER_ACCOUNT_ACCOUNT_DATA foreign key ("+
            TransactionsFields.TRANSMITTER_ACCOUNT.getKey()+") references "+Tables.AccountData.getName()+"("+AccountFields.AC_CODE.getKey()+");"),
    Add_CHECK_ACCOUNT_OR_ADMIN("alter table "+Tables.Transactions.getName()+" add constraint CHECKING_ADMIN_OR_OTHER_ACCOUNT CHECK (("+
            TransactionsFields.TRANSMITTER_ACCOUNT.getKey()+" IS NOT NULL AND "+TransactionsFields.TRANSMITTER_ADMIN.getKey()+" IS NULL)OR("+
            TransactionsFields.TRANSMITTER_ACCOUNT.getKey()+" IS NULL AND "+TransactionsFields.TRANSMITTER_ADMIN.getKey()+" IS NOT NULL ));"),
    Add_FK_TRANSACTION_TYPE("alter table "+Tables.Transactions.getName()+" add constraint FK_TRANSACT_RELATIONS_TRANSACT foreign key ("+
            TransactionsFields.TYPE_TRANSACTION.getKey()+") references "+Tables.TransactionType.getName()+"("+ TransactionTypeFields.ID.getKey()+");"),
    Drop_FK_RECEIVER_ACCOUNT_DATA("alter table "+Tables.Transactions.getName()+" DROP CONSTRAINT FK_TRANSACT_RELATIONS_ACCOUNT_ ;"),
    Drop_FK_TRANSMITTER_ADMIN_ACCOUNT_DATA("alter table "+Tables.Transactions.getName()+" DROP CONSTRAINT FK_TRANSACT_RELATIONS_ADMINIST;"),
    Drop_FK_TRANSMITTER_ACCOUNT_ACCOUNT_DATA("alter table "+Tables.Transactions.getName()+" DROP CONSTRAINT FK_TRANSMITTER_ACCOUNT_ACCOUNT_DATA;"),
    Drop_CHECK_ACCOUNT_OR_ADMIN("alter table "+Tables.Transactions.getName()+" DROP constraint CHECKING_ADMIN_OR_OTHER_ACCOUNT ;"),
    Drop_FK_TRANSACTION_TYPE("alter table "+Tables.Transactions.getName()+" DROP constraint FK_TRANSACT_RELATIONS_TRANSACT;")

    ;
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
