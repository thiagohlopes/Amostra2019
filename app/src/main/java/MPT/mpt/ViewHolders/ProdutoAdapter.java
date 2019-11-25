package MPT.mpt.ViewHolders;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import MPT.mpt.DataPostgreSQL.produtoBD;
import MPT.mpt.R;
import MPT.mpt.dataSQLite.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoViewHolder> {

    private ArrayList<Produto> Produto;
    private Activity activity;

    public interface OnClickProdutoListener {
        void onClickProduto(Produto produto);
    }

    public ProdutoAdapter(ArrayList<Produto> Produto, Activity activity) {
        this.Produto = Produto;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_view_holder_produto, parent, false);
        ProdutoViewHolder viewHolder = new ProdutoViewHolder(itemView, activity);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        holder.bind(this.Produto.get(position));
    }

    @Override
    public int getItemCount() {
        if(this.Produto!=null)
        return this.Produto.size();
        else return 0;
    }
}
