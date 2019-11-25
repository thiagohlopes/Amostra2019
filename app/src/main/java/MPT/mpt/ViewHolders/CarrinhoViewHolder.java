package MPT.mpt.ViewHolders;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import MPT.mpt.R;
import MPT.mpt.dataSQLite.DAOProdutos;
import MPT.mpt.dataSQLite.Produto;

public class CarrinhoViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    private TextView tv_bd_produto;
    private TextView tv_bd_mercado;
    private TextView tv_bd_preco;
    private TextView tv_bd_validade;
    private ImageButton ib_remover;
    private Produto produto;
    private String codigo;
    private Activity activity;
    private CarrinhoAdapter.OnClickProdutoListener listener;

    public CarrinhoViewHolder(View itemView, Activity activity) {
        super(itemView);
        this.tv_bd_produto = itemView.findViewById(R.id.tv_bd_produto);
        this.tv_bd_mercado = itemView.findViewById(R.id.tv_bd_mercado);
        this.tv_bd_preco = itemView.findViewById(R.id.tv_bd_preco);
        this.tv_bd_validade = itemView.findViewById(R.id.tv_bd_validade);
        this.ib_remover = itemView.findViewById(R.id.ib_adicionar);
        this.activity = activity;

        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bind(Produto produto) {
        this.produto = produto;
        this.tv_bd_produto.setText(this.produto.getName());
        this.tv_bd_mercado.setText(this.produto.getMarket());
        this.tv_bd_preco.setText(Double.toString(this.produto.getPrice()));
        this.tv_bd_validade.setText(this.produto.getDate_promotion());
        ib_remover.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DAOProdutos.execQueryProduto(activity,"remove from produto");
            }
        });
    }

    @Override
    public void onClick(View view) {
        this.listener.onClickProduto(this.produto);
    }
}
