package com.example.worldskills.turisapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.models.Sitio;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SitiosAdapter extends RecyclerView.Adapter<SitiosAdapter.ViewHolder> {
    private int layout;
    private ArrayList<Sitio>sitios;
    private OnItemClickListener listener;


    public SitiosAdapter(int layout, ArrayList<Sitio> sitios, OnItemClickListener listener) {
        this.layout = layout;
        this.sitios = sitios;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Bind(sitios.get(position),listener);

    }

    @Override
    public int getItemCount() {
        return sitios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre,descripcion,ubicacion;
        public ImageView imagen;
        public ViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.content_nom);
            descripcion=itemView.findViewById(R.id.content_desc);
            ubicacion=itemView.findViewById(R.id.content_ubic);
            imagen=itemView.findViewById(R.id.content_img);
        }

        public void Bind(final Sitio sitio, final OnItemClickListener listener) {
            nombre.setText(sitio.getNombre());
            descripcion.setText(sitio.getDescripcion_corta());
            ubicacion.setText(sitio.getUbicacion());
            Picasso.get().load(sitio.getImagen()).error(R.drawable.ic_menu_camera).placeholder(R.drawable.ic_menu_send).fit().into(imagen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(sitio,getAdapterPosition());
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Sitio sitio,int position);
    }
}
