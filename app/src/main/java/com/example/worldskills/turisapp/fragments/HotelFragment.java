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
import com.example.worldskills.turisapp.adapters.HotelesAdapter;
import com.example.worldskills.turisapp.data.Datos;
import com.example.worldskills.turisapp.models.Hotel;

import java.util.ArrayList;


public class HotelFragment extends Fragment implements HotelesAdapter.OnItemClickListener{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private HotelesAdapter adapter;
    public static ArrayList<Hotel> hotels;
    private Datos datos;
    private Hotel hotel;

    private OnSendoHotel mListener;

    public HotelFragment() {
        // Required empty public constructor
    }

    public static HotelFragment newInstance(String param1, String param2) {
        HotelFragment fragment = new HotelFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        getActivity().setTitle("Hoteles");
        datos=new Datos(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_hotel, container, false);
        recyclerView=view.findViewById(R.id.recyclerHoteles);
        manager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        hotels=new ArrayList<>();
        hotels=listarHoteles();
        adapter=new HotelesAdapter(R.layout.content_item_list, hotels,this);
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
        switch (item.getItemId()) {
            case R.id.list:
                Util.visualizacion = Util.LIST;
                cambiarVisualizacion();
                break;
            case R.id.grid:
                Util.visualizacion = Util.GRID;
                cambiarVisualizacion();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
        private ArrayList<Hotel> listarHoteles(){
            Cursor cursor=datos.listarHoteles();
            do {
                hotel=new Hotel();
                hotel.setNombre(cursor.getString(cursor.getColumnIndex(Util.CAMPO_NOMBRE)));
                hotel.setDescripcion_corta(cursor.getString(cursor.getColumnIndex(Util.CAMPO_DESCRIP_CORTA)));
                hotel.setUbicacion(cursor.getString(cursor.getColumnIndex(Util.CAMPO_UBICACION)));
                hotel.setDescripcion(cursor.getString(cursor.getColumnIndex(Util.CAMPO_DESCRIPCION)));
                hotel.setLatitud(cursor.getDouble(cursor.getColumnIndex(Util.CAMPO_LATITUD)));
                hotel.setLongitud(cursor.getDouble(cursor.getColumnIndex(Util.CAMPO_LONGITUD)));
                hotel.setImagen(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Util.CAMPO_IMAGEN))));
                hotels.add(hotel);
            }while (cursor.moveToNext());
            return hotels;

        }



    private void cambiarVisualizacion() {
        if (Util.visualizacion==Util.LIST){
            adapter=new HotelesAdapter(R.layout.content_item_list,hotels,this);
            manager=new LinearLayoutManager(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
            Util.listItem.setVisible(false);
            Util.gridItem.setVisible(true);
        }else if (Util.visualizacion==Util.GRID){
            adapter=new HotelesAdapter(R.layout.content_item_grid,hotels,this);
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
        if (context instanceof OnSendoHotel) {
            mListener = (OnSendoHotel) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSendoHotel");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(Hotel hotel, int position) {
        mListener.sendHotel(hotels.get(position));
    }


/**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSendoHotel {
        // TODO: Update argument type and name
        void sendHotel(Hotel hotel);
    }
}
