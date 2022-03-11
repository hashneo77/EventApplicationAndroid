package com.example.eventapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class eventDb extends SQLiteOpenHelper {

    public static final String dbName = "eventapp.db";

    public eventDb(Context context) {
        super(context, dbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table events(eventid TEXT primary key , userid TEXT, eventname TEXT,eventdesc TEXT,eventdate TEXT,eventtime TEXT,eventlocation TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists events");
    }
}
