package com.example.fastmecanico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_usuario);

        Button demandas = (Button) findViewById(R.id.demandas);
        demandas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ){
                setContentView(R.layout.activity_lista_demandas);
            }
        });

    }
}
