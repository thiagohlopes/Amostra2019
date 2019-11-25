package MPT.mpt.ViewHolders;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import MPT.mpt.R;
import MPT.mpt.dataSQLite.Produto;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoViewHolder> {

    private ArrayList<Produto> produto;
    private Activity activity;
    private String codigo;

    public interface OnClickProdutoListener {
        void onClickProduto(Produto produto);
    }

    public CarrinhoAdapter(ArrayList<Produto> produto, Activity activity) {
        this.produto = produto;
        this.activity = activity;

    }

    @NonNull
    @Override
    public CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_view_holder_carrinho, parent, false);
        CarrinhoViewHolder viewHolder = new CarrinhoViewHolder(itemView, activity);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder holder, int position) {
        holder.bind(this.produto.get(position));
    }

    @Override
    public int getItemCount() {
        return this.produto.size();
    }
}
