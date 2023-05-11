package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetomobile.dao.ProdutoDAO;
import com.example.projetomobile.dao.model.Produto;

public class CadastrarProdutoActivity extends AppCompatActivity {
    public EditText edtId, edtNome, edtValor, edtFabricante, edtCodBarras, edtQuantidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_produto);

        edtId = findViewById(R.id.edt_id_frmcadproduto);
        edtNome = findViewById(R.id.edt_nome_frmcadproduto);
        edtValor = findViewById(R.id.edt_valor_frmcadprod);
        edtFabricante = findViewById(R.id.edt_fabricante_frmcadprod);
        edtCodBarras = findViewById(R.id.edt_codbarras_frmcadprod);
        edtQuantidade = findViewById(R.id.edt_quantidade_frmcadproduto);
    }

    public void btn_cadastrar_frmcadprod(View view){
        String nome = edtNome.getText().toString();
        Double valor = Double.parseDouble(edtValor.getText().toString());
        String fabricante = edtFabricante.getText().toString();
        String codBarras = edtCodBarras.getText().toString();
        Integer quantidade = Integer.parseInt(edtQuantidade.getText().toString());


        ProdutoDAO pd = new ProdutoDAO(this);
        Produto p = new Produto(0,nome,valor,codBarras,"sem foto",fabricante, quantidade);


        Long result = pd.insert(p);
        if(result > 0){
            Toast.makeText(this,"Cadastro realizado!!",Toast.LENGTH_LONG).show();
            edtId.setEnabled(true);
            edtId.setText(result.toString());
            edtId.setEnabled(false);
            edtFabricante.setEnabled(false);
            edtNome.setEnabled(false);
            edtValor.setEnabled(false);
            edtCodBarras.setEnabled(false);
            edtQuantidade.setEnabled(false);
        }else{
            Toast.makeText(this,"Erro ao cadastrar no banco!!",Toast.LENGTH_LONG).show();
        }

    }
}