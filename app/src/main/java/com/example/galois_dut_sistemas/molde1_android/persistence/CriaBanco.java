package com.example.galois_dut_sistemas.molde1_android.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by galois on 09/04/16.
 */
public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+Constantes.TABELA_ESTADOS+"("
                + Constantes.ID + " integer primary key autoincrement,"
                + Constantes.NOME + " text,"
                + Constantes.SIGLA + " text"
                +")";

        String sql2 = "CREATE TABLE "+Constantes.TABELA_MUNICIPIOS+"("
                + Constantes.ID + " integer primary key autoincrement,"
                + Constantes.NOME + " text"
                +")";

        db.execSQL(sql);
        db.execSQL(sql2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + Constantes.TABELA_ESTADOS);
        db.execSQL("DROP TABLE IF EXISTS" + Constantes.TABELA_MUNICIPIOS);
        onCreate(db);
    }
}
