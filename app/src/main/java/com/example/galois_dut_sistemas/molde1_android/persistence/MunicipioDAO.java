package com.example.galois_dut_sistemas.molde1_android.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.galois_dut_sistemas.molde1_android.model.Estado;
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

    public String insereDado(Municipio municipio){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();

        //Cria as tabelas
        banco.onCreate(db);

        valores = new ContentValues();
        valores.put(Constantes.ID_MUNICIPIO, municipio.getIdMunicipio());
        valores.put(Constantes.NOME_MUNICIPIO, municipio.getNome());
        valores.put(Constantes.MUNICIPIO_TEM_ESTADO, municipio.getEstado().getIdEstado());

        resultado = db.insert(Constantes.TABELA_MUNICIPIOS, null, valores);
        //resultado = db.insertOrThrow(Constantes.TABELA_MUNICIPIOS, null, valores);

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

    public Cursor carregaMunicipios(){

        //Retorna dos IDs e dos Titulos
        String[] campos =  {Constantes.ID_MUNICIPIO,Constantes.NOME_MUNICIPIO,Constantes.MUNICIPIO_TEM_ESTADO};

        db = banco.getReadableDatabase();

        Cursor cursor;
        cursor = db.query(Constantes.TABELA_MUNICIPIOS, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        //db.close();
        return cursor;
    }

    public Cursor carregaListaDeMunicipiosDoEstado(Long id){

        //Retorna dos IDs e dos Titulos
/*
        String[] campos =  {
                Constantes.NOME_MUNICIPIO};
*/
        //Consultar SQL PURA
        //SEM REGISTROS DUPLICADOS
        Cursor cursor;
        db = banco.getReadableDatabase();

        //cursor = db.query(Constantes.TABELA_MUNICIPIOS, campos, null, null, null, null, null, null);
        cursor = db.rawQuery("SELECT * FROM municipios join estados WHERE fk_estado_id = ? group by nome_municipio\n" +
                "order by nome_municipio", new String[] {""+id});

        if(cursor!=null){
            cursor.moveToFirst();
        }
        //db.close();
        return cursor;
    }


}
