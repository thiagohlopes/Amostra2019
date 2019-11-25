package MPT.mpt.Aplicacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import MPT.mpt.R;
import MPT.mpt.ViewHolders.CarrinhoAdapter;
import MPT.mpt.ViewHolders.ProdutoAdapter;
import MPT.mpt.dataSQLite.DAOProdutos;
import MPT.mpt.dataSQLite.Produto;

public class Tela005 extends AppCompatActivity implements CarrinhoAdapter.OnClickProdutoListener {

    ImageButton ib_pesquisa;
    ImageButton ib_carrinho;
    ImageButton ib_home;
    private RecyclerView rvProduto;
    private CarrinhoAdapter carrinhoAdapter;
    Intent it_trocaTela;
    private ArrayList <Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela005);
        ib_pesquisa = findViewById(R.id.ib_pesquisa);
        ib_carrinho = findViewById(R.id.ib_carrinho);
        ib_home = findViewById(R.id.ib_home);
        this.rvProduto = findViewById(R.id.rvProduto);
        produtos= DAOProdutos.getAllProdutos(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.rvProduto.setLayoutManager(layoutManager);
        this.rvProduto.setHasFixedSize(true);
        this.carrinhoAdapter = new CarrinhoAdapter(produtos, this);
        this.rvProduto.setAdapter(this.carrinhoAdapter);

    }

    public void onClick_ib_home (View v) {
        Intent it_trocaTela = new Intent(Tela005.this, Principal.class);
        startActivity(it_trocaTela);
    };

    public void onClick_ib_pesquisa (View v) {
        Intent it_trocaTela = new Intent(Tela005.this, Tela004.class);
        startActivity(it_trocaTela);
    };

    public void onClick_ib_carrinho (View v) {
        Toast.makeText(this, "Você já esta nesta pagina!", Toast.LENGTH_SHORT).show();
    };

    @Override
    public void onClickProduto(Produto produto) {

    }
}
