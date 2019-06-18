package com.example.fastmecanico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroDeUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_usuario);


        Button veiculo = (Button) findViewById(R.id.veiculo);
        veiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ){
                setContentView(R.layout.activity_cadastro_veiculo);
            }
        });


    }
}
