package com.example.worldskills.turisapp.fragments;

import android.content.Context;
import android.database.Cursor;
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
import com.example.worldskills.turisapp.adapters.SitiosAdapter;
import com.example.worldskills.turisapp.data.Datos;
import com.example.worldskills.turisapp.models.Sitio;

import java.util.ArrayList;


public class SitosFragment extends Fragment implements SitiosAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private SitiosAdapter adapter;
    public static ArrayList<Sitio> sitios;
    private Datos datos;
    private Sitio sitio;


    private OnSendSitio mListener;

    public SitosFragment() {
        // Required empty public constructor
    }


    public static SitosFragment newInstance(String param1, String param2) {
        SitosFragment fragment = new SitosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        datos=new Datos(getContext());
        getActivity().setTitle("Sitios");

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sitos, container, false);
        recyclerView=view.findViewById(R.id.recyclerSitios);
        manager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        sitios=new ArrayList<>();
        sitios= listarSitios();
        adapter=new SitiosAdapter(R.layout.content_item_list, sitios,this);
        recyclerView.setAdapter(adapter);
        return view;
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
            adapter=new SitiosAdapter(R.layout.content_item_list,sitios,this);
            manager=new LinearLayoutManager(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
            Util.listItem.setVisible(false);
            Util.gridItem.setVisible(true);
        }else if (Util.visualizacion==Util.GRID){
            adapter=new SitiosAdapter(R.layout.content_item_grid,sitios,this);
            manager=new GridLayoutManager(getContext(),2);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
            Util.listItem.setVisible(true);
            Util.gridItem.setVisible(false);
        }
    }

    private ArrayList<Sitio> listarSitios() {
        Cursor cursor=datos.listarSitios();
        do {
            sitio=new Sitio();
            sitio.setNombre(cursor.getString(cursor.getColumnIndex(Util.CAMPO_NOMBRE)));
            sitio.setDescripcion_corta(cursor.getString(cursor.getColumnIndex(Util.CAMPO_DESCRIP_CORTA)));
            sitio.setUbicacion(cursor.getString(cursor.getColumnIndex(Util.CAMPO_UBICACION)));
            sitio.setDescripcion(cursor.getString(cursor.getColumnIndex(Util.CAMPO_DESCRIPCION)));
            sitio.setLatitud(cursor.getDouble(cursor.getColumnIndex(Util.CAMPO_LATITUD)));
            sitio.setLongitud(cursor.getDouble(cursor.getColumnIndex(Util.CAMPO_LONGITUD)));
            sitio.setImagen(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Util.CAMPO_IMAGEN))));
            sitios.add(sitio);
        }while (cursor.moveToNext());
        return sitios;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSendSitio) {
            mListener = (OnSendSitio) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSendSitio");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(Sitio sitio, int position) {
        mListener.sendSitio(sitios.get(position));
    }


    public interface OnSendSitio {
        // TODO: Update argument type and name
        void sendSitio(Sitio sitio);
    }
}
