package com.example.worldskills.turisapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.turisapp.Utils.Util;
import com.example.worldskills.turisapp.models.Sitio;

import java.util.ArrayList;

public class Datos extends SQLiteOpenHelper {
    SQLiteDatabase db;
    Cursor cursor;
    public Datos(Context context) {
        super(context, "TurisApp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Util.sql_sitios);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean validarCreacion(String tabla){
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+tabla,null);
        if (cursor.moveToFirst()){
            return false;
        }else {
            return true;
        }
    }

    public boolean guardarSitios(ArrayList<Sitio> sitios){
        db=getWritableDatabase();
        /*if (validarCreacion(Util.TBL_SITIOS)) {*/
            for (int i = 0; i < sitios.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(Util.CAMPO_NOMBRE, sitios.get(i).getNombre());
                values.put(Util.CAMPO_DESCRIP_CORTA, sitios.get(i).getDescripcion_corta());
                values.put(Util.CAMPO_UBICACION, sitios.get(i).getUbicacion());
                values.put(Util.CAMPO_DESCRIPCION, sitios.get(i).getDescripcion());
                values.put(Util.CAMPO_LATITUD, sitios.get(i).getLatitud());
                values.put(Util.CAMPO_LONGITUD, sitios.get(i).getLongitud());
                values.put(Util.CAMPO_IMAGEN, sitios.get(i).getImagen());
                db.insert(Util.TBL_SITIOS, null, values);

            }
        //}
        return false;
    }

    public ArrayList<Sitio> listarSitios(){
        db=getReadableDatabase();
        ArrayList<Sitio>sitios=new ArrayList<>();
        cursor=db.rawQuery("SELECT * FROM "+Util.TBL_SITIOS,null);
            do {
                Sitio sitio=new Sitio();
                sitio.setNombre(cursor.getString(cursor.getColumnIndex(Util.CAMPO_NOMBRE)));
                sitio.setDescripcion_corta(cursor.getString(cursor.getColumnIndex(Util.CAMPO_DESCRIP_CORTA)));
                sitio.setUbicacion(cursor.getString(cursor.getColumnIndex(Util.CAMPO_UBICACION)));
                sitio.setDescripcion(cursor.getString(cursor.getColumnIndex(Util.CAMPO_DESCRIPCION)));
                sitio.setLatitud(cursor.getString(cursor.getColumnIndex(Util.CAMPO_LATITUD)));
                sitio.setLongitud(cursor.getString(cursor.getColumnIndex(Util.CAMPO_LONGITUD)));
                sitio.setImagen(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Util.CAMPO_IMAGEN))));
                sitios.add(sitio);
            }while (cursor.moveToNext());
        return sitios;
    }
}
