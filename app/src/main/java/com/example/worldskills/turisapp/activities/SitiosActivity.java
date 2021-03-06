package com.example.worldskills.turisapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.Utils.Util;
import com.example.worldskills.turisapp.fragments.DetailsFragment;
import com.example.worldskills.turisapp.fragments.MapSitios;
import com.example.worldskills.turisapp.fragments.SitosFragment;
import com.example.worldskills.turisapp.models.Sitio;

public class SitiosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,SitosFragment.OnSendSitio {

    FloatingActionButton fab;
    DetailsFragment fragment=new DetailsFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Sitios" );

         fab = (FloatingActionButton) findViewById(R.id.fabSitios);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getSupportFragmentManager().beginTransaction().replace(R.id.content_sitios,new MapSitios()).commit();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState==null && findViewById(R.id.content_sitios)!=null){
            Util.rotacion=Util.PORTRAIT;
            getSupportFragmentManager().beginTransaction().replace(R.id.content_sitios,new SitosFragment()).commit();
        }else {
            Util.rotacion=Util.LAND;
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
            // Handle the camera action
            if (id == R.id.nav_inicio) {
                startActivity(new Intent(this,InicioActivity.class));
            } else if (id == R.id.nav_sitios) {
                startActivity(new Intent(this,SitiosActivity.class));
            } else if (id == R.id.nav_hoteles) {
                startActivity(new Intent(this,HotelesActivity.class));
            } else if (id == R.id.nav_restaurantes) {
                startActivity(new Intent(this,RestaurantesActivity.class));
            }


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void sendSitio(Sitio sitio) {
        fragment= (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.listaDetail);
        if (fragment!=null){
            fragment.cargarSitio(sitio);
        }else {
            fab.hide();
            fragment=new DetailsFragment();
            Bundle bundle=new Bundle();
            bundle.putSerializable("obj",sitio);
            bundle.putInt("type", Util.SITIO);
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.content_sitios,fragment).commit();
        }
    }
}
