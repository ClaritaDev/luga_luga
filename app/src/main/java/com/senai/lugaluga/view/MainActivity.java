package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;
import com.senai.lugaluga.view.adapter.AdapterProduto;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView.findViewById(R.id.listaProdutos);

    }

    public void CriarListaProdutos{
        Produto produto = new Produto("Iphone 13", "Iphone 13 64gb", 2000.00,"Disponivel",  10);
    }
    }
