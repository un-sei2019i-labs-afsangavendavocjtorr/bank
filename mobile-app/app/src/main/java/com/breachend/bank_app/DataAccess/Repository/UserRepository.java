package com.breachend.bank_app.DataAccess.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.breachend.bank_app.DataAccess.Database.BankDatabase;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UsersFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;
import com.breachend.bank_app.DataAccess.Models.UserModel;

import java.util.ArrayList;

public class UserRepository {
    private BankDatabase bankDatabase;

    public UserRepository(Context context) {
        this.bankDatabase = new BankDatabase(context);
    }

    public UserModel create(UserModel user){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        ContentValues userValues = new ContentValues();

        int userTable = Tables.Users.val();
        String[] userFileds = BankDatabase.FIELDS[userTable];

        userValues.put(userFileds[UsersFields.Email.val()], user.getEmail());
        userValues.put(userFileds[UsersFields.Password.val()], user.getPassword());

        database.insert(BankDatabase.TABLES[userTable], null, userValues);

        return user;
    }

    public UserModel getById(int id){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        Cursor queryResult = database.rawQuery(BankDatabase.selectById(id), null);
        if(queryResult.moveToFirst()){
            return new UserModel(
                    queryResult.getInt(UsersFields.Id.val()),
                    queryResult.getString(UsersFields.Email.val()),
                    queryResult.getString(UsersFields.Password.val())
                    );
        }
        return null;
    }
    public UserModel getByEmail(String email){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        Cursor queryResult = database.rawQuery(BankDatabase.selectByEmail(email), null);
        if(queryResult.moveToFirst()){
            return new UserModel(
                    queryResult.getInt(UsersFields.Id.val()),
                    queryResult.getString(UsersFields.Email.val()),
                    queryResult.getString(UsersFields.Password.val())
            );
        }
        return null;
    }
    public ArrayList<UserModel> getAll(){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        Cursor queryResult = database.rawQuery(BankDatabase.selectAll(), null);
        ArrayList<UserModel> users = new ArrayList<>();
        while(queryResult.moveToNext()){
            users.add( new UserModel(
                    queryResult.getInt(UsersFields.Id.val()),
                    queryResult.getString(UsersFields.Email.val()),
                    queryResult.getString(UsersFields.Password.val())
            ));
        }
        return users;
    }
}
