package com.example.hostelmaniaa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HostelDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "HostelManiaa.db";
    private static final int DATABASE_VERSION = 1;

    public HostelDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "usn TEXT NOT NULL, " +
                "dob TEXT NOT NULL, " +
                "room_no TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }
}
