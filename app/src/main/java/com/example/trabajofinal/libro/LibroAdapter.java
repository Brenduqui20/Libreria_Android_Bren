package com.example.trabajofinal.libro;

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

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.LibroViewHolder> {

    private List<Libro> item;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public LibroAdapter(List<Libro> item, Context context) {
        this.item = item;
        this.context = context;
    }
    public void setLibros(List<Libro> libros) {
        this.item = libros;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro, parent, false);
        return new LibroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position) {

        holder.id = item.get(position).getId();
        holder.categoria = item.get(position).getCategoria();
        holder.imagen.setImageResource(item.get(position).getImagen());
        holder.nombreLibro.setText(item.get(position).getNombreLibro());
        holder.autor.setText(item.get(position).getAutor());
        holder.isbn.setText(item.get(position).getIsbn());

        holder.itemView.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class LibroViewHolder extends RecyclerView.ViewHolder {

        private int id;
        private int categoria;
        private ImageView imagen;
        private TextView nombreLibro;
        private TextView autor;
        private TextView isbn;

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.libroImagen);
            nombreLibro = itemView.findViewById(R.id.libroNombre);
            autor = itemView.findViewById(R.id.libroAutor);
            isbn = itemView.findViewById(R.id.libroISBN);
        }
    }
}

