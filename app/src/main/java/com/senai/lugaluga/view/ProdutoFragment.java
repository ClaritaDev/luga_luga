package com.senai.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.senai.lugaluga.R;
import com.senai.lugaluga.RecyclerItemClickListener;
import com.senai.lugaluga.controller.ProdutosController;
import com.senai.lugaluga.model.Produto;
import com.senai.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProdutoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProdutoFragment extends Fragment {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();

    public ProdutoFragment() {
        // Required empty public constructor
    }

    public static ProdutoFragment newInstance(String param1, String param2) {
        ProdutoFragment fragment = new ProdutoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produto, container, false);

        recyclerView = view.findViewById(R.id.listaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(getContext(), ProdutoActivity.class);
                intent.putExtra("produto", produtoList.get(position));
                startActivity(intent);

            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getContext(), produtoList.get(position).getStatus(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

        return view;

    }

    public void CriarListaProdutos() {
        ProdutosController produtosController = new ProdutosController(getContext());
        produtoList.addAll(produtosController.carregaProdutos());
    }
};