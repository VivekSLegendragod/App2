package com.example.viveks.fifapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "fixture.db";
    public static final String TABLE_NAME = "schedule";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "team1";
    public static final String COL_2 = "team2";
    public static final String COL_3 = "date";
    public static final String COL_4 = "time";
    public static final String COL_5 = "venue";


    public DatabaseHelper(MainActivity context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public DatabaseHelper(ExampleDialog exampleDialog, Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " +  TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TEAM1 TEXT, TEAM2 TEXT, DATE TEXT, TIME TEXT, VENUE TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String team1, String team2, String date, String time, String venue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,team1);
        contentValues.put(COL_2,team2);
        contentValues.put(COL_3,date);
        contentValues.put(COL_4,time);
        contentValues.put(COL_5,venue);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else
            return true;

    }

    public boolean updateData(String id, String team1, String team2, String date, String time, String venue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0,id);
        contentValues.put(COL_1,team1);
        contentValues.put(COL_2,team2);
        contentValues.put(COL_3,date);
        contentValues.put(COL_4,time);
        contentValues.put(COL_5,venue);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
         return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }
}
