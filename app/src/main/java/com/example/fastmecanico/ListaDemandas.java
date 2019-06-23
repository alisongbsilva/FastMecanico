package com.example.fastmecanico;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListaDemandas extends AppCompatActivity {

    //Criando Botao e linkando a  tela cadastrar
    private FirebaseAuth mAuth;
    private int RC_SIGN_IN = 1;
    private FirebaseFirestore db;
    ArrayAdapter<String> adapter;
    List<String> lista;
    ListView demandas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_demandas);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();


        demandas = findViewById(R.id.lista_demanda);

        buscarDemandas();
    }

    private void buscarDemandas(){
        db.collection("Demanda").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    lista = new ArrayList<>();
                    for(QueryDocumentSnapshot doc : task.getResult()){
                        lista.add(doc.getString("Desc"));
                        Log.d("AppAlison", doc.getString("Desc"));
                    }
                    adapter = new ArrayAdapter<String>(ListaDemandas.this, android.R.layout.simple_list_item_1, lista);
                    demandas.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    Log.d("AppAlison", task.getException().getMessage());
                }
            }
        });
    }
}
