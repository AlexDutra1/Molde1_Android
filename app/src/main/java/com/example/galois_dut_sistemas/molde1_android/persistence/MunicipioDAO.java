package com.example.galois_dut_sistemas.molde1_android.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.galois_dut_sistemas.molde1_android.model.Municipio;

/**
 * Created by galois on 11/04/16.
 */
public class MunicipioDAO {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public MunicipioDAO(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(String nome){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(Constantes.NOME, nome);

        resultado = db.insertOrThrow(Constantes.TABELA_MUNICIPIOS, null, valores);

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
