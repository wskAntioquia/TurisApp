package com.example.worldskills.turisapp.Utils;

import android.provider.BaseColumns;

public class Util implements BaseColumns {

    public final static String TBL_SITIOS="sitios";
    public final static String CAMPO_NOMBRE="nombre";
    public final static String CAMPO_DESCRIP_CORTA="descrip_corta";
    public final static String CAMPO_UBICACION="ubicacion";
    public final static String CAMPO_DESCRIPCION="descripsion";
    public final static String CAMPO_LATITUD="latitud";
    public final static String CAMPO_LONGITUD="longitud";
    public final static String CAMPO_IMAGEN="imagen";

    public static String sql_sitios="CREATE TABLE "+ Util.TBL_SITIOS +"("+
            CAMPO_NOMBRE+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            CAMPO_NOMBRE+ " TEXT,"+
            CAMPO_DESCRIP_CORTA+ " TEXT,"+
            CAMPO_UBICACION+ " TEXT,"+
            CAMPO_DESCRIPCION+ " TEXT,"+
            CAMPO_LATITUD+ " TEXT,"+
            CAMPO_LONGITUD+ " TEXT,"+
            CAMPO_IMAGEN+ " INTEGER)";

}
