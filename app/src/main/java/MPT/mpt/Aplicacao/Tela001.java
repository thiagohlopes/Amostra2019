package MPT.mpt.Aplicacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import MPT.mpt.R;

public class Tela001 extends AppCompatActivity {

    ImageButton ib_pesquisa;
    ImageButton ib_carrinho;
    ImageButton ib_home;
    Intent it_trocaTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela001);
        ib_pesquisa = findViewById(R.id.ib_pesquisa);
        ib_carrinho = findViewById(R.id.ib_carrinho);
        ib_home = findViewById(R.id.ib_home);
    }


    public void onClick_ib_home (View v) {
        Intent it_trocaTela = new Intent(Tela001.this, Principal.class);
        startActivity(it_trocaTela);
    };

    public void onClick_ib_pesquisa (View v) {
        Intent it_trocaTela = new Intent(Tela001.this, Tela004.class);
        startActivity(it_trocaTela);
    };

    public void onClick_ib_carrinho (View v) {
        Intent it_trocaTela = new Intent(Tela001.this, Tela005.class);
        startActivity(it_trocaTela);
    };
}
