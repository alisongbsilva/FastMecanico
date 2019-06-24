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

public class ListarVeiculo extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private int RC_SIGN_IN = 1;
    private FirebaseFirestore db;
    ArrayAdapter<String> adapter;
    List<String> editar;
    ListView listaVeiculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_veiculo);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        listaVeiculos = findViewById(R.id.listaVeiculos);

        buscarVeiculo();
    }
    private void buscarVeiculo(){
        db.collection("Veiculo").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    editar = new ArrayList();
                    for(QueryDocumentSnapshot doc : task.getResult()){
                        editar.add(doc.getString("Placa") + " - " + doc.getString("Modelo"));
                        //Log.d("editar veiculo", doc.getString("Desc"));
                    }
                    adapter = new ArrayAdapter<String>(ListarVeiculo.this, android.R.layout.simple_list_item_1, editar);
                    listaVeiculos.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    Log.d("editar veiculo", task.getException().getLocalizedMessage());
                }
            }
        });
    }
}
