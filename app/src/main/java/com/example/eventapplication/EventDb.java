package com.example.eventapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.models.events;

import java.util.ArrayList;
import java.util.logging.Logger;

public class EventDb extends SQLiteOpenHelper {

    public static final String dbName = "events.db";

    public EventDb(Context context) {
        super(context, dbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table events(eventid INTEGER PRIMARY KEY AUTOINCREMENT , userid TEXT, eventname TEXT,eventdesc TEXT,eventdate TEXT,eventtime TEXT,eventlocation TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists events");
    }

    public Boolean  insertEventData(String userName,String name,String info,String date,String time,String venue){
        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "Insert INTO events(userid,eventname,eventdesc,eventdate,eventime,eventlocation) values("+userName+","+name+","+info+","+date+","+time+","+venue+");";
        ContentValues values = new ContentValues();
        values.put("userid",userName);
        values.put("eventname",name);
        values.put("eventdesc",info);
        values.put("eventdate",date);
        values.put("eventtime",time);
        values.put("eventlocation",venue);
        String tag = "eventdb";
        if(db.insert("events",null,values)!=-1) {
            return true;
        }
        else
            return false;
    }

    public ArrayList readEventsData(String userName){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<events> eventsArrayList = new ArrayList<>();
        Cursor usercursor = db.rawQuery("select * from events where userid = ?",new String[]{userName});
        if(usercursor.getCount()>0){
            if(usercursor.moveToFirst())
            do{
                eventsArrayList.add(new events(usercursor.getInt(0),
                        usercursor.getString(1),
                        usercursor.getString(2),
                        usercursor.getString(3),
                        usercursor.getString(4),
                        usercursor.getString(5),
                        usercursor.getString(6)));
            }while (usercursor.moveToNext());
        }
        return eventsArrayList;
    }
}
