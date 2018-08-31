package com.example.worldskills.turisapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.turisapp.Utils.Util;
import com.example.worldskills.turisapp.models.Hotel;
import com.example.worldskills.turisapp.models.Restaurante;
import com.example.worldskills.turisapp.models.Sitio;

import java.util.ArrayList;

public class Datos extends SQLiteOpenHelper {
    SQLiteDatabase db;
    Cursor cursor;
    public Datos(Context context) {
        super(context, "B", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Util.sql_sitios);
        db.execSQL(Util.sql_hoteles);
        db.execSQL(Util.sql_restaurantes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Util.TBL_SITIOS);
        db.execSQL("DROP TABLE IF EXISTS "+Util.TBL_HOTELES);
        db.execSQL("DROP TABLE IF EXISTS "+Util.TBL_RESTAURANTES);
        onCreate(db);
    }

    //validar si fueron creadas las tablas
    public boolean validarCreacion(String tabla){
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+tabla,null);
        if (cursor.moveToFirst()){
            return false;
        }else {
            return true;
        }
    }

    //guardar los sitios
    public void guardarSitios(ArrayList<Sitio> sitios){
        db=getWritableDatabase();
      if (validarCreacion(Util.TBL_SITIOS)) {
            for (int i = 0; i < sitios.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(Util.CAMPO_NOMBRE, sitios.get(i).getNombre());
                values.put(Util.CAMPO_DESCRIP_CORTA, sitios.get(i).getDescripcion_corta());
                values.put(Util.CAMPO_UBICACION, sitios.get(i).getUbicacion());
                values.put(Util.CAMPO_DESCRIPCION, sitios.get(i).getDescripcion());
                values.put(Util.CAMPO_LATITUD,sitios.get(i).getLatitud());
                values.put(Util.CAMPO_LONGITUD, sitios.get(i).getLongitud());
                values.put(Util.CAMPO_IMAGEN, sitios.get(i).getImagen());
                db.insert(Util.TBL_SITIOS, null, values);

            }
        }

    }
    //guardar los hoteles

    public void guardarHoteles(ArrayList<Hotel> hotels){
        db=getWritableDatabase();
        if (validarCreacion(Util.TBL_HOTELES)) {
            for (int i = 0; i < hotels.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(Util.CAMPO_NOMBRE, hotels.get(i).getNombre());
                values.put(Util.CAMPO_DESCRIP_CORTA, hotels.get(i).getDescripcion_corta());
                values.put(Util.CAMPO_UBICACION, hotels.get(i).getUbicacion());
                values.put(Util.CAMPO_DESCRIPCION, hotels.get(i).getDescripcion());
                values.put(Util.CAMPO_LATITUD, hotels.get(i).getLatitud());
                values.put(Util.CAMPO_LONGITUD, hotels.get(i).getLongitud());
                values.put(Util.CAMPO_IMAGEN, hotels.get(i).getImagen());
                db.insert(Util.TBL_HOTELES, null, values);

            }
        }

    }

    //guardar los restaurantes
    public void guardarRestaurantes(ArrayList<Restaurante> restaurantes){
        db=getWritableDatabase();
        if (validarCreacion(Util.TBL_RESTAURANTES)) {
            for (int i = 0; i < restaurantes.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(Util.CAMPO_NOMBRE, restaurantes.get(i).getNombre());
                values.put(Util.CAMPO_DESCRIP_CORTA, restaurantes.get(i).getDescripcion_corta());
                values.put(Util.CAMPO_UBICACION, restaurantes.get(i).getUbicacion());
                values.put(Util.CAMPO_DESCRIPCION, restaurantes.get(i).getDescripcion());
                values.put(Util.CAMPO_LATITUD, restaurantes.get(i).getLatitud());
                values.put(Util.CAMPO_LONGITUD, restaurantes.get(i).getLongitud());
                values.put(Util.CAMPO_IMAGEN, restaurantes.get(i).getImagen());
                db.insert(Util.TBL_RESTAURANTES, null, values);

            }
        }

    }

    //listar los sitios
    public Cursor listarSitios(){
        db=getReadableDatabase();
        cursor=db.rawQuery("SELECT * FROM "+Util.TBL_SITIOS,null);
        if (cursor.moveToFirst()){
            return  cursor;
        }else {
            return null;
        }

    }

    //lisatar los hoteles
    public Cursor listarHoteles(){
        db=getReadableDatabase();
        cursor=db.rawQuery("SELECT * FROM "+Util.TBL_HOTELES,null);
        if (cursor.moveToFirst()){
            return  cursor;
        }else {
            return null;
        }

    }

    //listar los restaurantes
    public Cursor listarRestaurantes(){
        db=getReadableDatabase();
        cursor=db.rawQuery("SELECT * FROM "+Util.TBL_RESTAURANTES,null);
        if (cursor.moveToFirst()){
            return  cursor;
        }else {
            return null;
        }

    }

}
