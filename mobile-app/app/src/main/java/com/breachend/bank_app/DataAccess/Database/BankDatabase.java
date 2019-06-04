package com.breachend.bank_app.DataAccess.Database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries.AccountQueries;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries.AdministratorQueries;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries.TransactionTypeQueries;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries.TransactionsQueries;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries.UserPasswordQueries;
import com.breachend.bank_app.DataAccess.Database.DatabaseEnums.TableQueries.UsersQueries;

public class BankDatabase extends SQLiteOpenHelper{

    public static String DATABASE_NAME = "BANK";

    public static int VERSION = 1;



    public BankDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public BankDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public static String selectUserById(int id){
        Object[] args = {id};
        return UsersQueries.SelectById.getFormat(args);
    }

    public static String selectUserByEmail(String email){
        Object[] args = {email};
        return UsersQueries.SelectByEmail.getFormat(args);
    }

    public static String selectAll(){
        return UsersQueries.SelectAll.getFormat(null);
    }


    public static String selectPasswordByIdUder(int idUser){
        Object[] args = {idUser};
        return UserPasswordQueries.SelectByIdUser.getFormat(args);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AccountQueries.Create.getQuery());
        db.execSQL(AdministratorQueries.Create.getQuery());
        db.execSQL(TransactionsQueries.Create.getQuery());
        db.execSQL(TransactionTypeQueries.Create.getQuery());
        db.execSQL(UsersQueries.Create.getQuery());
        db.execSQL(UserPasswordQueries.Create.getQuery());

        /*
        db.execSQL(AccountQueries.Add_FK_USERS.getQuery());
        db.execSQL(TransactionsQueries.Add_FK_RECEIVER_ACCOUNT_DATA.getQuery());
        db.execSQL(TransactionsQueries.Add_FK_TRANSMITTER_ADMIN_ACCOUNT_DATA.getQuery());
        db.execSQL(TransactionsQueries.Add_FK_TRANSMITTER_ACCOUNT_ACCOUNT_DATA.getQuery());
        db.execSQL(TransactionsQueries.Add_CHECK_ACCOUNT_OR_ADMIN.getQuery());
        db.execSQL(TransactionsQueries.Add_FK_TRANSACTION_TYPE.getQuery());
        db.execSQL(UsersQueries.Add_FK_ADMINISTRATOR.getQuery());
        db.execSQL(UserPasswordQueries.Add_FK_USERS.getQuery());
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        restart(db);
    }

    public boolean restart(SQLiteDatabase db){
        try {
            db.execSQL(AccountQueries.Drop_FK_USERS.getQuery());
            db.execSQL(TransactionsQueries.Drop_FK_RECEIVER_ACCOUNT_DATA.getQuery());
            db.execSQL(TransactionsQueries.Drop_FK_TRANSMITTER_ADMIN_ACCOUNT_DATA.getQuery());
            db.execSQL(TransactionsQueries.Drop_FK_TRANSMITTER_ACCOUNT_ACCOUNT_DATA.getQuery());
            db.execSQL(TransactionsQueries.Drop_CHECK_ACCOUNT_OR_ADMIN.getQuery());
            db.execSQL(TransactionsQueries.Drop_FK_TRANSACTION_TYPE.getQuery());
            db.execSQL(UsersQueries.Drop_FK_ADMINISTRATOR.getQuery());
            db.execSQL(UserPasswordQueries.DROP_FK_USERS.getQuery());
            db.execSQL(AccountQueries.Drop.getQuery());
            db.execSQL(AdministratorQueries.Drop.getQuery());
            db.execSQL(TransactionsQueries.Drop.getQuery());
            db.execSQL(TransactionTypeQueries.Drop.getQuery());
            db.execSQL(UsersQueries.Drop.getQuery());
            db.execSQL(UserPasswordQueries.Drop.getQuery());

            onCreate(db);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    public static String selectAccountbyIdUser(int id){
        Object []args={id};
       return AccountQueries.SelectByIdUser.getFormat(args);

    }
}
