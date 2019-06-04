package com.breachend.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.breachend.bank_app.DataAccess.Database.BankDatabase;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.TransactionsFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UsersFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;
import com.breachend.bank_app.DataAccess.Models.TransactionModel;
import com.breachend.bank_app.DataAccess.Models.UserModel;

public class TransactionRepository {

    private BankDatabase bankDatabase;

    public TransactionRepository(Context context) {
        this.bankDatabase = new BankDatabase(context);
    }

    public TransactionModel create(TransactionModel transaction){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        ContentValues transactionValues = new ContentValues();


        transactionValues.put(TransactionsFields.TYPE_TRANSACTION.getKey(), transaction.getTypeTransaction());
        transactionValues.put(TransactionsFields.RECEIVER.getKey(), transaction.getReceiver());
        transactionValues.put(TransactionsFields.TRANSMITTER_ACCOUNT.getKey(), transaction.getTransmitterAccount());
        transactionValues.put(TransactionsFields.TRANSMITTER_ADMIN.getKey(), transaction.getTransmitterAdmin());
        transactionValues.put(TransactionsFields.DATE_TRANSACTION.getKey(), transaction.getDateTransaction());
        transactionValues.put(TransactionsFields.STATUS_TRANSACTION.getKey(), transaction.getStatusTransaction());
        transactionValues.put(TransactionsFields.AMOUNT.getKey(), transaction.getAmount());

        database.insert(Tables.Transactions.getName(), null, transactionValues);

        return transaction;
    }
}
