package com.example.galois_dut_sistemas.molde1_android.controller;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.galois_dut_sistemas.molde1_android.R;
import com.example.galois_dut_sistemas.molde1_android.persistence.EnderecoDAO;
import com.example.galois_dut_sistemas.molde1_android.service_e_bo.EstadoServiceBO;
import com.example.galois_dut_sistemas.molde1_android.service_e_bo.MunicipioServiceBO;

/**
 * Created by galois on 29/04/16.
 */
public class EnderecoCadastroActivity extends Activity {

    private EnderecoForm formulario=new EnderecoForm();
    //private EstadoServiceBO serviceBO;

    private MunicipioServiceBO serviceBO;
    private MunicipioForm form=new MunicipioForm();


    //ASSOCIACAO DE COMPONENTES

    EditText nomeMunicipio;
    Spinner estadoSpinner;
    Spinner estadoSpinner4;
    EditText editTextLagradouro;
    EditText editTextBairro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_endereco);

        estadoSpinner = (Spinner) findViewById(R.id.spinnerEscolheEstado);
        editTextLagradouro = (EditText) findViewById(R.id.editTextLagradouro);
        editTextBairro = (EditText) findViewById(R.id.editTextBairro);

        //CARREGA ESTADOS NO SPINNER
        serviceBO=new MunicipioServiceBO(getBaseContext());
        Cursor cursor;
        cursor=serviceBO.getEstadoDAO().carregaEstados();

        //COLUNAS QUE VOU USAR DO CURSOR
        String[] queryCols=new String[]{"_id", "nome_estado"};
        String[] adapterCols = new String[]{"nome_estado"};
        int[] adapterRowViews=new int[]{android.R.id.text1};

        SimpleCursorAdapter sca=new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor, adapterCols, adapterRowViews,0);
        sca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estadoSpinner.setAdapter(sca);
        //FIM DO CARREGAMENTO DO SPINNER

        //CARREGA MUNICIPIOS NO SPINNER
        estadoSpinner4 = (Spinner) findViewById(R.id.spinnerEscolheMunicipio);
        serviceBO=new MunicipioServiceBO(getBaseContext());
        Cursor cursor3;
        cursor3=serviceBO.getDao().carregaMunicipios();

        //COLUNAS QUE VOU USAR DO CURSOR
        String[] queryCols2=new String[]{"_id", "nome_municipio"};
        String[] adapterCols2 = new String[]{"nome_municipio"};
        int[] adapterRowViews2=new int[]{android.R.id.text1};

        SimpleCursorAdapter sca2=new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor3, adapterCols2, adapterRowViews2,0);
        sca2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estadoSpinner4.setAdapter(sca2);
        //FIM DO CARREGAMENTO DO SPINNER





        Button btCadastrar = (Button) findViewById(R.id.buttonEfetuarCadastro);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                formulario.getEndereco().setLagradouro(editTextLagradouro.getText().toString());
                formulario.getEndereco().setBairro(editTextBairro.getText().toString());

                //System.out.println("NOME: " + formulario.getEstado().getNome());
                //System.out.println("SIGLA: " + formulario.getEstado().getSigla());

                //PERSISTE OS DADOS
                EnderecoDAO enderecoDAO= new EnderecoDAO(getBaseContext());
                enderecoDAO.insereDado(formulario.getEndereco());

                //String resultado = serviceBO.getDao().insereDado(formulario.getEstado().getNome(),
                  //      formulario.getEstado().getSigla());


                //Exibe FAIXA DE MODAL NO RODAPÉ
                //Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            }

        });



    }


}
