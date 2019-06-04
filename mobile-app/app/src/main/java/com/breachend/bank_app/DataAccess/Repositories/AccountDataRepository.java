package com.breachend.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.breachend.bank_app.DataAccess.Database.BankDatabase;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.AccountFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;
import com.breachend.bank_app.DataAccess.Models.AccountDataModel;

public class AccountDataRepository {
    private BankDatabase bankDatabase;

    public AccountDataRepository(Context context) {
        this.bankDatabase = new BankDatabase(context);
    }
    public AccountDataModel create(AccountDataModel account){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        ContentValues AccountDataValues = new ContentValues();
        AccountDataValues.put(AccountFields.BALANCE.getKey(),account.getBalance());
        AccountDataValues.put(AccountFields.ID_USER.getKey(),account.getId_user());

        database.insert(Tables.AccountData.getName(), null, AccountDataValues);

        return account;
    }

    public AccountDataModel getByIdUser(int id){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        Cursor queryResult = database.rawQuery(BankDatabase.selectAccountbyIdUser(id), null);
        if(queryResult.moveToFirst()){
            return new AccountDataModel(
                    queryResult.getInt(AccountFields.AC_CODE.getPosition()),
                    queryResult.getDouble(AccountFields.BALANCE.getPosition()),
                    queryResult.getInt(AccountFields.ID_USER.getPosition())
            );
        }
        return null;
    }

    public AccountDataModel UpdateAccount(AccountDataModel account){
      try{
          SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
          ContentValues AccountDataValues =new ContentValues();
          AccountDataValues.put(AccountFields.AC_CODE.getKey(),account.getAcCode());
          AccountDataValues.put(AccountFields.BALANCE.getKey(),account.getBalance());
          AccountDataValues.put(AccountFields.ID_USER.getKey(),account.getId_user());
          database.update(Tables.AccountData.getName(),AccountDataValues,AccountFields.AC_CODE.getKey()+"="+account.getAcCode(),null);
          return account;
      }catch (Exception e){
          return null;
      }


    }
}
