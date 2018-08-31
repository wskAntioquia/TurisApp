package com.example.worldskills.turisapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.adapters.SitiosAdapter;
import com.example.worldskills.turisapp.data.Datos;
import com.example.worldskills.turisapp.models.Sitio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;


public class SitosFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private SitiosAdapter adapter;
    private ArrayList<Sitio> sitios;
    private Datos datos;
    private Sitio sitio;


    private OnFragmentInteractionListener mListener;

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
        datos=new Datos(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sitos, container, false);
        recyclerView=view.findViewById(R.id.recyclerSitios);
        manager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        sitios=datos.listarSitios();
        adapter=new SitiosAdapter(R.layout.content_item_list, sitios, new SitiosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Sitio sitio, int position) {

            }
        });
        recyclerView.setAdapter(adapter);
        return view;
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
