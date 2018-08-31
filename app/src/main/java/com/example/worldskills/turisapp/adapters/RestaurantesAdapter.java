package com.example.worldskills.turisapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.models.Restaurante;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestaurantesAdapter extends RecyclerView.Adapter<RestaurantesAdapter.ViewHolder> {
    private int layout;
    private ArrayList<Restaurante>restaurantes;
    private OnItemClickListener listener;

    //constructor del adapter
    public RestaurantesAdapter(int layout, ArrayList<Restaurante> restaurantes, OnItemClickListener listener) {
        this.layout = layout;
        this.restaurantes = restaurantes;
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
        holder.Bind(restaurantes.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }

    //se cargan los elementos graficos
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

        public void Bind(final Restaurante restaurante, final OnItemClickListener listener) {
            nombre.setText(restaurante.getNombre());
            descripcion.setText(restaurante.getDescripcion_corta());
            ubicacion.setText(restaurante.getUbicacion());
            Picasso.get().load(restaurante.getImagen()).error(R.drawable.ic_menu_camera).placeholder(R.drawable.ic_menu_send).fit().into(imagen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(restaurante,getAdapterPosition());
                }
            });
        }
    }

    //que pasara al darle click en uno de los items
    public interface OnItemClickListener{
        void onItemClick(Restaurante restaurante,int position);
    }
}
