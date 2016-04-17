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

    private MunicipioForm formulario= new MunicipioForm();
    private MunicipioServiceBO serviceBO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_municipio);

        //CARREGA O SPINNER COM NOME DOS ESTADOS
        Spinner estadoSpinner = (Spinner) findViewById(R.id.spinnerCadastraMunicipio);

        serviceBO=new MunicipioServiceBO(getBaseContext());
        Cursor cursor=serviceBO.getEstadoDAO().carregaEstados();

        //Navegando pelo Cursor
        /*
        while(cursor.moveToNext()){
            //Prenchendo um objeto do tipo pessoa com os dados recuperados do banco de dados
            Estado estado = new Estado();
            estado.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            System.out.println("LACO WHILE: " + estado.getNome());
            //estado.setId(cursor.getInt(cursor.getColumnIndex("id")));

            estado.setNome(cursor.getString(cursor.getPosition()));
            //estado.setNome(cursor.getString(cursor.get));

        }
        */

        String[] queryCols=new String[]{"_id", "nome"};
        String[] adapterCols = new String[]{"nome"};
        int[] adapterRowViews=new int[]{android.R.id.text1};

        SimpleCursorAdapter sca=new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor, adapterCols, adapterRowViews,0);
        sca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estadoSpinner.setAdapter(sca);

        //EFETUA CADASTRO
        Button btCadastrar = (Button) findViewById(R.id.buttonCadastraMunicipio);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nomeMunicipio = (EditText) findViewById(R.id.editTextNomeMunicipio);


                formulario.getMunicipio().setNome(nomeMunicipio.getText().toString());

                //formulario.getMunicipio().setEstado(nomeestado.getText().toString());

                System.out.println("NOME: " + formulario.getMunicipio().getNome());


                //PERSISTE OS DADOS
                serviceBO = new MunicipioServiceBO(getBaseContext());
                String resultado = serviceBO.getDao().insereDado(formulario.getMunicipio().getNome());

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

                String teste= parent.getItemAtPosition(pos).toString();
                //TENTATIVA DE ADICIONAR UM ESTADO AO MUNICIPIO
                //formulario.getMunicipio().getEstado().setIdEstado(teste.toLong());

                //String teste= parent.getItemAtPosition(pos).toString();
                System.out.println("ID: " + id);
                Municipio mun= new Municipio();
               // mun.setEstado(id);
               // mun.setEstado(()teste);

                Toast.makeText(getApplicationContext(), "PRECISA SER O NOME CLICADO: "+nomeestado.getSelectedItem().toString()+"Valor convertido: " + position, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });


    }
}


