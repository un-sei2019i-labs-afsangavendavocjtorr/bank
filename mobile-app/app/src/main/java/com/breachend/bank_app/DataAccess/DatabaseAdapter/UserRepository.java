package com.breachend.bank_app.DataAccess.DatabaseAdapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.breachend.bank_app.DataAccess.Database.BankDatabase;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UsersFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;
import com.breachend.bank_app.DataAccess.Model.User.UserModel;

public class UserRepository {
    private BankDatabase bankDatabase;

    public UserRepository(Context context) {
        this.bankDatabase = new BankDatabase(context);
    }

    public void create(UserModel user){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        ContentValues userValues = new ContentValues();

        int userTable = Tables.Users.Val();
        String[] userFileds = BankDatabase.FIELDS[userTable];

        userValues.put(userFileds[UsersFields.Name.Val()], user.getName());
        userValues.put(userFileds[UsersFields.Email.Val()], user.getEmail());
        userValues.put(userFileds[UsersFields.Password.Val()], user.getPassword());

        database.insert(BankDatabase.TABLES[userTable], null, userValues);
    }

    public UserModel getById(int id){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        Cursor queryResult = database.rawQuery(BankDatabase.selectById(id), null);
        if(queryResult.moveToFirst()){
            return new UserModel(
                    queryResult.getInt(UsersFields.Id.Val()),
                    queryResult.getString(UsersFields.Name.Val()),
                    queryResult.getString(UsersFields.Email.Val()),
                    queryResult.getString(UsersFields.Password.Val())
                    );
        }
        return null;
    }
    public UserModel getByEmail(String email){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        Cursor queryResult = database.rawQuery(BankDatabase.selectByEmail(email), null);
        if(queryResult.moveToFirst()){
            return new UserModel(
                    queryResult.getInt(UsersFields.Id.Val()),
                    queryResult.getString(UsersFields.Name.Val()),
                    queryResult.getString(UsersFields.Email.Val()),
                    queryResult.getString(UsersFields.Password.Val())
            );
        }
        return null;
    }
}
