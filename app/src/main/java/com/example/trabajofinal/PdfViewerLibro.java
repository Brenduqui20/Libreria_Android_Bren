package com.example.trabajofinal;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajofinal.libro.Libro;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PdfViewerLibro extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final float ZOOM_VALUE = 0.4F;

    private PDFView pdfView;
    private Integer pageNumber = 0;
    private String pdfFileName;

    private int positionLibro;
    private Libro libro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer_libro);

        ArrayList<Libro> libroArrayList = Libro.LIBROS;

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("LibroId")) {
            positionLibro = intent.getIntExtra("LibroId", -1);
        }

        libro = libroArrayList.stream().filter(libro1 -> libro1.getId() == positionLibro).findFirst().get();

        pdfView= (PDFView)findViewById(R.id.pdfView);

        // Establecer límites de zoom
        pdfView.setMinZoom(1f);
        pdfView.setMaxZoom(5f);


        // Carga y muestra el PDF
        InputStream inputStream = getResources().openRawResource(libro.getPdfResource());
        displayFromStream(inputStream);


        ImageButton backButton = findViewById(R.id.backButton);
        TextView tituloLibro = findViewById(R.id.tituloLibro);

        ImageButton zoomInButton = findViewById(R.id.zoomInButton);
        ImageButton zoomOutButton = findViewById(R.id.zoomOutButton);

        backButton.setOnClickListener(view -> finish());

        tituloLibro.setSelected(true);
        tituloLibro.setText(libro.getNombreLibro());


        zoomInButton.setOnClickListener(view -> {
            zoomIn();
        });

        zoomOutButton.setOnClickListener(view -> {
            zoomOut();
        });

    }

    private void zoomIn() {
        try {
            float newZoom = pdfView.getZoom() + ZOOM_VALUE;
            if (newZoom <= pdfView.getMaxZoom()) {
                float centerX = pdfView.getWidth() / 2f;
                float centerY = pdfView.getHeight() / 2f;
                pdfView.zoomCenteredTo(newZoom, new PointF(centerX, centerY));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void zoomOut() {
        try {
            float newZoom = pdfView.getZoom() - ZOOM_VALUE;
            if (newZoom >= pdfView.getMinZoom()) {
                float centerX = pdfView.getWidth() / 2f;
                float centerY = pdfView.getHeight() / 2f;
                pdfView.zoomCenteredTo(newZoom, new PointF(centerX, centerY));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");
    }


    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(pdfFileName)
                .defaultPage(pageNumber)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)

                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }

    private void displayFromStream(InputStream inputStream) {

        pdfView.fromStream(inputStream)
                .defaultPage(pageNumber)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }
}