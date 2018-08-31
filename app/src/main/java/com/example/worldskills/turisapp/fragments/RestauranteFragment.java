package com.example.worldskills.turisapp.fragments;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.Utils.Util;
import com.example.worldskills.turisapp.adapters.RestaurantesAdapter;
import com.example.worldskills.turisapp.data.Datos;
import com.example.worldskills.turisapp.models.Restaurante;

import java.util.ArrayList;


public class RestauranteFragment extends Fragment implements RestaurantesAdapter.OnItemClickListener{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RestaurantesAdapter adapter;
    public static ArrayList<Restaurante> restaurantes;
    private Datos datos;
    private Restaurante restaurante;
    private OnSendRestaurante mListener;

    public RestauranteFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        getActivity().setTitle("Restaurantes");
        datos=new Datos(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_restaurante, container, false);
        recyclerView=view.findViewById(R.id.recyclerRestaurantes);
        manager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        restaurantes=new ArrayList<>();
        restaurantes= listarRestaurantes();
        adapter=new RestaurantesAdapter(R.layout.content_item_list, restaurantes,this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private ArrayList<Restaurante> listarRestaurantes() {
        Cursor cursor=datos.listarRestaurantes();
        do {
            restaurante=new Restaurante();
            restaurante.setNombre(cursor.getString(cursor.getColumnIndex(Util.CAMPO_NOMBRE)));
            restaurante.setDescripcion_corta(cursor.getString(cursor.getColumnIndex(Util.CAMPO_DESCRIP_CORTA)));
            restaurante.setUbicacion(cursor.getString(cursor.getColumnIndex(Util.CAMPO_UBICACION)));
            restaurante.setDescripcion(cursor.getString(cursor.getColumnIndex(Util.CAMPO_DESCRIPCION)));
            restaurante.setLatitud(cursor.getDouble(cursor.getColumnIndex(Util.CAMPO_LATITUD)));
            restaurante.setLongitud(cursor.getDouble(cursor.getColumnIndex(Util.CAMPO_LONGITUD)));
            restaurante.setImagen(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Util.CAMPO_IMAGEN))));
            restaurantes.add(restaurante);
        }while (cursor.moveToNext());
        return restaurantes;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.inicio,menu);
        Util.listItem=menu.findItem(R.id.list);
        Util.gridItem=menu.findItem(R.id.grid);
        cambiarVisualizacion();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.list:
                Util.visualizacion=Util.LIST;
                cambiarVisualizacion();
                break;
            case R.id.grid:
                Util.visualizacion=Util.GRID;
                cambiarVisualizacion();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    private void cambiarVisualizacion() {
        if (Util.visualizacion==Util.LIST){
            adapter=new RestaurantesAdapter(R.layout.content_item_list,restaurantes,this);
            manager=new LinearLayoutManager(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
            Util.listItem.setVisible(false);
            Util.gridItem.setVisible(true);
        }else if (Util.visualizacion==Util.GRID){
            adapter=new RestaurantesAdapter(R.layout.content_item_grid,restaurantes,this);
            manager=new GridLayoutManager(getContext(),2);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
            Util.listItem.setVisible(true);
            Util.gridItem.setVisible(false);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSendRestaurante) {
            mListener = (OnSendRestaurante) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSendRestaurante");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(Restaurante restaurante, int position) {
        mListener.sendRestaurante(restaurantes.get(position));
    }


    public interface OnSendRestaurante {
        // TODO: Update argument type and name
        void sendRestaurante(Restaurante restaurante);
    }
}
