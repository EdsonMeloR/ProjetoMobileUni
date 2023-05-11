package com.example.projetomobile.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class ConnectionFactory extends SQLiteOpenHelper {
    private static final String NAME = "banco.db";
    private static final int VERSION = 1;
    public ConnectionFactory(@Nullable Context context) {
        super(context, NAME, null, VERSION) ;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE lojistas (id integer primary key autoincrement, nome varchar (50),cpf varchar (11), email varchar(50),senha varchar(50))");
        db.execSQL("CREATE TABLE produtos (id integer primary key autoincrement, nome  varchar (50),valor decimal (10,2), fabricante  varchar (50),codigoBarras  varchar (50), nomeFoto VARCHAR(60), quantidade integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS lojistas; ";
        db.execSQL(sql);
        sql = "DROP TABLE IF EXISTS produto";
        db.execSQL(sql);
        onCreate(db);
    }
}