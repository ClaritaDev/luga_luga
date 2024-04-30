package com.senai.lugaluga.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;

import java.util.List;

public class AdapterProduto extends RecyclerView.Adapter<AdapterProduto.ViewHolder> {

    private List<Produto> produtolist;

    public AdapterProduto(List<Produto> produtolist) {
        this.produtolist = produtolist;
    }

    @NonNull
    @Override
    public AdapterProduto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View ListaProdutos = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produto,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduto.ViewHolder holder, int position) {

    holder.nomeProd.setText(produtolist.get(position).getNome());
    holder.precoProd.setText(String.valueOf(produtolist.get(position).getPreco()));
    holder.descProd.setText(produtolist.get(position).getDescricao());

    }


    @Override
    public int getItemCount() {
        return produtolist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nomeProd, precoProd, descProd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProd = itemView.findViewById(R.id.tv_nomeProduto);
            precoProd = itemView.findViewById(R.id.tv_preco);
            descProd = itemView.findViewById(R.id.tv_descricao);
        }
    }
}
