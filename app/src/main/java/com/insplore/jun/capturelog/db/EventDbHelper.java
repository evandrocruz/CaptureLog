package com.insplore.jun.capturelog.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EventDbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String TIMESTAMP_TYPE = " TIMESTAMP";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EventContract.TABLE_NAME + " (" +
                    EventContract.EventEntry._ID + " INTEGER PRIMARY KEY," +
                    EventContract.EventEntry.SESSION + TEXT_TYPE + COMMA_SEP +
                    EventContract.EventEntry.CATEGORY + TEXT_TYPE + COMMA_SEP +
                    EventContract.EventEntry.EVENT_TIME + TIMESTAMP_TYPE + COMMA_SEP +
                    EventContract.EventEntry.EVENT_TEXT + TEXT_TYPE + COMMA_SEP +
            " )";


    public EventDbHelper(Context context){
        super(context, EventContract.DB_NAME, null, EventContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
