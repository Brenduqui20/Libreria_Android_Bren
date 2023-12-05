package com.example.trabajofinal.categoria;

import com.example.trabajofinal.R;

import java.util.ArrayList;

public class Categoria {
    private int id;
    private int imagen;
    private String concepto;
    private String descripcion;

    public static final ArrayList<Categoria> CATEGORIAS = new ArrayList<Categoria>(){{
        add(new Categoria(1, R.drawable.img_criminalistica, "CRIMINALISTICA", "Libros sobre criminalistica"));
        add(new Categoria(2, R.drawable.img_informatica, "INFORMATICA", "Libros relacionados a informática"));
        add(new Categoria(3, R.drawable.img_psicologia, "PSICOLOGIA", "Libros sobre psicológia"));
    }};

    public Categoria(int id, int imagen, String concepto, String descripcion) {
        this.id = id;
        this.imagen = imagen;
        this.concepto = concepto;
        this.descripcion = descripcion;
    }


    public int getId() { return id;}

    public int getImagen() {
        return imagen;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
