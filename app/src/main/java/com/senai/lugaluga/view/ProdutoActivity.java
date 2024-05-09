package com.senai.lugaluga.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nome, quantidade, preco, descricao;

    private Button alugaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        nome = findViewById(R.id.nomeProdutoTv);
        quantidade = findViewById(R.id.qtd);
        preco = findViewById(R.id.precoProduto);
        descricao = findViewById(R.id.descricaoTv);

        alugaBtn = findViewById(R.id.alugaBtn);

        produto = getIntent().getExtras().getParcelable("produto");

        nome.setText(produto.getNome());
        quantidade.setText(String.valueOf(produto.getQuantidade()));
        preco.setText(String.valueOf(produto.getPreco()));
        descricao.setText((produto.getDescricao()));

        alugaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProdutoActivity.this);
                builder.setMessage("Deseja realmente alugar este produto?");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Concluído", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}