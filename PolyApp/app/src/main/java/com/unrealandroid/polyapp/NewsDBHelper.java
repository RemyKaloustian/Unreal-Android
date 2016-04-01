package com.unrealandroid.polyapp;

import android.content.Context;
import android.database.Cursor;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Kevin on 01/04/2016.
 */
public class NewsDBHelper extends DBHelper {

    public NewsDBHelper(Context context, String DB_NAME) throws SQLException, IOException {
        super(context, DB_NAME);
    }

    public String test(){
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM News", null);
        cursor.moveToFirst();
        return cursor.getString(cursor.getColumnIndex("title"));
    }
}
