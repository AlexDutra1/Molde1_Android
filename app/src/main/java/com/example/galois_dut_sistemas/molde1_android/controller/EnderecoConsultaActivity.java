package com.example.galois_dut_sistemas.molde1_android.controller;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.galois_dut_sistemas.molde1_android.R;
import com.example.galois_dut_sistemas.molde1_android.persistence.EnderecoDAO;
import com.example.galois_dut_sistemas.molde1_android.persistence.MunicipioDAO;
import com.example.galois_dut_sistemas.molde1_android.service_e_bo.MunicipioServiceBO;

/**
 * Created by galois on 29/04/16.
 */
public class EnderecoConsultaActivity extends Activity {

    private EnderecoForm formulario=new EnderecoForm();
    //private EstadoServiceBO serviceBO;

    private MunicipioServiceBO serviceBO;
    private MunicipioForm form=new MunicipioForm();


    //ASSOCIACAO DE COMPONENTES

    EditText nomeMunicipio;
    Spinner spinnerEscolheEstado;
    Spinner spinnerEscolheMunicipio;
    EditText editTextLagradouro;
    EditText editTextBairro;
    Cursor cursor40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_endereco);

        spinnerEscolheEstado = (Spinner) findViewById(R.id.ConsultaspinnerEscolheEstado);
        spinnerEscolheMunicipio = (Spinner) findViewById(R.id.ConsultaspinnerEscolheMunicipio);

        editTextLagradouro = (EditText) findViewById(R.id.editTextLagradouro);
        editTextBairro = (EditText) findViewById(R.id.editTextBairro);

        //CARREGA ESTADOS NO SPINNER
        serviceBO = new MunicipioServiceBO(getBaseContext());
        Cursor cursor;
        cursor = serviceBO.getEstadoDAO().carregaEstados();

        //COLUNAS QUE VOU USAR DO CURSOR
        String[] queryCols = new String[]{"_id", "nome_estado"};
        String[] adapterCols = new String[]{"nome_estado"};
        int[] adapterRowViews = new int[]{android.R.id.text1};

        SimpleCursorAdapter sca = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor, adapterCols, adapterRowViews, 0);
        sca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEscolheEstado.setAdapter(sca);
        //FIM DO CARREGAMENTO DO SPINNER

        //CARREGA MUNICIPIOS NO SPINNER
        serviceBO = new MunicipioServiceBO(getBaseContext());
        Cursor cursor3;
        cursor3 = serviceBO.getDao().carregaMunicipios();

        //COLUNAS QUE VOU USAR DO CURSOR
        String[] queryCols2 = new String[]{"_id", "nome_municipio"};
        String[] adapterCols2 = new String[]{"nome_municipio"};
        int[] adapterRowViews2 = new int[]{android.R.id.text1};

        SimpleCursorAdapter scaMunicipio = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor3, adapterCols2, adapterRowViews2, 0);
        scaMunicipio.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEscolheMunicipio.setAdapter(scaMunicipio);
        //FIM DO CARREGAMENTO DO SPINNER


        Button btCadastrar = (Button) findViewById(R.id.Consultabutton5);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                formulario.getEndereco().setLagradouro(editTextLagradouro.getText().toString());
                formulario.getEndereco().setBairro(editTextBairro.getText().toString());

                //PERSISTE OS DADOS
                EnderecoDAO enderecoDAO = new EnderecoDAO(getBaseContext());
                enderecoDAO.insereDado(formulario.getEndereco());

            }

        });

        //CONVERTER PARA SPINNER
        //MOSTRA A POSICAO NA LISTA
        spinnerEscolheEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            int pos = 0;

            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                pos = position;

                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),

                        Toast.LENGTH_SHORT).show();

                MunicipioDAO teste = new MunicipioDAO(getBaseContext());

                //CARREGA MUNICIPIOS NO SPINNER
                cursor40 = teste.carregaListaDeMunicipiosDoEstado(spinnerEscolheMunicipio.getSelectedItemId());
                carregaMunicipios(cursor40);


            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });
    }

    public void carregaMunicipios(Cursor cursor3) {
        //COLUNAS QUE VOU USAR DO CURSOR
        String[] queryCols22 = new String[]{"_id", "nome_municipio"};
        String[] adapterCols22 = new String[]{"nome_municipio"};
        int[] adapterRowViews22 = new int[]{android.R.id.text1};


        SimpleCursorAdapter sca2 = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor3, adapterCols22, adapterRowViews22, 0);

        sca2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEscolheMunicipio.setAdapter(sca2);
        //FIM DO CARREGAMENTO DO SPINNER
    }


}
