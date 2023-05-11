package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetomobile.dao.LojistaDAO;
import com.example.projetomobile.dao.model.Lojista;

public class ConsultarLojistaActivity extends AppCompatActivity {
    public EditText edtId,edtCpf,edtNome,edtSenha,edtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar_lojista);
        edtId = findViewById(R.id.edt_id_frmconloj);
        edtCpf = findViewById(R.id.edt_cpf_frmconloj);
        edtNome = findViewById(R.id.edt_nome_frmconloj);
        edtSenha = findViewById(R.id.edt_senha_frmconloj);
        edtEmail = findViewById(R.id.edt_email_frmconloj);

    }

    public void btn_consultar_frmconloj (View view){
        Lojista l = new Lojista();
        String cpf = edtCpf.getText().toString();
        LojistaDAO ld = new LojistaDAO(this);

        l = ld.readByCpf(cpf);
        if(l.getId() > 0){
            edtId.setEnabled(true);
            edtId.setText(l.getId().toString());

            edtCpf.setText(l.getCpf());

            edtNome.setEnabled(true);
            edtNome.setText(l.getNome());

            edtSenha.setEnabled(true);
            edtSenha.setText(l.getSenha());

            edtEmail.setEnabled(true);
            edtEmail.setText(l.getEmail());

            edtId.setEnabled(false);
            edtCpf.setEnabled(false);
        }
    }
    public void btn_update_frmconloj(View view){
        LojistaDAO ld = new LojistaDAO(this);
        Lojista l = new Lojista();
        l.setId(Integer.parseInt(edtId.getText().toString()));
        l.setCpf(edtCpf.getText().toString());
        l.setNome(edtNome.getText().toString());
        l.setSenha(edtSenha.getText().toString());
        l.setEmail(edtEmail.getText().toString());
        if(ld.update(l)){
            Toast.makeText(this,"Atualizado com sucesso!!",Toast.LENGTH_LONG).show();
            edtEmail.setEnabled(false);
            edtSenha.setEnabled(false);
            edtNome.setEnabled(false);
            edtCpf.setEnabled(true);
        }
        else{
            Toast.makeText(this,"Falha na atualização!!",Toast.LENGTH_LONG).show();
        }
    }
}