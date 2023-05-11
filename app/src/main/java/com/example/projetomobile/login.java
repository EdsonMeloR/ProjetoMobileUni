package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetomobile.dao.LojistaDAO;
import com.example.projetomobile.dao.model.Lojista;

import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity {
    public EditText edtCpf, edtSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtCpf = findViewById(R.id.edt_cpf_frmlogin);
        edtSenha = findViewById(R.id.edt_senha_frmlogin);
        LojistaDAO ld = new LojistaDAO(this);
        List<Lojista> listofLojista = new ArrayList<Lojista>();
        if(listofLojista.isEmpty()){
            Intent it = new Intent(getApplicationContext(),CadastrarLojistaActivity.class);
            startActivity(it);
        }
    }

    public void btn_login_frmlogin (View view){
        String cpf = edtCpf.getText().toString();
        String senha = edtSenha.getText().toString();

        LojistaDAO ld = new LojistaDAO(this);
        if(ld.login(cpf,senha) > 0){
            Intent it = new Intent(getApplicationContext(), DashboardLoggedActivity.class);
            startActivity(it);
        }
        else{
            Toast.makeText(this,"Login incorreto",Toast.LENGTH_LONG).show();
        }
    }
}