package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetomobile.dao.ProdutoDAO;
import com.example.projetomobile.dao.model.Produto;

public class ConsultarProdutoActivity extends AppCompatActivity {
    public EditText edtId,edtNome,edtValor,edtFabricante,edtCodBarras, edtQuantidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar_produto);

        edtId = findViewById(R.id.edt_id_frmconsprod);
        edtNome = findViewById(R.id.edt_nome_frmconsprod);
        edtValor = findViewById(R.id.edt_valor_frmconsprod);
        edtFabricante = findViewById(R.id.edt_fabricante_frmconsprod);
        edtCodBarras = findViewById(R.id.edt_codbarras_frmconsprod);
        edtQuantidade = findViewById(R.id.edt_quantidade_frmconsprod);
    }
    public void btn_consultar_frmconsprod (View view){
        ProdutoDAO pd = new ProdutoDAO(this);
        Produto p = new Produto();
        Integer id = Integer.parseInt(edtId.getText().toString());
        p = pd.read(id);
        if(p.getId() > 0){
            edtId.setText(p.getId().toString());
            edtNome.setText(p.getNome());
            edtQuantidade.setText(p.getQuantidade().toString());
            edtValor.setText(String.valueOf(p.getValor()));
            edtFabricante.setText(p.getFabricante());
            edtCodBarras.setText(p.getCodBarras());
            edtNome.setEnabled(true);
            edtValor.setEnabled(true);
            edtFabricante.setEnabled(true);
            edtCodBarras.setEnabled(true);
            edtQuantidade.setEnabled(true);
        }
        else {
            Toast.makeText(this,"Não encontrado!!",Toast.LENGTH_LONG).show();
        }
    }
    public void btn_update_frmconsprod (View view){
        ProdutoDAO pd = new ProdutoDAO(this);
        Produto p = new Produto(Integer.parseInt(edtId.getText().toString()),edtNome.getText().toString(),Double.parseDouble(edtValor.getText().toString()),edtCodBarras.getText().toString(),"Sem foto",edtFabricante.getText().toString(),Integer.parseInt(edtQuantidade.getText().toString()));
        if(pd.update(p)){
            Toast.makeText(this,"Atualização feita com sucesso!!",Toast.LENGTH_LONG).show();
            edtNome.setEnabled(false);
            edtValor.setEnabled(false);
            edtFabricante.setEnabled(false);
            edtCodBarras.setEnabled(false);
            edtQuantidade.setEnabled(false);
        }
        else{
            Toast.makeText(this,"Atualização falhou!!",Toast.LENGTH_LONG).show();
        }
    }
}