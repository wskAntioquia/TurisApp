package com.example.worldskills.turisapp.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.data.Datos;
import com.example.worldskills.turisapp.models.Sitio;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    private Datos datos;
    private ArrayList<Sitio> sitios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        datos=new Datos(this);
        ingresarSitios();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),InicioActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        },2000);
    }

    private void ingresarSitios() {

        try {
            sitios=new ArrayList<Sitio>(){{
                add(new Sitio("Cerro de Monserrate",getString(R.string.moncerrate_corta),"Carrera 2 E No. 21-48 | Paseo Bolívar, Bogota, Colombia",getString(R.string.moncerrate_larga),"4.6056941","-74.0642803",R.drawable.s_monserrate));
                add(new Sitio("Parque Metropolitano Simon Bolivar",getString(R.string.metropolitano_corta),"Av. Calle 53 y Av. Esmeralda s/n, Bogotá, Cundinamarca",getString(R.string.metropolitano_larga),"4.6482361","-74.3009552",R.drawable.s_simonbolivar));
                add(new Sitio("Plaza de Bolivar",getString(R.string.bolivar_corta),"Cra. 7 #11-10, Bogotá",getString(R.string.bolivar_larga),"4.5981259","4.5981259",R.drawable.s_plazadebolivar));
                add(new Sitio("Centro Comercial Andino",getString(R.string.adino_corta),"Cra. 11 #82-71, Bogotá, Cundinamarca",getString(R.string.adino_larga),"4.6667313","-74.0553429",R.drawable.s_andino));
                add(new Sitio("Centro Comercial Centro Mayor",getString(R.string.mayor_corta),"Calle 38 A #Sur No. 34D-51, Bogotá",getString(R.string.mayor_larga),"4.5926585","-74.1263605",R.drawable.s_centromayor));
            }};
            datos.guardarSitios(sitios);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
