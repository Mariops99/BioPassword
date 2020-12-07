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
        Cursor cursor = bd.rawQuery("SELECT rowid, IDENTIFYER, USER, PASSWORD FROM PASSWORD", null);
        ArrayList<Password> passwords = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                passwords.add(new Password(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        return passwords;
    }

    public Password getConcretePassword(int rowID) {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT rowid, IDENTIFYER, USER, PASSWORD FROM PASSWORD WHERE rowid = " + rowID  , null);
        Password password = null;
        if(cursor.moveToFirst()) {
            do {
                password = new Password(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            } while (cursor.moveToNext());
        }
        return password;
    }

    public void updatePassword(int rowID, String nuevo_Identificador, String nuevo_Usuario, String nueva_Contraseña) {
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null) {
            bd.execSQL("UPDATE PASSWORD SET IDENTYFYER =" + nuevo_Identificador + ", USER ="+ nuevo_Usuario + ", PASSWORD =" + nueva_Contraseña + " WHERE rowid =" + rowID);
            bd.close();
        }
    }

    public void deletePassword(){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null) {
            bd.execSQL("DELETE FROM PASSWORD");
            bd.close();
        }
    }

    public void deleteConcretePassword(int rowID) {
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null) {
            bd.execSQL("DELETE FROM PASSWORD WHERE rowid =" + rowID);
            bd.close();
        }
    }
}
