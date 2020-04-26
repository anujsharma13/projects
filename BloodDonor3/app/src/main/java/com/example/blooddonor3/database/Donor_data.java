package com.example.blooddonor3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Donor_data extends SQLiteOpenHelper {
    public Donor_data(@Nullable Context context) {
        super(context,"donors.db",null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table donordata(namee Text,age Text,gender Text,bloodgroup Text,phno Text,city Text,state Text,country Text,message Text,datee Text)";
    sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Boolean adddata(String name,String age,String gender,String blood,String phno,String city,String state,String country,String message,String datee)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("namee",name);
        contentValues.put("age",age);
        contentValues.put("gender",gender);
        contentValues.put("bloodgroup",blood);
        contentValues.put("phno",phno);
        contentValues.put("city",city);
        contentValues.put("state",state);
        contentValues.put("country",country);
        contentValues.put("message",message);
        contentValues.put("datee",datee);

        long l=sqLiteDatabase.insert("donordata",null,contentValues);
    if(l==-1)
        return false;
    else
        return true;
    }
    public Cursor fetchdata()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
       Cursor c= sqLiteDatabase.rawQuery("select * from donordata",null);
        return c;
    }
}
