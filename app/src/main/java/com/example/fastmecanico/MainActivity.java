package com.example.fastmecanico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
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
    getSupportActionBar().hide(); //Oculta a ActionBar.
    setContentView(R.layout.activity_tela_usuario);
    db = FirebaseFirestore.getInstance();

    //getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
    //getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
    //getSupportActionBar().setTitle("Fast Mecanico");     //Titulo para ser exibido na sua Action Bar em frente à seta

    mAuth = FirebaseAuth.getInstance();


    /*demandas = findViewById(R.id.lista_demanda);


    buscarDemandas();*/

    Button demandas = (Button) findViewById(R.id.demandas);
    demandas.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v ){
            startActivity(new Intent(getApplicationContext(), ListaDemandas.class));
        }
    });

    Button veiculo = (Button) findViewById(R.id.cadastroveiculo);
    veiculo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v ){
            startActivity(new Intent(getApplicationContext(), CadastroVeiculo.class));
        }
    });

    Button listaveiculo = (Button) findViewById(R.id.listaveiculo);
    listaveiculo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v ){
            startActivity(new Intent(getApplicationContext(), ListarVeiculo.class));
        }
    });

    Button CadastroDemanda = (Button) findViewById(R.id.auxilio);
    CadastroDemanda.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v ){
            startActivity(new Intent(getApplicationContext(), CadastroDemanda.class));
        }
    });

    /*public final void signOut() {
        // [START auth_sign_out]
        FirebaseAuth.getInstance().signOut();
        // [END auth_sign_out]
    }

    Button sair = (Button) findViewById(R.id.sair);
    demandas.setOnClickListener(new signOut() {

    });*/

}

    /*private void buscarDemandas(){
        db.collection("Demanda").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    lista = new ArrayList<>();
                    for(QueryDocumentSnapshot doc : task.getResult()){
                        lista.add(doc.getString("Desc"));
                        Log.d("AppAlison", doc.getString("Desc"));
                    }
                    adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, lista);
                    demandas.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    Log.d("AppAlison", task.getException().getMessage());
                }
            }
        });
    }*/

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser current = mAuth.getCurrentUser();
        if(current == null){
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build(),
                    new AuthUI.IdpConfig.GoogleBuilder().build());
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(),
                    RC_SIGN_IN);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
}

