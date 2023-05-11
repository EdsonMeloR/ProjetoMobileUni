package com.example.projetomobile.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;

import com.example.projetomobile.dao.model.Produto;
import com.example.projetomobile.util.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private ConnectionFactory conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO(Context context){
        //ConnectionFactory com o banco de dados
        conexao = new ConnectionFactory(context);
        banco = conexao.getWritableDatabase();
    }

    public long insert(Produto prod){
        ContentValues values = new ContentValues ();

        values.put("nome", prod.getNome());
        values.put("valor",prod.getValor());
        values.put("codigoBarras", prod.getCodBarras());
        values.put("nomeFoto", prod.getNomeFoto());
        values.put("fabricante", prod.getFabricante());
        values.put("quantidade",prod.getQuantidade());

        return(banco.insert("produtos",null,values));
    }
    //método alterar
    public boolean update(Produto prod) {
        ContentValues values = new ContentValues();
        values.put ("nome", prod.getNome());
        values.put("valor",prod.getValor());
        values.put("codigoBarras", prod.getCodBarras());
        values.put("nomeFoto", prod.getNomeFoto());
        values.put("fabricante", prod.getFabricante());
        values.put("quantidade",prod.getQuantidade());
        String args[] = {prod.getId().toString()};

        banco.update( "produtos", values, "id=?", args);

        return true;
    }

    // MÉTODO Excluir
    public boolean delete(Produto prod) {
        String args[] = {prod.getId().toString()};
        banco.delete("produtos", "id=?", args);

        return true;
    }

    //Read aluno
    public Produto read(int id) {
        Produto prod = new Produto();
        String args[] = {String.valueOf(id)};



        Cursor cursor = banco.rawQuery("SELECT id, nome, valor, fabricante,codigoBarras, nomeFoto, quantidade FROM produtos WHERE id=?",args);

        //Cursor cursor = banco.query("aluno", new String[]{"nome", "cpf", "telefone"},"id=?", args, null, null, null,null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            prod.setId(cursor.getInt(0));
            prod.setNome((cursor.getString(1)));
            prod.setValor((cursor.getDouble(2)));
            prod.setFabricante((cursor.getString(3)));
            prod.setCodBarras((cursor.getString(4)));
            prod.setNomeFoto((cursor.getString(5)));
            prod.setQuantidade((cursor.getInt(6)));

        }
        return prod;
    }

    public List<Produto> obterTodos() {
        List<Produto> prodList = new ArrayList<>();
        Cursor cursor = banco.query ("produtos", new String[]{"id", "nome" ,"valor","fabricante","codigoBarras","nomeFoto","quantidade"},null, null, null, null, null);
        while (cursor.moveToNext()) {
            Produto p = new Produto();
            p.setId(cursor.getInt(0));
            p.setNome((cursor.getString(1)));
            p.setValor((cursor.getDouble(2)));
            p.setFabricante((cursor.getString(3)));
            p.setCodBarras((cursor.getString(4)));
            p.setNomeFoto((cursor.getString(5)));
            p.setQuantidade((cursor.getInt(6)));
            prodList.add(p);
        }
        return prodList;
    }
}
