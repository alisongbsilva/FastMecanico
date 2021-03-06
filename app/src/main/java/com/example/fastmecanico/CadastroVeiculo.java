package com.example.fastmecanico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class CadastroVeiculo extends AppCompatActivity {

    private EditText idMarca, idAno, idPlaca, idModelo, idCor, idCnh;
    private FirebaseFirestore db;
    private FirebaseUser user;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_veiculo);

        //Inicializando bd
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();


        //Linkando EditTexts
        idMarca = findViewById(R.id.id_marca);
        idAno = findViewById(R.id.id_ano);
        idPlaca = findViewById(R.id.id_placa);
        idModelo = findViewById(R.id.id_modelo);
        idCor = findViewById(R.id.id_cor);
        idCnh = findViewById(R.id.idcnh);
//Botao de concluido
        Button concluido = findViewById(R.id.concluido);
        concluido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ){
                CadastrarVeiculo();

            }

        });
    }
//Exibe mensagem indicando que o campo nao pode estar nulo
    private void CadastrarVeiculo() {


        if(idMarca.getText() == null || idMarca.getText().toString().length()==0){
            ExibirMensagemErro("Campo marca não pode estar em branco");
            return;
        }
        if(idAno.getText() == null || idAno.getText().toString().length()==0){
            ExibirMensagemErro("Campo ano não pode estar em branco");
            return;
        }
        if(idPlaca.getText() == null || idPlaca.getText().toString().length()==0){
            ExibirMensagemErro("Campo placa não pode estar em branco");
            return;
        }
        if(idModelo.getText() == null || idModelo.getText().toString().length()==0){
            ExibirMensagemErro("Campo modelo não pode estar em branco");
            return;
        }
        if(idCor.getText() == null || idCor.getText().toString().length()==0){
            ExibirMensagemErro("Campo cor não pode estar em branco");
            return;
        }
        if(idCnh.getText() == null || idCnh.getText().toString().length()==0){
            ExibirMensagemErro("Campo cnh não pode estar em branco");
            return;
        }
        //salva os campos preenchidos no banco de dados
        user = mAuth.getCurrentUser();
        Map<String, Object> veiculo = new HashMap<>();
        veiculo.put("Marca", idMarca.getText().toString());
        veiculo.put("Ano", Integer.parseInt(idAno.getText().toString()));
        veiculo.put("Placa", idPlaca.getText().toString());
        veiculo.put("Modelo", idModelo.getText().toString());
        veiculo.put("Cor", idCor.getText().toString());
        veiculo.put("Cnh", Long.parseLong(idCnh.getText().toString()));
        veiculo.put("Proprietario", user.getUid());

        db.collection("Veiculo")
                .add(veiculo)
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