package com.com.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018\5\19 0019.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper{

    private Context mContext;

    private final String SEVEN = "create table planeveryday("
            + "id integer primary key autoincrement,"
            + "name text,"
            + "starttime int,"
            + "endtime int"
            + "info text"
            + "record text"
            + "keepday int)";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){

        super(context, name, factory, version);
        mContext = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SEVEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
