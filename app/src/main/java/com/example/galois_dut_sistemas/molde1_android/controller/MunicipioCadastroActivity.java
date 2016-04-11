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
import com.example.galois_dut_sistemas.molde1_android.model.Municipio;
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

        //IMPLEMENTANDO
        //TESTE
        String[] arrayLoco=new String[] {"Peidão","Leitãozin"};

        Spinner estadoSpinner = (Spinner) findViewById(R.id.spinnerCadastraMunicipio);

        ArrayAdapter<String> adapterX=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arrayLoco);
        adapterX.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        estadoSpinner.setAdapter(adapterX);

        //TESTE PARA PREENCHIMENTO DE SPINNER DINAMICO
        //EXEMPLO
        //Creamos el cursor
        /*
        Cursor c = baseDatos.rawQuery("select id AS _id, nombre from comidas", null);
        //Creamos el adaptador
        SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item,c,new String[] {"nombre"},    new int[] {android.R.id.text1});
        //Añadimos el layout para el menú
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Le indicamos al spinner el adaptador a usar
        prueba.setAdapter(adapter2);
        */
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
