package com.example.venkatavarun.english2telugu;

/**
 * Created by saisa on 03-10-2016.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import com.example.venkatavarun.english2telugu.Actor.Actor;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess{
    private SQLiteOpenHelper openHelper;

    private static DatabaseAccess instance;
    private Context mContext;
    private static final String DATABASE_NAME = "eng2teldict.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase mDatabase;
    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    public DatabaseAccess(Context context) {

      this.openHelper = new DatabaseOpenHelper(context);


    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {


        this.mDatabase = openHelper.getWritableDatabase();

    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (mDatabase != null) {
            this.mDatabase.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
/*    public List<String> getQuotes() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM boysname", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }*/


    public void openDatabase() {
     //   String dbPath = mContext.getDatabasePath(DATABASE_NAME).getPath();

        this.mDatabase = openHelper.getWritableDatabase();
      //  mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }

    public List<Actor> getQuotes() {
        Actor product = null;
        List<Actor> productList = new ArrayList<>();

        openDatabase();

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM E2Tictionary", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            product = new Actor(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            productList.add(product);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return productList;
    }
}