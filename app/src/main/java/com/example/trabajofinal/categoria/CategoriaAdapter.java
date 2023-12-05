package com.example.trabajofinal.categoria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinal.OnItemClickListener;
import com.example.trabajofinal.R;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {

    private List<Categoria> item;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public CategoriaAdapter(List<Categoria> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent, false);
        return new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        holder.id   =   item.get(position).getId();
        holder.imagen.setImageResource(item.get(position).getImagen());
        holder.concepto.setText(item.get(position).getConcepto());
        holder.descripcion.setText(item.get(position).getDescripcion());

        holder.itemView.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {return item.size();}

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder {

        private int id;
        private ImageView imagen;
        private TextView concepto;
        private TextView descripcion;

        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.categoriaImage);
            concepto = itemView.findViewById(R.id.categoriaConcepto);
            descripcion = itemView.findViewById(R.id.categoriaDescripcion);
        }
    }
}
