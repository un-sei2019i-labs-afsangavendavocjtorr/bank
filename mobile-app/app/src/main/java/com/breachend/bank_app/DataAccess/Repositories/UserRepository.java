package com.breachend.bank_app.DataAccess.Repositories;

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

        /*userValues.put(UsersFields.Email.getKey(), user.getEmail());
        userValues.put(UsersFields.Password.getKey(), user.getPassword());
*/
        userValues.put(UsersFields.NAME.getKey(),user.getName());
        userValues.put(UsersFields.CREATED_DATE.getKey(),user.getCreatedDate().toString());
        //Sobreescribir metodo toString de la fecha para que pueda insertarse en la BD
        userValues.put(UsersFields.STATUS_USER.getKey(),user.getStatusUser());
        userValues.put(UsersFields.CREATED_BY.getKey(),user.getCreatedBy());
        userValues.put(UsersFields.EMAIL.getKey(),user.getEmail());
        database.insert(Tables.Users.getName(), null, userValues);

        return user;
    }

    public UserModel getById(int id){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        Cursor queryResult = database.rawQuery(BankDatabase.selectUserById(id), null);
        if(queryResult.moveToFirst()){
            return new UserModel(
                    queryResult.getInt(UsersFields.Id.getPosition()),
                    queryResult.getString(UsersFields.NAME.getPosition()),
                    queryResult.getString(UsersFields.CREATED_DATE.getPosition()),//contemplar el Si la fecha es retornada
                    //por BD como un String
                    queryResult.getString(UsersFields.STATUS_USER.getPosition()),
                    queryResult.getInt(UsersFields.CREATED_BY.getPosition()),
                    queryResult.getString(UsersFields.EMAIL.getPosition())

                    );
        }
        return null;
    }
    public UserModel getByEmail(String email){
        SQLiteDatabase database = this.bankDatabase.getWritableDatabase();
        Cursor queryResult = database.rawQuery(BankDatabase.selectUserByEmail(email), null);
        if(queryResult.moveToFirst()){
            return new UserModel(
                    queryResult.getInt(UsersFields.Id.getPosition()),
                    queryResult.getString(UsersFields.NAME.getPosition()),
                    queryResult.getString(UsersFields.CREATED_DATE.getPosition()),//contemplar el Si la fecha es retornada
                    //por BD como un String
                    queryResult.getString(UsersFields.STATUS_USER.getPosition()),
                    queryResult.getInt(UsersFields.CREATED_BY.getPosition()),
                    queryResult.getString(UsersFields.EMAIL.getPosition())
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
                    queryResult.getInt(UsersFields.Id.getPosition()),
                    queryResult.getString(UsersFields.NAME.getPosition()),
                    queryResult.getString(UsersFields.CREATED_DATE.getPosition()),//contemplar el Si la fecha es retornada
                    //por BD como un String
                    queryResult.getString(UsersFields.STATUS_USER.getPosition()),
                    queryResult.getInt(UsersFields.CREATED_BY.getPosition()),
                    queryResult.getString(UsersFields.EMAIL.getPosition())
            ));
        }
        return users;
    }
}
