package com.example.galois_dut_sistemas.molde1_android.controller;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.galois_dut_sistemas.molde1_android.R;
import com.example.galois_dut_sistemas.molde1_android.persistence.Constantes;
import com.example.galois_dut_sistemas.molde1_android.persistence.EstadoDAO;
import com.example.galois_dut_sistemas.molde1_android.persistence.MunicipioDAO;
import com.example.galois_dut_sistemas.molde1_android.service_e_bo.EstadoServiceBO;
import com.example.galois_dut_sistemas.molde1_android.service_e_bo.MunicipioServiceBO;

/**
 * Created by galois on 13/04/16.
 */
public class MunicipioConsultaActivity extends Activity {

    private MunicipioServiceBO serviceBO;
    private MunicipioForm form=new MunicipioForm();
    private Spinner estadoSpinner3;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_municipio);
/*
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
        //FIM DO CARREGAMENTO DE LISTVIEW
*/



        //CARREGA ESTADOS NO SPINNER
        estadoSpinner3 = (Spinner) findViewById(R.id.spinnerConsultaMunicipio);
        serviceBO=new MunicipioServiceBO(getBaseContext());
        Cursor cursor3;
        cursor3=serviceBO.getDao().carregaMunicipios();

        //COLUNAS QUE VOU USAR DO CURSOR
        String[] queryCols=new String[]{"_id", "nome_municipio"};
        String[] adapterCols = new String[]{"nome_municipio"};
        int[] adapterRowViews=new int[]{android.R.id.text1};

        SimpleCursorAdapter sca=new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor3, adapterCols, adapterRowViews,0);
        sca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estadoSpinner3.setAdapter(sca);
        //FIM DO CARREGAMENTO DO SPINNER

        //CONVERTER PARA SPINNER
        //MOSTRA A POSICAO NA LISTA
        estadoSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            int pos = 0;

            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                pos = position;

                //CARREGA O LISVIEW
                EstadoDAO crud = new EstadoDAO(getBaseContext());

                //A IDE ou a Persistencia pediu para Cursor ser final
                final Cursor cursor = crud.consultaEstadoPeloMunicipio(estadoSpinner3.getSelectedItemId());

                //Campos que serão usados no cabeçalho das colunas
                String[] nomeCampos = new String[] { Constantes.NOME_ESTADO};
                int[] idViews = new int[] { R.id.nomeEstado};

                //Monta um layout_municipios dentro do consulta_municipio
                SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                        R.layout.layout_municipios,cursor,nomeCampos,idViews, 0);

                lista = (ListView)findViewById(R.id.listView);
                lista.setAdapter(adaptador);
                //FIM DO CARREGAMENTO DE LISTVIEW


                //Long id2 = estadoParaPesquisa.getSelectedItemId();
                //form.getEstado().setIdEstado(id2);
                //form.getMunicipio().setEstado(form.getEstado());

                Toast.makeText(getApplicationContext(), "PRECISA SER O NOME CLICADO: " + estadoSpinner3.getSelectedItem().toString() + "Valor convertido: " + position, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });

    }


}
