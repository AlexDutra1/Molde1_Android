package com.example.galois_dut_sistemas.molde1_android.controller;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
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
 * Created by galois on 25/04/16.
 */
public class EstadoConsultaActivity extends Activity {

    private EstadoServiceBO serviceBO;
    private EstadoForm form=new EstadoForm();

    private Spinner estadoSpinner;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_estado);

        estadoSpinner = (Spinner) findViewById(R.id.spinnerConsultaEstado);

        //CARREGA ESTADOS NO SPINNER
        serviceBO=new EstadoServiceBO(getBaseContext());
        Cursor cursor;
        cursor=serviceBO.getDao().carregaEstados();

        //COLUNAS QUE VOU USAR DO CURSOR
        String[] queryCols=new String[]{"_id", "nome"};
        String[] adapterCols = new String[]{"nome"};
        int[] adapterRowViews=new int[]{android.R.id.text1};

        SimpleCursorAdapter sca=new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor, adapterCols, adapterRowViews,0);
        sca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estadoSpinner.setAdapter(sca);
        //FIM DO CARREGAMENTO DO SPINNER


        ////////////////////////////////////////////////////////////////////////////////////////////


        //CARREGA O LISTVIEW
        MunicipioDAO crud = new MunicipioDAO(getBaseContext());

        //A IDE ou a Persistencia pediu para Cursor ser final
        final Cursor cursor2 = crud.carregaListaDeMunicipiosDoEstado(null);

        //SELECIONA QUAL COLUNA DO CURSOR VOCE DESEJA USAR
        String[] nomeCampos = new String[] {Constantes.NOME_MUNICIPIO};
        int[] idViews = new int[] { R.id.textViewNomesDosMunicipios};

        //Monta um layout_municipios dentro do consulta_municipio
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.layout_estados,cursor2,nomeCampos,idViews, 0);

        lista = (ListView)findViewById(R.id.listViewDeEstados);
        lista.setAdapter(adaptador);
        //FIM DO CARREGAMENTO

        //CONVERTER PARA SPINNER
        //MOSTRA A POSICAO NA LISTA
        final Spinner estadoParaPesquisa = (Spinner) findViewById(R.id.spinnerConsultaEstado);
        estadoParaPesquisa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            int pos = 0;

            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                pos = position;

                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),

                        Toast.LENGTH_SHORT).show();
/*
                //cursor.moveToFirst();
                System.out.println("Cursor: " + cursor);
                System.out.println("Cursor getColumn: "+cursor.getColumnNames());
                System.out.println("Cursor getLong 0: "+cursor.getLong(0));
                System.out.println("Cursor getString 1: " + cursor.getString(1));
                System.out.println("Cursor getString 2: " + cursor.getColumnIndex("nome"));
                //form.getMunicipio().getEstado().setIdEstado(cursor.getLong(0));
*/
                Long id2 = estadoParaPesquisa.getSelectedItemId();
                form.getEstado().setIdEstado(id2);
                //form.getMunicipio().setEstado(form.getEstado());

                Toast.makeText(getApplicationContext(), "PRECISA SER O NOME CLICADO: " + estadoParaPesquisa.getSelectedItem().toString() + "Valor convertido: " + position, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });

    }

}
