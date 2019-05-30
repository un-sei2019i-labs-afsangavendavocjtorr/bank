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

    public static String[] TABLES = {"USERS"};

    public static String[][] FIELDS = {
            {"ID", "EMAIL", "PASSWORD"}
    };

    public static String[][] FIELDS_DATA_TYPES = {
            {"INTEGER PRIMARY KEY AUTOINCREMENT", "VARCHAR(100) UNIQUE NOT NULL", "VARCHAR(100) NOT NULL"}
    };

    public static String[] CREATE_TABLE = {
            "CREATE TABLE %s (%s %s, %s %s, %s %s);"
    };

    public static String[] DROP_TABLE = {
            "DROP TABLE IF EXISTS %s;"
    };

    private static String[] SELECT = {
            "SELECT * FROM %s WHERE %s = %d;",
            "SELECT * FROM %s WHERE %s = '%s';",
            "SELECT * FROM %s;"
    };

    public BankDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public BankDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public static String selectById(int id){
        int userTable = Tables.Users.val();
        String[] userFields = FIELDS[userTable];
        return String.format(
                SELECT[UsersQueries.SelectById.val()],
                TABLES[userTable],
                userFields[UsersFields.Id.val()], id
                );
    }

    public static String selectByEmail(String email){
        int userTable = Tables.Users.val();
        String[] userFields = FIELDS[userTable];
        return String.format(
<<<<<<< HEAD
                SELECT[UsersQueries.SelectByEmil.val()],
                TABLES[userTable],
                userFields[UsersFields.Email.val()], email
=======
                SELECT[UsersQueries.SelectByEmail.val()],
                TABLES[userTable],
                userFields[UsersFields.Email.val()], email
        );
    }

    public static String selectAll(){
        int userTable = Tables.Users.val();
        String[] userFields = FIELDS[userTable];
        return String.format(
                SELECT[UsersQueries.SelectAll.val()],
                TABLES[userTable]
>>>>>>> 77ecc233048f69edf378672e083488cedfcaffa5
        );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        int usersTable = Tables.Users.val();
        String[] fields = FIELDS[usersTable];
        String[] dataTypes = FIELDS_DATA_TYPES[usersTable];
        db.execSQL(String.format(
                CREATE_TABLE[usersTable],
                TABLES[usersTable],
                fields[UsersFields.Id.val()], dataTypes[UsersFields.Id.val()],
<<<<<<< HEAD
                fields[UsersFields.Name.val()], dataTypes[UsersFields.Name.val()],
=======
>>>>>>> 77ecc233048f69edf378672e083488cedfcaffa5
                fields[UsersFields.Email.val()], dataTypes[UsersFields.Email.val()],
                fields[UsersFields.Password.val()], dataTypes[UsersFields.Password.val()]
                )
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        restart(db);
    }

    public boolean restart(SQLiteDatabase db){
        try {
            int usersTable = Tables.Users.val();
            db.execSQL(String.format(DROP_TABLE[usersTable], TABLES[usersTable]));
            onCreate(db);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
