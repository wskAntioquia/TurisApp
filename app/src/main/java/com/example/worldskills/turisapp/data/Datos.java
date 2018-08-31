package com.example.worldskills.turisapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.turisapp.Utils.Util;

public class Datos extends SQLiteOpenHelper {
    public Datos(Context context) {
        super(context, "turisApp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Util.sql_sitios);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public
}
