package com.example.galois_dut_sistemas.molde1_android.controller;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;

import com.example.galois_dut_sistemas.molde1_android.R;
import com.example.galois_dut_sistemas.molde1_android.persistence.Constantes;
import com.example.galois_dut_sistemas.molde1_android.persistence.MunicipioDAO;

/**
 * Created by galois on 13/04/16.
 */
public class MunicipioConsultaActivity extends Activity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_municipio);

/*

        MunicipioDAO crud = new MunicipioDAO(getBaseContext());

        //A IDE ou a Persistencia pediu para Cursor ser final
        final Cursor cursor = crud.carregaEstados();

        String[] nomeCampos = new String[] {Constantes.ID, Constantes.NOME_MUNICIPIO};
        int[] idViews = new int[] {R.id.idMunicipio, R.id.nomeMunicipio};

        //NECESSARIO FAZER O UPDGRADE DA API PARA USAR O SimpleCursorAdapter'
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.consulta_municipio,cursor,nomeCampos,idViews, 0);

        lista = (ListView)findViewById(R.id.listView);
        //  lista.setAdapter(adaptador);
*/




    }
}