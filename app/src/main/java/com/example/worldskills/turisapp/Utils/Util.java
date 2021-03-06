package com.example.worldskills.turisapp.Utils;

import android.provider.BaseColumns;
import android.view.MenuItem;

public class Util implements BaseColumns {

    public final static String TBL_SITIOS="sitios";
    public final static String TBL_HOTELES="hoteles";
    public final static String TBL_RESTAURANTES="restaurantes";

    public final static String CAMPO_NOMBRE="nombre";
    public final static String CAMPO_DESCRIP_CORTA="descrip_corta";
    public final static String CAMPO_UBICACION="ubicacion";
    public final static String CAMPO_DESCRIPCION="descripsion";
    public final static String CAMPO_LATITUD="latitud";
    public final static String CAMPO_LONGITUD="longitud";
    public final static String CAMPO_IMAGEN="imagen";

    public final static int SITIO=0;
    public final static int HOTEL=1;
    public final static int RESTAURANTE=2;

    public final static int GRID=0;
    public final static int LIST=1;
    public static int visualizacion=0;
    public static int rotacion=0;

    public final static int PORTRAIT=0;
    public final static int LAND=1;

    public static MenuItem listItem=null;
    public static MenuItem gridItem=null;

    //crear la tabla sitios
    public static String sql_sitios="CREATE TABLE "+ Util.TBL_SITIOS +"("+
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            CAMPO_NOMBRE+ " TEXT,"+
            CAMPO_DESCRIP_CORTA+ " TEXT,"+
            CAMPO_UBICACION+ " TEXT,"+
            CAMPO_DESCRIPCION+ " TEXT,"+
            CAMPO_LATITUD+ " REAL,"+
            CAMPO_LONGITUD+ " REAL,"+
            CAMPO_IMAGEN+ " INTEGER)";

    //crear la tabla hoteles
    public static String sql_hoteles="CREATE TABLE "+ Util.TBL_HOTELES +"("+
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            CAMPO_NOMBRE+ " TEXT,"+
            CAMPO_DESCRIP_CORTA+ " TEXT,"+
            CAMPO_UBICACION+ " TEXT,"+
            CAMPO_DESCRIPCION+ " TEXT,"+
            CAMPO_LATITUD+ " REAL,"+
            CAMPO_LONGITUD+ " REAL,"+
            CAMPO_IMAGEN+ " INTEGER)";

    //crear la tabla restaurantes
    public static String sql_restaurantes="CREATE TABLE "+ Util.TBL_RESTAURANTES +"("+
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            CAMPO_NOMBRE+ " TEXT,"+
            CAMPO_DESCRIP_CORTA+ " TEXT,"+
            CAMPO_UBICACION+ " TEXT,"+
            CAMPO_DESCRIPCION+ " TEXT,"+
            CAMPO_LATITUD+ " TEXT,"+
            CAMPO_LONGITUD+ " TEXT,"+
            CAMPO_IMAGEN+ " INTEGER)";


}
