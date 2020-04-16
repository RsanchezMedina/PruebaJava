package com.rsanchez.appareaseysjava.controlador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rsanchez.appareaseysjava.R;
import com.rsanchez.appareaseysjava.modelo.Personas;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder> {

    Context context;
    List<Personas> listaPersonas;

    public ListaAdapter(Context context, List<Personas> lista) {
        this.context = context;
        this.listaPersonas = lista;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personas, parent, false);
        return new ListaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textNombre.setText(listaPersonas.get(position).getNombre());
        holder.textEmail.setText(listaPersonas.get(position).getEmail());
        holder.textApellido.setText(listaPersonas.get(position).getApellido());
        Picasso.with(context).load(listaPersonas.get(position).getAvatar()).into(holder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textNombre;
        TextView textApellido;
        TextView textEmail;
        ImageView imgIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNombre = itemView.findViewById(R.id.nombrePerson);
            textApellido = itemView.findViewById(R.id.apellidoPerson);
            textEmail = itemView.findViewById(R.id.emailPerson);
            imgIcon = itemView.findViewById(R.id.imageIcon);
        }
    }

}


