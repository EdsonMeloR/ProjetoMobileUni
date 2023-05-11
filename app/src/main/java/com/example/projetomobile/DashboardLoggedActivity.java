package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardLoggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_logged);
    }

    public void btn_enter_frmcadprod(View view){
        Intent it = new Intent(getApplicationContext(),CadastrarProdutoActivity.class);
        startActivity(it);
    }
    public void btn_enter_frmconsprod(View view){
        Intent it = new Intent(getApplicationContext(),ConsultarProdutoActivity.class);
        startActivity(it);
    }

    public void btn_enter_frmcadloji(View view){
        Intent it = new Intent(getApplicationContext(),CadastrarLojistaActivity.class);
        startActivity(it);
    }
    public void btn_enter_consloji(View view){
        Intent it = new Intent(getApplicationContext(),ConsultarLojistaActivity.class);
        startActivity(it);
    }
}