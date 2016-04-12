package com.example.galois_dut_sistemas.molde1_android.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by galois on 09/04/16.
 */
public class EstadoDAO {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public EstadoDAO(Context context){
        banco = new CriaBanco(context);
    }


    public String insereDado(String nome, String sigla){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(Constantes.NOME_ESTADO, nome);
        valores.put(Constantes.SIGLA, sigla);

        resultado = db.insertOrThrow(Constantes.TABELA_ESTADOS, null, valores);

        db.close();

        if (resultado ==-1)
        {
            return "Erro ao inserir registro";
        }

        else
        {
            return "Registro Inserido com sucesso ";
        }
    }

}
