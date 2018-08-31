package com.example.worldskills.turisapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.models.Hotel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HotelesAdapter extends RecyclerView.Adapter<HotelesAdapter.ViewHolder>{
    private int layout;
    private ArrayList<Hotel> hotels;
    private OnItemClickListener listener;

    //constructor del adapter
    public HotelesAdapter(int layout, ArrayList<Hotel> hotels, OnItemClickListener listener) {
        this.layout = layout;
        this.hotels = hotels;
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
        holder.Bind(hotels.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    //carga e inicializa los elementos de la interfaz grafica
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

        public void Bind(final Hotel hotel, final OnItemClickListener listener) {
            nombre.setText(hotel.getNombre());
            descripcion.setText(hotel.getDescripcion_corta());
            ubicacion.setText(hotel.getUbicacion());
            Picasso.get().load(hotel.getImagen()).error(R.drawable.ic_menu_camera).placeholder(R.drawable.ic_menu_send).fit().into(imagen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(hotel,getAdapterPosition());
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(Hotel hotel,int position);
    }
}
