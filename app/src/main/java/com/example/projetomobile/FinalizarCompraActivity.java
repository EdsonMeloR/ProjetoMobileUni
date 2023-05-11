package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetomobile.dao.ProdutoDAO;
import com.example.projetomobile.dao.model.Produto;

public class FinalizarCompraActivity extends AppCompatActivity {
    public EditText edtQuantidade;
    public TextView tvNome, tvEstoque,tvPreco,tvFabricante,tvCodBar,tvValorFinal;

    public Produto p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalizar_compra);

        edtQuantidade = findViewById(R.id.edt_qtd_finshbuy);
        tvNome = findViewById(R.id.tv_finishbuy_nome);
        tvEstoque = findViewById(R.id.tv_finishbuy_qtd);
        tvPreco = findViewById(R.id.tv_finishbuy_preco);
        tvFabricante = findViewById(R.id.tv_finishbuy_fabric);
        tvCodBar = findViewById(R.id.tv_finishbuy_codbar);
        tvValorFinal = findViewById(R.id.tv_valor_final);

        Intent it = getIntent();
        int idProduto = it.getIntExtra("idProduto",0);

        ProdutoDAO pd = new ProdutoDAO(this);

        p = pd.read(idProduto);

        tvNome.setText(p.getNome());
        tvEstoque.setText(String.valueOf(p.getQuantidade()));
        tvPreco.setText(String.valueOf(p.getValor()));
        tvFabricante.setText(p.getFabricante());
        tvCodBar.setText(p.getCodBarras());
    }

    public void btnFinalizarCompra(View view){
        try {
            ProdutoDAO pd = new ProdutoDAO(this);
            double aux = Integer.parseInt(edtQuantidade.getText().toString()) * p.getValor();
            p.setQuantidade(p.getQuantidade() - Integer.parseInt(edtQuantidade.getText().toString()));
            pd.update(p);

            tvValorFinal.setText(String.valueOf(aux));

            int auxQtd = Integer.parseInt(tvEstoque.getText().toString()) - Integer.parseInt(edtQuantidade.getText().toString());

            tvEstoque.setText(String.valueOf(auxQtd));
            Toast.makeText(this,"Compra realizada",Toast.LENGTH_LONG);
        }
        catch (Exception e){
            Toast.makeText(this,"Erro",Toast.LENGTH_LONG);
        }
    }
}