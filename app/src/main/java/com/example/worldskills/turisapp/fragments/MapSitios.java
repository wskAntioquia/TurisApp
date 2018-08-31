package com.example.worldskills.turisapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.models.Sitio;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapSitios extends Fragment {
    private GoogleMap map;
    private MapView mapView;
    private View vista;
    private Sitio sitio;



    public MapSitios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         vista =inflater.inflate(R.layout.fragment_map_sitios, container, false);
        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mapView=vista.findViewById(R.id.mapSitios);
        if (null!=mapView){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    map=googleMap;
                    map.setMinZoomPreference(11);
                    for (int i=0;i<SitosFragment.sitios.size();i++){
                        sitio=SitosFragment.sitios.get(i);
                        LatLng latLng=new LatLng(sitio.getLatitud(),sitio.getLongitud());
                        map.addMarker(new MarkerOptions().position(latLng).title(sitio.getNombre()));
                        if (i==0){
                            CameraPosition position=new CameraPosition(latLng,10,0,0);
                            map.animateCamera(CameraUpdateFactory.newCameraPosition(position));
                        }

                    }
                }
            });
        }
    }
}
