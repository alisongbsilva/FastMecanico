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
import java.util.ArrayList;


public class MainActivity<arrayAdapter> extends AppCompatActivity {
//Criando Botao e linkando a  tela cadastrar
@Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
    getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
    getSupportActionBar().setTitle("Fast Mecanico");     //Titulo para ser exibido na sua Action Bar em frente à seta

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

