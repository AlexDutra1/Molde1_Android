package com.example.galois_dut_sistemas.molde1_android.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by galois on 09/04/16.
 */
public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final int VERSAO = 2;

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    String sql = "CREATE TABLE IF NOT EXISTS "+Constantes.TABELA_ESTADOS+"("
                + Constantes.ID_ESTADO + " integer primary key autoincrement,"
                + Constantes.NOME_ESTADO + " text,"
                + Constantes.SIGLA + " text"
                +")";

        db.execSQL(sql);
        System.out.println("STRING SQL2: " + sql);

        //TENTATIVA DE RELACIONAMENTO
        String sql2 = "CREATE TABLE IF NOT EXISTS "+Constantes.TABELA_MUNICIPIOS+"("
                + Constantes.ID_MUNICIPIO + " integer primary key autoincrement,"
                + Constantes.NOME_MUNICIPIO + " text,"
                + ""+Constantes.MUNICIPIO_TEM_ESTADO+" integer,"
                + "foreign key ("+Constantes.MUNICIPIO_TEM_ESTADO+") references "+Constantes.TABELA_ESTADOS+" ("+Constantes.ID_ESTADO+")"
                +")";

        db.execSQL(sql2);
        System.out.println("STRING SQL2: " + sql2);

    }


    //SO LIMPA A TABELA SE ALTERAR A VERSAO
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABELA_ESTADOS);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABELA_MUNICIPIOS);
        onCreate(db);
    }
}
