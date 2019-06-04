package com.breachend.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.breachend.bank_app.DataAccess.Database.BankDatabase;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UserPasswordFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UsersFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;
import com.breachend.bank_app.DataAccess.Models.PasswordModel;
import com.breachend.bank_app.DataAccess.Models.UserModel;

public class PasswordRepository {

    private BankDatabase bankDatabase;

    public PasswordRepository(Context context) {
        this.bankDatabase = new BankDatabase(context);
    }


    public PasswordModel create(PasswordModel password){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        ContentValues passwordValues = new ContentValues();

        passwordValues.put(UserPasswordFields.ID_USER.getKey(), password.getIdUser());
        passwordValues.put(UserPasswordFields.PASSWORD_USER.getKey(), password.getPasswordUser());
        passwordValues.put(UserPasswordFields.STATUS_PASSWORD.getKey(), password.getStatusPassword());
        passwordValues.put(UserPasswordFields.CREATED_DATE.getKey(), password.getCreatedDate());
        database.insert(Tables.UserPassword.getName(), null, passwordValues);

        return password;
    }


    public PasswordModel getByIdUser(int idUser){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        Cursor queryResult = database.rawQuery(BankDatabase.selectPasswordByIdUder(idUser), null);

        if(queryResult.moveToFirst()){
            return new PasswordModel(
                    queryResult.getInt(UserPasswordFields.ID.getPosition()),
                    queryResult.getInt(UserPasswordFields.ID_USER.getPosition()),
                    queryResult.getString(UserPasswordFields.PASSWORD_USER.getPosition()),
                    queryResult.getString(UserPasswordFields.STATUS_PASSWORD.getPosition()), //contemplar el Si la fecha es retornada
                    //por BD como un String
                    queryResult.getString(UserPasswordFields.CREATED_DATE.getPosition())
            );
        }
        return null;
    }
}
