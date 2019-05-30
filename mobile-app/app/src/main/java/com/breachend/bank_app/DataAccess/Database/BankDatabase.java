package com.breachend.bank_app.DataAccess.Database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableFields.UsersFields;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries.UsersQueries;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.Tables;

public class BankDatabase extends SQLiteOpenHelper{

    public static String DATABASE_NAME = "BANK";

    public static int VERSION = 1;



    public BankDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public BankDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public static String selectById(int id){
        Object[] args = {id};
        return UsersQueries.SelectById.getFormat(args);
    }

    public static String selectByEmail(String email){
        Object[] args = {email};
        return UsersQueries.SelectByEmail.getFormat(args);
    }

    public static String selectAll(){
        return UsersQueries.SelectAll.getFormat(null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsersQueries.Create.getQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        restart(db);
    }

    public boolean restart(SQLiteDatabase db){
        try {
            db.execSQL(UsersQueries.Drop.getQuery());
            onCreate(db);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
