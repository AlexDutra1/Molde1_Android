package com.example.galois_dut_sistemas.molde1_android.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.galois_dut_sistemas.molde1_android.model.Endereco;

/**
 * Created by galois on 29/04/16.
 */
public class EnderecoDAO {
    private SQLiteDatabase db;
    private CriaBanco banco;
    Cursor cursor;

    public EnderecoDAO(Context context){
        banco = new CriaBanco(context);
    }


    public String insereDado(Endereco endereco){

        ContentValues valores;
        long resultado;



        db = banco.getWritableDatabase();

        //Cria as tabelas
        banco.onCreate(db);


        valores = new ContentValues();
        valores.put(Constantes.ID_ENDERECO, endereco.getIdEndereco());
        valores.put(Constantes.LAGRADOURO_ENDERECO, endereco.getLagradouro());
        valores.put(Constantes.BAIRRO_ENDERECO, endereco.getBairro());
        valores.put(Constantes.ENDERECO_TEM_ESTADO, endereco.getEstado().getIdEstado());
        valores.put(Constantes.ENDERECO_TEM_MUNICIPIO, endereco.getMunicipio().getIdMunicipio());


        resultado = db.insert(Constantes.TABELA_ENDERECOS, null, valores);
        //resultado = db.insertOrThrow(Constantes.TABELA_ESTADOS, null, valores);
        //long resultado = db.insert("viagem", null, values);

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

    public Cursor consultaEndereco(Endereco endereco){
        Cursor cursor ,cursor2;

        //EXEMPLO COM SUBCONSULTA SQL
        db = banco.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM enderecos WHERE lagradouro = ? group by lagradouro\n order by lagradouro", new String[]{"" + endereco.getLagradouro()});

        if(cursor!=null){
            cursor.moveToFirst();
        }
        //db.close();
        return cursor;

    }



}
