package com.example.galois_dut_sistemas.molde1_android.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.galois_dut_sistemas.molde1_android.model.Estado;

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

        //Cria as tabelas
        banco.onCreate(db);


        valores = new ContentValues();
        valores.put(Constantes.NOME_ESTADO, nome);
        valores.put(Constantes.SIGLA, sigla);

        resultado = db.insert(Constantes.TABELA_ESTADOS, null, valores);
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

    public Cursor consultaEstadoPorId(Long id){

        //Retorna dos IDs e dos Titulos
        String[] campos =  {Constantes.ID_ESTADO,Constantes.ID_ESTADO};
        db = banco.getReadableDatabase();
        cursor = db.query(Constantes.TABELA_ESTADOS, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;

    }

    public Cursor carregaEstados(){

        //Retorna dos IDs e dos Titulos
        String[] campos =  {Constantes.ID_ESTADO,Constantes.NOME_ESTADO};

        db = banco.getReadableDatabase();
        cursor = db.query(Constantes.TABELA_ESTADOS, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        //db.close();
        return cursor;
    }

    public Cursor consultaEstadoPeloMunicipio(Long id){
        Cursor cursor ,cursor2;

        //EXEMPLO COM SUBCONSULTA SQL
        db = banco.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM estados join municipios WHERE estados._id = (SELECT fk_estado_id FROM municipios WHERE municipios._id = ? )  group by nome_estado\n order by nome_estado", new String[]{"" + id});

        if(cursor!=null){
            cursor.moveToFirst();
        }
        //db.close();
        return cursor;

    }

}
