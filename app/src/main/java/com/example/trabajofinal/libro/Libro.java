package com.example.trabajofinal.libro;

import com.example.trabajofinal.R;

import java.util.ArrayList;

public class Libro {
    private int id;
    private int imagen;
    private int categoria;
    private String nombreLibro;
    private String autor;
    private String isbn;
    private int pdfResource;

    public static final ArrayList<Libro> LIBROS = new ArrayList<Libro>() {{
        // CRIMINALISTICA
        add(new Libro(1, R.drawable.img_b1, 1, R.raw.b1, "Manual de actuación en el lugar del hecho yo escena del delito", "Dr. Germán Carlos Garavano, Dr. Santiago Otamendi y Dr. Juan José Benitez", "978-987-4196-03-3"));
        add(new Libro(2, R.drawable.img_b2, 1, R.raw.b2, "03. Conceptos básicos de cienca, tecnología e innovación", "Comisión Nacional de Investigación Científica y Tecnológica", ""));
        add(new Libro(3, R.drawable.img_b3, 1, R.raw.b3, "03.Patología Forense", "Rosa M. Pérez Pérez", ""));
        add(new Libro(4, R.drawable.img_b4, 1, R.raw.b4, "04. Importancia de la Medicina Legal en la práctica médica", "Ismael García-Garduzaa", ""));
        add(new Libro(5, R.drawable.img_b5, 1, R.raw.b5, "Criminalistica-Aplicada", "", ""));
        add(new Libro(6, R.drawable.img_b6, 1, R.raw.b6, "LIBRO-DACTILOSCOPIA", "", ""));
        add(new Libro(7, R.drawable.img_b7, 1, R.raw.b7, "manual-de-criminalistica-moderna__2_", "", ""));
        add(new Libro(8, R.drawable.img_b8, 1, R.raw.b8, "medicina_legal", "", ""));
        add(new Libro(9, R.drawable.img_b9, 1, R.raw.b9, "medicina-forense", "", ""));
        add(new Libro(10, R.drawable.img_b10, 1, R.raw.b10, "medicina", "", ""));

        // INFORMATICA
        add(new Libro(11, R.drawable.img_b11, 2, R.raw.b11, "01. Bases de Datos", "María del Carmen Gómez Fuentes", ""));
        add(new Libro(12, R.drawable.img_b12, 2, R.raw.b12, "2 Análisis de Datos", "Sandra Peña", ""));
        add(new Libro(13, R.drawable.img_b13, 2, R.raw.b13, "2 Computación en nube Beneficios, riesgos y recomendaciones para la seguridad de la información", "ENISA - European Union", ""));
        add(new Libro(14, R.drawable.img_b14, 2, R.raw.b14, "3 Desarrollo de aplicaciones en la nube (cloud computing)", "Vicente Agut Navarro", ""));
        add(new Libro(15, R.drawable.img_b15, 2, R.raw.b15, "03. Manual de Prácticas de Computación Básica I", "Norma Soriano Garibay", ""));
        add(new Libro(16, R.drawable.img_b16, 2, R.raw.b16, "4 Computación en la nube Con Google Drive", "Edgar R. Morales Caluña Fernando X. Altamirano Capelo", ""));
        add(new Libro(17, R.drawable.img_b17, 2, R.raw.b17, "4 Métodos de análisis de datos", "Hernández Martín, Zenaida", ""));
        add(new Libro(18, R.drawable.img_b18, 2, R.raw.b18, "6 Fundamentos y plataformas de cloud computing", "Remo Suppi Boldrito", ""));
        add(new Libro(19, R.drawable.img_b19, 2, R.raw.b19, "13 Del cloud computing al big data", "Jordi Torres i Viñals", ""));

        // PSICOLOGIA
        add(new Libro(20, R.drawable.img_b20, 3, R.raw.b20, "02. Diagnóstico y tratamiento del episodio depresivo y del trastorno depresivo recurrente en adultos", "Ministerio de Salud Pública", ""));
        add(new Libro(21, R.drawable.img_b21, 3, R.raw.b21, "03. Guía de autoayuda sobre tipos de intervención para manejar las emociones", "Dra. Esperanza Dongil Collado y Dr. Antonio Cano Vindel", ""));
        add(new Libro(22, R.drawable.img_b22, 3, R.raw.b22, "03. Guía de práctica clínica de los trastornos depresivos", "Varios autores", ""));
        add(new Libro(23, R.drawable.img_b23, 3, R.raw.b23, "04. Esquizofrenia temprana", "Rogelio García Jubera", ""));
        add(new Libro(24, R.drawable.img_b24, 3, R.raw.b24, "04. Tratamientos de personas con depresión", "Ministerio de Salud de Chile", ""));
        add(new Libro(25, R.drawable.img_b25, 3, R.raw.b25, "05. La depresión", "Grupo de trabajo de la Guía de Práctica Clínica sobre el Manejo de la Depresión en el Adulto", ""));
        add(new Libro(26, R.drawable.img_b26, 3, R.raw.b26, "08. La depresión en adolescentes", "Almudena García Alonso", ""));
        add(new Libro(27, R.drawable.img_b27, 3, R.raw.b27, "09. Rehabilitación psicosocial y esquizofrenia", "Valentina Alvarez", ""));
        add(new Libro(28, R.drawable.img_b28, 3, R.raw.b28, "10. En qué consiste la depresión", "Servicio Andaluz de Salud – Junta de Andalucia", ""));
        add(new Libro(29, R.drawable.img_b29, 3, R.raw.b29, "20. Esquizofrenia en niños y adolescentes", "Varios autores", ""));
        add(new Libro(30, R.drawable.img_b30, 3, R.raw.b30, "PACIENTES_DEMENCIA", "", ""));
    }};

    public Libro(int id, int imagen, int categoria, int pdfResource, String nombreLibro, String autor, String isbn) {
        this.id = id;
        this.imagen = imagen;
        this.categoria = categoria;
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.isbn = isbn;
        this.pdfResource = pdfResource;
    }

    public int getId() {
        return id;
    }

    public int getImagen() {
        return imagen;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPdfResource() {
        return pdfResource;
    }
}


