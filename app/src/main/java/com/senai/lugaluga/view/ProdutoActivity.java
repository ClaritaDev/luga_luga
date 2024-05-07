package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nome, quantidade, preco, descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);


        nome = findViewById(R.id.nomeProdutoTv);
        quantidade = findViewById(R.id.qtd);
        preco = findViewById(R.id.tv_preco);
        descricao = findViewById(R.id.tv_descricao);

        produto = getIntent().getExtras().getParcelable("produto");

        nome.setText(produto.getNome());
        quantidade.setText(produto.getQuantidade());
        preco.setText(String.valueOf(produto.getPreco()));
        descricao.setText((produto.getDescricao()));

    }
}