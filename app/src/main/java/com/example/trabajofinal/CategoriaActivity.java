package com.example.trabajofinal;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinal.categoria.Categoria;
import com.example.trabajofinal.categoria.CategoriaAdapter;

import java.util.ArrayList;

public class CategoriaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoriaAdapter categoriaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        recyclerView = findViewById(R.id.recyclerViewCategoria);

        // Configurar el GridLayoutManager
        updateLayoutManager();

        ArrayList<Categoria> categoriaArrayList = Categoria.CATEGORIAS;

        categoriaAdapter = new CategoriaAdapter(categoriaArrayList, this);

        categoriaAdapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(CategoriaActivity.this, LibrosActivity.class);
            intent.putExtra("CategoriaId", categoriaArrayList.get(position).getId());
            startActivity(intent);
        });

        recyclerView.setAdapter(categoriaAdapter);

    }

    private void updateLayoutManager() {
        int orientation = getResources().getConfiguration().orientation;
        int spanCount = (orientation == Configuration.ORIENTATION_PORTRAIT) ? 2 : 3;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateLayoutManager();
    }
}