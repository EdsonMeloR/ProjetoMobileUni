package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import com.example.projetomobile.dao.ProdutoDAO;
import com.example.projetomobile.dao.model.Produto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListLojaActivity extends AppCompatActivity {

    public ListView lstViewProd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_loja);
        lstViewProd = findViewById(R.id.lstview_loja);


        ArrayList<Produto> ArraylistProdutos = new ArrayList<Produto>();

        List<Produto> listProduto = new ArrayList<Produto>();
        ProdutoDAO pd = new ProdutoDAO(this);
        listProduto = pd.obterTodos();
        ArraylistProdutos.addAll(listProduto);

        ProdutoAdapter adpter = new ProdutoAdapter(this,ArraylistProdutos);

        lstViewProd.setAdapter(adpter);
        lstViewProd.setClickable(true);

        lstViewProd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ListLojaActivity.this,ArraylistProdutos.get(position).getNome(),Toast.LENGTH_LONG).show();
                int pos = position;
                Intent it = new Intent(getApplicationContext(),FinalizarCompraActivity.class);
                it.putExtra("idProduto",ArraylistProdutos.get(pos).getId());
                startActivity(it);
            }
        });
    }
}