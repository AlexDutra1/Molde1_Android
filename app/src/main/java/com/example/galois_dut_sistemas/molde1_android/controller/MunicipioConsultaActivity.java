package com.example.galois_dut_sistemas.molde1_android.controller;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.EditText;
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


        EditText consultaEstadoDoMunicipio = (EditText) findViewById(R.id.consultaEstadoDoMunicipio);

        //CARREGA O LISVIEW
        MunicipioDAO crud = new MunicipioDAO(getBaseContext());

        //A IDE ou a Persistencia pediu para Cursor ser final
        final Cursor cursor = crud.carregaMunicipios();

        //Campos que serão usados no cabeçalho das colunas
        String[] nomeCampos = new String[] { Constantes.NOME_MUNICIPIO};
        int[] idViews = new int[] { R.id.nomeMunicipio};

        //Monta um layout_municipios dentro do consulta_municipio
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.layout_municipios,cursor,nomeCampos,idViews, 0);

        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

    }


}
