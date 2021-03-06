
package com.example.worldskills.turisapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import com.example.worldskills.turisapp.fragments.RestauranteFragment;
import com.example.worldskills.turisapp.fragments.SitosFragment;
import com.example.worldskills.turisapp.models.Restaurante;

public class RestaurantesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,RestauranteFragment.OnSendRestaurante {

    FloatingActionButton fab;
    DetailsFragment fragment=new DetailsFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Restaurantes" );

        fab = (FloatingActionButton) findViewById(R.id.fabRestaurantes);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState==null && findViewById(R.id.content_restaurantes)!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_restaurantes,new RestauranteFragment()).commit();
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
    public void sendRestaurante(Restaurante restaurante) {
        fragment= (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.listaDetail);
        if (fragment!=null){
            fragment.cargarRestaurante(restaurante);
        }else {
            fab.hide();
            fragment=new DetailsFragment();
            Bundle bundle=new Bundle();
            bundle.putSerializable("obj",restaurante);
            bundle.putInt("type", Util.RESTAURANTE);
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.content_restaurantes,fragment).commit();
        }
    }
}
