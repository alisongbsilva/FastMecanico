package com.example.fastmecanico;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity<arrayAdapter> extends AppCompatActivity {
//Criando Botao e linkando a  tela cadastrar
    private FirebaseAuth mAuth;
    private int RC_SIGN_IN = 1;

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.bemvindo_main);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
    getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
    getSupportActionBar().setTitle("Fast Mecanico");     //Titulo para ser exibido na sua Action Bar em frente à seta

    mAuth = FirebaseAuth.getInstance();

}

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

//List view para a tela de demandas

    private ArrayList<String>preencherdados(){
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("dados");
        return dados;
    }




// Botoes para voltar a tela de inicio
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android.
                startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão.
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, MainActivity.class)); //O efeito ao ser pressionado do botão
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
//conexao dos botoes às telas
    public void chamacadastro (View v){setContentView(R.layout.cadastrodeusuario);}//botao para cadastrar
    public void chamatelaveiculo (View v){ setContentView(R.layout.cadastrodeveiculo); }//botao de cadastro para cadastrar veiculo
    public void salvaevolta(View v) {setContentView(R.layout.bemvindo_main);}//vai salvar no banco e retornar a tela inicial
    public void esqueci (View v){ setContentView(R.layout.recuperarsenha); }// vai enviar a senha para o email cadastrado
    public void verdemanda(View v){setContentView(R.layout.telademanda);}
    public void abrirdemanda(View v){setContentView(R.layout.solicitacaodeatendimento);}
    public void altera (View v){setContentView(R.layout.cadastrodeusuario);}


}

