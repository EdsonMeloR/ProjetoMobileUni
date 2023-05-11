package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_enter_frmcadloj(View view){
        Intent it = new Intent(getApplicationContext(),login.class);
        startActivity(it);
    }

    public void btn_client(View view){
        Intent it = new Intent(getApplicationContext(),ListLojaActivity.class);
        startActivity(it);
    }
}