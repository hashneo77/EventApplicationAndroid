package com.example.eventapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LoginDb extends SQLiteOpenHelper {

    public static final String dbName = "eventapp.db";


    public LoginDb(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table  users(username TEXT primary key , password TEXT,firstname TEXT,lastname TEXT,email TEXT,org TEXT,phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
    }

    public Boolean insertData(String username, String password, String firstname, String lastname,String email,String phone,String org){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("firstname",firstname);
        values.put("lastname",lastname);
        values.put("email",email);
        values.put("org",org);
        values.put("phone",phone);

        long result = db.insert("users",null,values);
        return result != -1;

    }

    public Boolean checkUsername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[]{username});
        if(cursor.getCount()>0){
            cursor.close();
            return  true;
        }
        else
            cursor.close();
            return false;
    }

    public Boolean checkUsernameAndPassword(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?", new String[]{username,password});
        return cursor.getCount() > 0;
    }

}
