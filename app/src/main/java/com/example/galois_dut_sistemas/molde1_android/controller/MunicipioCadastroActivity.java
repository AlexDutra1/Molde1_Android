package com.example.galois_dut_sistemas.molde1_android.controller;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.galois_dut_sistemas.molde1_android.MainActivity;
import com.example.galois_dut_sistemas.molde1_android.R;
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

        //TESTE PRENCHIMENTO VINDO DO BANCO

        Spinner estadoSpinner = (Spinner) findViewById(R.id.spinnerCadastraMunicipio);

        //PERSISTE OS DADOS
        //AQUI ABAIXO ESTA COM ERRO
        //EstadoDAO estadodao=new EstadoDAO(getBaseContext());
        //Cursor cursor=estadodao.carregaEstados();

        serviceBO=new MunicipioServiceBO(getBaseContext());
        Cursor cursor=serviceBO.getEstadoDAO().carregaEstados();


        String[] queryCols=new String[]{"_id", "nome"};
        String[] adapterCols = new String[]{"nome"};
        int[] adapterRowViews=new int[]{android.R.id.text1};
        //Cursor cursor=estadodao.carregaEstados();

        SimpleCursorAdapter sca=new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor, adapterCols, adapterRowViews,0);
        sca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estadoSpinner.setAdapter(sca);



        sca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        estadoSpinner.setAdapter(sca);



        //IMPLEMENTANDO
        //FUNCIONANDO
        /*
        String[] arrayLoco=new String[] {"Peidão","Leitãozin"};

        Spinner estadoSpinner = (Spinner) findViewById(R.id.spinnerCadastraMunicipio);

        ArrayAdapter<String> adapterX=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arrayLoco);
        adapterX.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        estadoSpinner.setAdapter(adapterX);
        */



        Button btCadastrar = (Button) findViewById(R.id.buttonCadastraMunicipio);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nomeMunicipio = (EditText) findViewById(R.id.editTextNomeMunicipio);
                //Spinner estado = (Spinner) findViewById(R.id.spinnerCadastraMunicipio);

                formulario.getMunicipio().setNome(nomeMunicipio.getText().toString());
                //formulario.getMunicipio().getEstado.(estado.getText().toString());

                System.out.println("NOME: " + formulario.getMunicipio().getNome());


                //PERSISTE OS DADOS
                serviceBO = new MunicipioServiceBO(getBaseContext());
                String resultado = serviceBO.getDao().insereDado(formulario.getMunicipio().getNome());

                //Exibe FAIXA DE MODAL NO RODAPÉ
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            }

        });






    }
}


