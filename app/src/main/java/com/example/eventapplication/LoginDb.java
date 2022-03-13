package com.example.eventapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.models.userprofile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginDb extends SQLiteOpenHelper {

    public static final String dbName = "eventapp.db";


    public LoginDb(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(username TEXT primary key , password TEXT,firstname TEXT,lastname TEXT,email TEXT,org TEXT,phone TEXT)");
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

    public ArrayList<userprofile> fetchData(String user){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor usercursor = db.rawQuery("SELECT * FROM users where username = ?",new String[]{user});
        // on below line we are creating a new array list.
        ArrayList<userprofile> userprofileArrayList = new ArrayList<>();
        if(usercursor.getCount()>0){
            if (usercursor.moveToFirst()) {
                do {
                    // on below line we are adding the data from cursor to our array list.
                    userprofileArrayList.add(new userprofile(usercursor.getString(0),
                            usercursor.getString(4),
                            usercursor.getString(6),
                            usercursor.getString(5)));
                } while (usercursor.moveToNext());
                // moving our cursor to next.
            }
        }else
            userprofileArrayList = null;
        // at last closing our cursor
        // and returning our array list.
        usercursor.close();
        return userprofileArrayList;
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
