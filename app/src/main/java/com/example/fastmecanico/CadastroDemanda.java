package com.example.fastmecanico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class CadastroDemanda extends AppCompatActivity {

    private EditText idDescricao ,idVeiculo ,idTelefone,idLocal;
    private FirebaseFirestore db;
    private FirebaseUser user;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_demanda);
        //inicializa banco de dados
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        //Linkando Editext no banco de dados
        idDescricao = findViewById(R.id.id_descricao);
        idVeiculo = findViewById(R.id.id_veículo);
        idTelefone = findViewById(R.id.id_telefone);
        idLocal = findViewById(R.id.id_Local);


        Button cadastrademanda = findViewById(R.id.cadastrademanda);
        cadastrademanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ){
                CadastrarDemanda();

            }

        });
    }

    private void CadastrarDemanda() {

        if(idDescricao.getText() == null || idDescricao.getText().toString().length()==0){
            ExibirMensagemErro("Campo Descrição não pode estar em branco");
            return;
        }
        if(idVeiculo.getText() == null || idVeiculo.getText().toString().length()==0){
            ExibirMensagemErro("Campo Veiculo não pode estar em branco");
            return;
        }
        if(idTelefone.getText() == null || idTelefone.getText().toString().length()==0){
            ExibirMensagemErro("Campo Telefone não pode estar em branco");
            return;
        }
        if(idLocal.getText() == null || idLocal.getText().toString().length()==0){
            ExibirMensagemErro("Campo Local não pode estar em branco");
            return;
        }


        user = mAuth.getCurrentUser();
        Map<String, Object> demanda = new HashMap<>();
        demanda.put("Descricao", idDescricao.getText().toString());
        demanda.put("Veiculo", idVeiculo.getText().toString());
        demanda.put("Telefone", Long.parseLong(idTelefone.getText().toString()));
        demanda.put("Local", idLocal.getText().toString());



        db.collection("Demanda")
                .add(demanda)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        ExibirMensagemErro("Veiculo cadastrado com sucesso!");
                    }
                });
    }
    private void ExibirMensagemErro(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
