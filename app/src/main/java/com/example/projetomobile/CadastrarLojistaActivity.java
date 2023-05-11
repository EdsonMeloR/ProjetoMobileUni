package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetomobile.dao.LojistaDAO;
import com.example.projetomobile.dao.model.Lojista;

public class CadastrarLojistaActivity extends AppCompatActivity {
    public EditText edtId,edtCpf,edtEmail,edtSenha, edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_lojista);

        edtId = findViewById(R.id.edt_id_frmcadloj);
        edtCpf = findViewById(R.id.edt_cpf_frmcadloj);
        edtEmail = findViewById(R.id.edt_email_frmcadloj);
        edtSenha = findViewById(R.id.edt_senha_frmcadloj);
        edtNome = findViewById(R.id.edt_nome_frmcadloj);
    }
    public void btn_cadastrar_frmcadloj(View view){
        String cpf = edtCpf.getText().toString();
        String senha = edtSenha.getText().toString();
        String email = edtEmail.getText().toString();
        String nome = edtNome.getText().toString();

        LojistaDAO ld = new LojistaDAO(this);
        Lojista l = new Lojista(0,nome,cpf,email,senha);
        Long result = ld.insert(l);
        if(result > 0){
            Toast.makeText(this,"Cadastro feito!!",Toast.LENGTH_LONG).show();
            edtId.setText(result.toString());
        }
        else{
            Toast.makeText(this,"Falha no cadastro!!",Toast.LENGTH_LONG).show();
        }
    }
}