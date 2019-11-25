package MPT.mpt.Aplicacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import MPT.mpt.R;

public class Principal extends AppCompatActivity {

    ImageButton ib_cupom;// =(ImageButton) findViewById(R.id.ib_cupom);
    ImageButton ib_produto;// =(ImageButton) findViewById(R.id.ib_produto);
    ImageButton ib_mercado;// =(ImageButton) findViewById(R.id.ib_mercado);
    ImageButton ib_pesquisa;// =(ImageButton) findViewById(R.id.ib_pesquisa);
    ImageButton ib_carrinho;// =(ImageButton) findViewById(R.id.ib_carrinho);
    ImageButton ib_home;// =(ImageButton) findViewById(R.id.ib_home);
    Intent it_trocaTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ib_cupom = (ImageButton) findViewById(R.id.ib_cupom);
        ib_produto = (ImageButton) findViewById(R.id.ib_produto);
        ib_mercado = (ImageButton) findViewById(R.id.ib_mercado);
        ib_pesquisa = (ImageButton) findViewById(R.id.ib_pesquisa);
        ib_carrinho = (ImageButton) findViewById(R.id.ib_carrinho);
        ib_home = (ImageButton) findViewById(R.id.ib_home);


        //ib_cupom = findViewById(R.id.ib_cupom);
        //ib_produto = findViewById(R.id.ib_produto);
        //ib_mercado = findViewById(R.id.ib_mercado);data
        //ib_pesquisa = findViewById(R.id.ib_pesquisa);
        //ib_carrinho = findViewById(R.id.ib_carrinho);
        //ib_home = findViewById(R.id.ib_home);

    }


    public void onClick_ib_cupom (View v) {
        Intent it_trocaTela = new Intent(Principal.this, Tela001.class);
        startActivity(it_trocaTela);
    };

    public void onClick_ib_produto (View v) {
        Intent it_trocaTela = new Intent(Principal.this, Tela002.class);
        startActivity(it_trocaTela);
    };

    public void onClick_ib_mercado (View v) {
        Intent it_trocaTela = new Intent(Principal.this, Tela003.class);
        startActivity(it_trocaTela);
    };

    public void onClick_ib_home (View v) {
        Toast.makeText(this, "Você já esta nesta pagina!", Toast.LENGTH_SHORT).show();
    };

    public void onClick_ib_pesquisa (View v) {
        Intent it_trocaTela = new Intent(Principal.this, Tela004.class);
        startActivity(it_trocaTela);
    };

    public void onClick_ib_carrinho (View v) {
        Intent it_trocaTela = new Intent(Principal.this, Tela005.class);
        startActivity(it_trocaTela);
    };



}

