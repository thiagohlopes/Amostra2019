package MPT.mpt.Aplicacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import MPT.mpt.DataPostgreSQL.DB;
import MPT.mpt.R;
import MPT.mpt.ViewHolders.ProdutoAdapter;
import MPT.mpt.dataSQLite.Produto;

public class Tela003 extends AppCompatActivity implements ProdutoAdapter.OnClickProdutoListener{

    ImageButton ib_pesquisa;
    ImageButton ib_carrinho;
    ImageButton ib_home;
    TextView tv_prod_pesq;
    String comando = "";
    private RecyclerView rvProduto;
    private ProdutoAdapter produtoAdapter;
    Intent it_trocaTela;
    private DB banco;
    private String timeStamp;
    private ArrayList<Produto> lista;

    public static final String DATE_FORMAT_2 = "dd-MM-yyyy";

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_2);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela002);
        ib_pesquisa = findViewById(R.id.ib_pesquisa);
        ib_carrinho = findViewById(R.id.ib_carrinho);
        ib_home = findViewById(R.id.ib_home);

        timeStamp = getCurrentDate();
        tv_prod_pesq = findViewById(R.id.tv_prod_pesq);
        this.rvProduto = findViewById(R.id.rvProduto);

        banco = new DB();
        try {
            ResultSet resultSet = banco.select("SELECT produto.cod_produto, produto.marca ,produto.tipo ,produto.peso ,produto.caracteristicas ,produto.preco ,produto.qtd_estoque ,mercado.cod_mercado, mercado.nome_mercado  FROM produto natural join mercado");
            if (resultSet != null) {
                while (resultSet.next()) {
                    Produto obj = new Produto();
                    obj.setPrice(resultSet.getFloat("preco"));
                    obj.setAmount(1);
                    obj.setDate_promotion("24-11-2019");
                    obj.setId(resultSet.getInt("cod_produto"));
                    obj.setMarket(resultSet.getString("nome_mercado"));
                    obj.setName(resultSet.getString("tipo") + " " + resultSet.getString("marca"));
                    obj.setType(resultSet.getString("caracteristica"));
                    obj.setTimeStamp(timeStamp);
                    lista.add(obj);
                }
            }
        } catch (Exception ex) {

        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.rvProduto.setLayoutManager(layoutManager);
        this.rvProduto.setHasFixedSize(true);
        this.rvProduto.setAdapter(this.produtoAdapter);
        this.produtoAdapter = new ProdutoAdapter(lista, this);
    }

    public void onClick_ib_home(View v) {
        Intent it_trocaTela = new Intent(Tela003.this, Principal.class);
        startActivity(it_trocaTela);
    }

    ;

    public void onClick_ib_pesquisa(View v) {
        Intent it_trocaTela = new Intent(Tela003.this, Tela004.class);
        startActivity(it_trocaTela);
    }

    ;

    public void onClick_ib_carrinho(View v) {
        Intent it_trocaTela = new Intent(Tela003.this, Tela005.class);
        startActivity(it_trocaTela);
    }

    ;

    public void onClick_ib_search(View v) {
        EditText editText = findViewById(R.id.tv_prod_pesq);
        String busca = editText.getText().toString();
        if (!busca.isEmpty()) {
            try {
                ResultSet resultSet = banco.select("SELECT produto.cod_produto, produto.marca ,produto.tipo ,produto.peso ,produto.caracteristicas ,produto.preco ,produto.qtd_estoque ,mercado.cod_mercado, mercado.nome_mercado  FROM produto natural join mercado where mercado.nome_mercado='" + busca+"'");
                if (resultSet != null) {
                    while (resultSet.next()) {
                        Produto obj = new Produto();
                        obj.setPrice(resultSet.getFloat("preco"));
                        obj.setAmount(1);
                        obj.setDate_promotion("24-11-2019");
                        obj.setId(resultSet.getInt("cod_produto"));
                        obj.setMarket(resultSet.getString("nome_mercado"));
                        obj.setName(resultSet.getString("tipo") + " " + resultSet.getString("marca"));
                        obj.setType(resultSet.getString("caracteristica"));
                        obj.setTimeStamp(timeStamp);
                        lista.add(obj);
                    }
                }
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(),"Erro ao buscar produto",Toast.LENGTH_SHORT).show();

            }
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.rvProduto.setLayoutManager(layoutManager);
        this.rvProduto.setHasFixedSize(true);
        this.produtoAdapter = new ProdutoAdapter(lista, this);
        this.rvProduto.setAdapter(this.produtoAdapter);

    }

    ;


    @Override
    public void onClickProduto(Produto produto) {

    }
}
