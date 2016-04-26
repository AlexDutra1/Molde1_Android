package com.example.galois_dut_sistemas.molde1_android.controller;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.galois_dut_sistemas.molde1_android.MainActivity;
import com.example.galois_dut_sistemas.molde1_android.R;
import com.example.galois_dut_sistemas.molde1_android.model.Estado;
import com.example.galois_dut_sistemas.molde1_android.model.Municipio;
import com.example.galois_dut_sistemas.molde1_android.persistence.Constantes;
import com.example.galois_dut_sistemas.molde1_android.persistence.CriaBanco;
import com.example.galois_dut_sistemas.molde1_android.persistence.EstadoDAO;
import com.example.galois_dut_sistemas.molde1_android.persistence.MunicipioDAO;
import com.example.galois_dut_sistemas.molde1_android.service_e_bo.EstadoServiceBO;
import com.example.galois_dut_sistemas.molde1_android.service_e_bo.MunicipioServiceBO;

/**
 * Created by galois on 09/04/16.
 */
public class MunicipioCadastroActivity extends Activity {

    private MunicipioServiceBO serviceBO;
    private MunicipioForm form=new MunicipioForm();


    //ASSOCIACAO DE COMPONENTES

    EditText nomeMunicipio;
    Spinner estadoSpinner;

    public void carregaEstados(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_municipio);

        estadoSpinner = (Spinner) findViewById(R.id.spinnerCadastraMunicipio);


        //CARREGA ESTADOS NO SPINNER
        serviceBO=new MunicipioServiceBO(getBaseContext());
        Cursor cursor;
        cursor=serviceBO.getEstadoDAO().carregaEstados();


        //COLUNAS QUE VOU USAR DO CURSOR
        String[] queryCols=new String[]{"_id", "nome"};
        String[] adapterCols = new String[]{"nome"};
        int[] adapterRowViews=new int[]{android.R.id.text1};

        SimpleCursorAdapter sca=new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor, adapterCols, adapterRowViews,0);
        sca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estadoSpinner.setAdapter(sca);
        //FIM DO CARREGAMENTO DO SPINNER

        //EFETUA CADASTRO
        Button btCadastrar = (Button) findViewById(R.id.buttonCadastraMunicipio);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ASSOCIACAO DE COMPONENTES
                nomeMunicipio = (EditText) findViewById(R.id.editTextNomeMunicipio);
                form.getMunicipio().setNome(nomeMunicipio.getText().toString());

                //PERSISTE OS DADOS
                serviceBO = new MunicipioServiceBO(getBaseContext());
                String resultado = serviceBO.getDao().insereDado(form.getMunicipio());

                //Exibe FAIXA DE MODAL NO RODAPÉ
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            }

        });


        //CONVERTER PARA SPINNER
        //MOSTRA A POSICAO NA LISTA
        final Spinner nomeestado = (Spinner) findViewById(R.id.spinnerCadastraMunicipio);
        nomeestado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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
                Long id2= nomeestado.getSelectedItemId();
                form.getEstado().setIdEstado(id2);
                form.getMunicipio().setEstado(form.getEstado());

                Toast.makeText(getApplicationContext(), "PRECISA SER O NOME CLICADO: "+nomeestado.getSelectedItem().toString()+"Valor convertido: " + position, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });


    }
}


