package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


import com.senai.lugaluga.R;
import com.senai.lugaluga.RecyclerItemClickListener;
import com.senai.lugaluga.model.Produto;
import com.senai.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listaProdutos);

        CriarListaProdutos();

        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(mToolbar);

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                intent.putExtra("produto",produtoList.get(position));
                startActivity(intent);

            }
             @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),produtoList.get(position).getStatus(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

    }



    public void CriarListaProdutos(){
        Produto produto;

        produto = new Produto("Iphone 13",
                "Iphone 13 64gb",
                2000.00,
                "Disponivel",
                10);
        produtoList.add(produto);

        produto = new Produto("Fone",
                "Bluetooth",
                50.00,
                "Disponivel",
                26);
        produtoList.add(produto);

        produto = new Produto("Carregador",
                "Com fio usb",
                26.00,
                "Disponivel",
                20);
        produtoList.add(produto);

        produto = new Produto("Notebook",
                "Samsung",
                200.00,
                "Disponivel",
                13);
        produtoList.add(produto);

        produto = new Produto("Mesa",
                "Madeira, com 4 pés",
                400.00,
                "Disponivel",
                5);
        produtoList.add(produto);

        produto = new Produto("Furadeira",
                "5 brocas 220V",
                50.00,
                "Disponivel",
                3);
        produtoList.add(produto);

        produto = new Produto("Carro",
                "Fiat 500 elétrico",
                1000.00,
                "Disponivel",
                2);
        produtoList.add(produto);

        produto = new Produto("Bicicleta",
                "Aro 29",
                100.00,
                "Indisponível",
                0);
        produtoList.add(produto);

        produto = new Produto("Jogo RPG",
                "Jogo the witcher",
                50.00,
                "Disponivel",
                1);
        produtoList.add(produto);

        produto = new Produto("Barraca",
                "1 cômodo de 5m2",
                40.00,
                "Disponivel",
                5);
        produtoList.add(produto);
    }
    }
