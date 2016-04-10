package com.example.galois_dut_sistemas.molde1_android.controller;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.galois_dut_sistemas.molde1_android.R;
import com.example.galois_dut_sistemas.molde1_android.service_e_bo.EstadoServiceBO;

/**
 * Created by galois on 09/04/16.
 */
public class MunicipioCadastroActivity extends Activity {

    private MunicipioForm formulario= new MunicipioForm();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_municipio);

        //IMPLEMENTANDO
        //TESTE
        String[] arrayLoco={"Peidão","Leitãozin"};

        // busca a data atual para mostrar no botão
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_estados,
                android.R.layout.simple_spinner_item);
        Spinner estadoSpinner = (Spinner) findViewById(R.id.spinnerCadastraMunicipio);
        estadoSpinner.setAdapter(adapter);

        //TESTE PARA PREENCHIMENTO DE SPINNER DINAMICO
        //String[] cols={android.provider.Contacts.PeopleColumns.NAME};
        //Cursor cur = managedQuery(android.provider.Contacts.People.CONTENT_URI, cols, null, null);
        //estadoSpinner.setAdapter(new CursorAdapter(arrayLoco, this));


        //FIM



        Button btCadastrar = (Button) findViewById(R.id.buttonCadastraMunicipio);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nomeMunicipio = (EditText) findViewById(R.id.editTextNomeMunicipio);
                //Spinner estado = (Spinner) findViewById(R.id.spinnerCadastraMunicipio);

                formulario.getMunicipio().setNome(nomeMunicipio.getText().toString());
                //formulario.getMunicipio().getEstado.(estado.getText().toString());

                System.out.println("NOME: " + formulario.getMunicipio().getNome());
                //System.out.println("ESTADO: " + estado);
                //System.out.println("ESTADO: " + formulario.getMunicipio().getEstado().getNome());

                //PERSISTE OS DADOS
                //serviceBO = new EstadoServiceBO(getBaseContext());
                //String resultado = serviceBO.getDao().insereDado(formulario.getEstado().getNome(),
                  //      formulario.getEstado().getSigla());

                //Exibe FAIXA DE MODAL NO RODAPÉ
                //Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            }

        });


    }
}
