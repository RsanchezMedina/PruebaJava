package com.rsanchez.appareaseysjava.vista;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rsanchez.appareaseysjava.R;
import com.rsanchez.appareaseysjava.controlador.ActivityPresenter;
import com.rsanchez.appareaseysjava.controlador.ListaAdapter;

public class MainActivity extends AppCompatActivity {

    private ActivityPresenter presenter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView textFail;
    private ImageView imgFail;
    private RecyclerView.LayoutManager layoutManager;
    private ListaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        if (presenter != null) {
            presenter.getDataPersonas();
            presenter.getListaPersonas().observe(this, lista -> {
                if (lista != null && lista.size() > 0) {
                    adapter = new ListaAdapter(this, lista);
                    recyclerView.setAdapter(adapter);
                    hidenProgressBar();
                }
            });

            presenter.getErrorConection().observe(this, error -> {
                if (error != null) {
                    hidenProgressBar();
                    textFail.setText(error.getMessage());
                    textFail.setVisibility(View.VISIBLE);
                    imgFail.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    private void inicializar() {
        //variables de activity
        presenter = new ActivityPresenter();
        textFail = findViewById(R.id.textFail);
        imgFail = findViewById(R.id.imgFail);
        progressBar = findViewById(R.id.progressBar);
        //lista
        recyclerView = findViewById(R.id.lista_personas);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void hidenProgressBar() {
        progressBar.setVisibility(View.GONE);
    }


}
