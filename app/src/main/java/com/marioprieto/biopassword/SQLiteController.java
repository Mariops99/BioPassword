package com.marioprieto.biopassword;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteController extends SQLiteOpenHelper {

    private static final String NOMBRE_DB="psswdbiosecurity.bd";
    private static final int VERSION_DB = 1;
    private static final  String TABLA_PASSWD = "CREATE TABLE PASSWORD(IDENTIFYER TEXT, USER TEXT, PASSWORD TEXT)";

    public SQLiteController(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_PASSWD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PASSWORD");
        onCreate(db);
    }

    public void addPassword(String identifyer, String user, String password) {
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null) {
            bd.execSQL("INSERT INTO PASSWORD (IDENTIFYER, USER, PASSWORD) VALUES ('"+ identifyer + "', '" + user + "', '" + password + "')");
            bd.close();
        }
    }

    public ArrayList<Password> getPassword() {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT IDENTIFYER, USER, PASSWORD FROM PASSWORD", null);
        ArrayList<Password> passwords = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                passwords.add(new Password(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        return passwords;
    }
}
