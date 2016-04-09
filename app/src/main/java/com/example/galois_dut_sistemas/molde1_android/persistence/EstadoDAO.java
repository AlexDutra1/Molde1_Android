package com.example.galois_dut_sistemas.molde1_android.persistence;

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
}
