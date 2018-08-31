package com.example.worldskills.turisapp.adapters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.Utils.Util;
import com.example.worldskills.turisapp.models.Hotel;
import com.example.worldskills.turisapp.models.Restaurante;
import com.example.worldskills.turisapp.models.Sitio;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private TextView nombre,descripcion;
    private ImageView imagen;
    Sitio sitio;
    Hotel hotel;
    Restaurante restaurante;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_details, container, false);
        nombre=view.findViewById(R.id.nombreDetail);
        descripcion=view.findViewById(R.id.descripcionDetail);
        imagen=view.findViewById(R.id.imagenDetail);

        Bundle bundle=getArguments();
        if (bundle!=null){
            int type=bundle.getInt("type");
            switch (type){
                case Util.SITIO:
                    sitio= (Sitio) bundle.getSerializable("obj");
                    cargarSitio(sitio);
                    break;
                case Util.HOTEL:
                    sitio= (Sitio) bundle.getSerializable("obj");
                    cargarSitio(sitio);
                    break;
                case Util.RESTAURANTE:
                    sitio= (Sitio) bundle.getSerializable("obj");
                    cargarSitio(sitio);
                    break;


            }
        }

        return view;
    }

    //cargar los sitios
    public void cargarSitio(Sitio sitio) {
        nombre.setText(sitio.getNombre());
        descripcion.setText(sitio.getDescripcion());
        Picasso.get().load(sitio.getImagen()).error(R.drawable.ic_menu_camera).placeholder(R.drawable.ic_menu_send).fit().into(imagen);
    }
}


