package MPT.mpt.ViewHolders;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import MPT.mpt.DataPostgreSQL.produtoBD;
import MPT.mpt.R;
import MPT.mpt.dataSQLite.DAOProdutos;
import MPT.mpt.dataSQLite.Produto;

public class ProdutoViewHolder extends RecyclerView.ViewHolder{

    private TextView tv_bd_produto;
    private TextView tv_bd_mercado;
    private TextView tv_bd_preco;
    private TextView tv_bd_validade;
    private Produto produto;
    private ImageButton ib_adicionar;
    private Activity activity;


    public ProdutoViewHolder(View itemView, final Activity activity) {
        super(itemView);
        this.tv_bd_produto = itemView.findViewById(R.id.tv_bd_produto);
        this.tv_bd_mercado = itemView.findViewById(R.id.tv_bd_mercado);
        this.tv_bd_preco = itemView.findViewById(R.id.tv_bd_preco);
        this.tv_bd_validade = itemView.findViewById(R.id.tv_bd_validade);
        this.ib_adicionar = itemView.findViewById(R.id.ib_adicionar);
        this.activity = activity;
        this.ib_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAOProdutos.insertProduto(activity,produto);

            }
        });
    }

    public void bind(final Produto produto) {
        this.produto = produto;
        this.tv_bd_produto.setText(this.produto.getName());
        this.tv_bd_mercado.setText(this.produto.getMarket());
        this.tv_bd_preco.setText(Double.toString(this.produto.getPrice()));
        this.tv_bd_validade.setText(this.produto.getDate_promotion());

    }


}
