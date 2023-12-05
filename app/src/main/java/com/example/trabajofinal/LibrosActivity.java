package com.example.trabajofinal;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinal.categoria.Categoria;
import com.example.trabajofinal.libro.Libro;
import com.example.trabajofinal.libro.LibroAdapter;

import java.util.ArrayList;
import java.util.List;

public class LibrosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LibroAdapter libroAdapter;
    private int categoriaId;
    private Categoria categoria;
    private ArrayList<Libro> libroArrayListByCategoria ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);

        recyclerView = findViewById(R.id.recyclerViewLibros);

        // Configurar el GridLayoutManager
        updateLayoutManager();

        ArrayList<Libro> libroArrayList = Libro.LIBROS;

        // Recibe la información pasada desde MainActivity
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("CategoriaId")) {
            categoriaId =   intent.getIntExtra("CategoriaId",-1);

        }

        categoria = Categoria.CATEGORIAS.stream().filter(categoria1 -> categoria1.getId() == categoriaId).findFirst().get();
        libroArrayListByCategoria = filtrarPorCategoria(libroArrayList, categoria.getId());
        libroAdapter    =   new LibroAdapter(libroArrayListByCategoria, this);

        libroAdapter.setOnItemClickListener(position -> {
            Intent intent2 = new Intent(LibrosActivity.this, PdfViewerLibro.class);
            intent2.putExtra("LibroId", libroArrayListByCategoria.get(position).getId());
            startActivity(intent2);
        });

        recyclerView.setAdapter(libroAdapter);

        ImageButton backButton = findViewById(R.id.backButton);

        SearchView searchView = findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filtrarPorTexto(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filtrarPorTexto(newText);
                return false;
            }
        });

        backButton.setOnClickListener(view -> {
            finish();
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateLayoutManager();
    }

    private void updateLayoutManager() {
        int orientation = getResources().getConfiguration().orientation;
        int spanCount = (orientation == Configuration.ORIENTATION_PORTRAIT) ? 2 : 3;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    public ArrayList<Libro> filtrarPorCategoria(ArrayList<Libro> listaLibros, int categoriaDeseada) {
        ArrayList<Libro> librosFiltrados = new ArrayList<>();

        for (Libro libro : listaLibros) {
            if (libro.getCategoria() == categoriaDeseada) {
                librosFiltrados.add(libro);
            }
        }

        return librosFiltrados;
    }

    private void filtrarPorTexto(String texto) {
        List<Libro> librosFiltrados = new ArrayList<>();

        for (Libro libro : libroArrayListByCategoria) {
            if (libro.getNombreLibro().toLowerCase().contains(texto.toLowerCase())) {
                librosFiltrados.add(libro);
            }
        }

        libroAdapter.setLibros(librosFiltrados);
    }

}