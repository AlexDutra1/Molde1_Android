package com.example.galois_dut_sistemas.molde1_android.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by galois on 09/04/16.
 */
public class EstadoDAO {

    private SQLiteDatabase db;
    private CriaBanco banco;
    Cursor cursor;

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

    public Cursor carregaEstados(){

        //Retorna dos IDs e dos Titulos
        String[] campos =  {Constantes.ID_ESTADO,Constantes.NOME_ESTADO};
        db = banco.getReadableDatabase();
        cursor = db.query(Constantes.TABELA_ESTADOS, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
