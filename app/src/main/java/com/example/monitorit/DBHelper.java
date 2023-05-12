package com.example.monitorit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DBName ="login.db";

    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the 'users' table with 'username' and 'password' columns
        db.execSQL("create table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the 'users' table if it exists during an upgrade
        db.execSQL("drop table if exists users");
    }


    public Boolean insertData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        // Insert the username and password into the 'users' table
        long result= db.insert("users", null,values);
        if(result==-1) {
            return false; // Insert failed
        } else {
            return true; // Insert successful
        }

    }


    public Boolean CheckUsername(String username) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[] {username});

        // Check if the username exists in the 'users' table
        if(cursor.getCount()>0) {
            return true; // Username found
        }else {
            return false; // Username not found
        }
    }

    public Boolean CheckUsernamePassword(String username,String password) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?", new String[] {username, password});

        // Check if the username and password combination exists in the 'users' table
        if(cursor.getCount()>0) {
            return true; // Username and password combination found
        }else {
            return false; // Username and password combination not found
        }
    }


}
