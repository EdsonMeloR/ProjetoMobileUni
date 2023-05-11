package com.example.projetomobile.dao;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;

import com.example.projetomobile.dao.model.Lojista;
import com.example.projetomobile.dao.model.Produto;
import com.example.projetomobile.util.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;

public class LojistaDAO {
    private ConnectionFactory conexao;
    private SQLiteDatabase banco;

    public LojistaDAO(Context context){
        //ConnectionFactory com o banco de dados
        conexao = new ConnectionFactory(context);
        banco = conexao.getWritableDatabase();
    }

    public Integer login(String CPF, String Senha){
        Lojista lojista = new Lojista();
        String args[] = {CPF,Senha};

        Cursor cursor = banco.rawQuery("SELECT id FROM lojistas WHERE cpf=? AND senha=?",args);

        //Cursor cursor = banco.query("aluno", new String[]{"nome", "cpf", "telefone"},"id=? ", args, null, null, null,null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            return cursor.getInt(0);
        }
        else return 0;
    }

    public long insert(Lojista loj){
        ContentValues values = new ContentValues ();

        values.put("nome", loj.getNome());
        values.put("cpf",loj.getCpf());
        values.put("email", loj.getEmail());
        values.put("senha", loj.getSenha());

        return(banco.insert("lojistas",null,values));
    }
    //método alterar
    public boolean update(Lojista loj) {
        ContentValues values = new ContentValues();
        values.put("nome", loj.getNome());
        values.put("cpf",loj.getCpf());
        values.put("email", loj.getEmail());
        values.put("senha", loj.getSenha());
        String args[] = {loj.getId().toString()};

        banco.update( "lojistas", values, "id=?", args);

        return true;
    }

    // MÉTODO Excluir
    public boolean delete(Lojista loj) {
        String args[] = {loj.getId().toString()};
        banco.delete("lojistas", "id=?", args);

        return true;
    }

    //Read Loj by CPF
    public Lojista readByCpf(String cpf) {
        Lojista loj = new Lojista();
        String args[] = {cpf};

        Cursor cursor = banco.rawQuery("SELECT id, nome, cpf, email, senha FROM lojistas WHERE cpf=?",args);

        //Cursor cursor = banco.query("produto", new String[]{"nome", "cpf", "telefone"},"cpf=?", args, null, null, null,null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            loj.setId(cursor.getInt(0));
            loj.setNome((cursor.getString(1)));
            loj.setCpf((cursor.getString(2)));
            loj.setEmail((cursor.getString(3)));
            loj.setSenha((cursor.getString(4)));
        }
        return loj;
    }
    //Read Loj by ID

    public Lojista read(int id) {
        Lojista loj = new Lojista();
        String args[] = {String.valueOf(id)};

        Cursor cursor = banco.rawQuery("SELECT id, nome, cpf, email, senha FROM lojistas WHERE id=?",args);

        //Cursor cursor = banco.query("aluno", new String[]{"nome", "cpf", "telefone"},"id=?", args, null, null, null,null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            loj.setId(cursor.getInt(0));
            loj.setNome((cursor.getString(1)));
            loj.setCpf((cursor.getString(2)));
            loj.setEmail((cursor.getString(3)));
            loj.setSenha((cursor.getString(4)));
        }
        return loj;
    }

    public List<Lojista> obterTodos() {
        List<Lojista> LojList = new ArrayList<>();
        Cursor cursor = banco.query ("lojistas", new String[]{"id", "nome" ,"cpf","email","senha"},null, null, null, null, null);
        while (cursor.moveToNext()) {
            Lojista l = new Lojista();
            l.setId(cursor.getInt(0));
            l.setNome((cursor.getString(1)));
            l.setCpf((cursor.getString(2)));
            l.setEmail((cursor.getString(3)));
            l.setSenha((cursor.getString(4)));
            LojList.add(l);
        }
        return LojList;
    }
}
