package com.example.venkatavarun.english2telugu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "eng2teldict.db";
    private static final int DATABASE_VERSION = 2;
    private SQLiteOpenHelper mOpenHelper;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



}
