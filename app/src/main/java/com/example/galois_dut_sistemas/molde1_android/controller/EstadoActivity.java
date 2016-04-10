package com.example.galois_dut_sistemas.molde1_android.controller;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.galois_dut_sistemas.molde1_android.R;
import com.example.galois_dut_sistemas.molde1_android.model.Estado;
import com.example.galois_dut_sistemas.molde1_android.persistence.CriaBanco;
import com.example.galois_dut_sistemas.molde1_android.persistence.EstadoDAO;
import com.example.galois_dut_sistemas.molde1_android.service_e_bo.EstadoServiceBO;

/**
 * Created by galois on 09/04/16.
 */
public class EstadoActivity extends Activity {

    private EstadoForm formulario=new EstadoForm();
    private EstadoServiceBO serviceBO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_estado);

        Button btCadastrar = (Button) findViewById(R.id.buttonEfetuarCadastro);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nomeEstado = (EditText) findViewById(R.id.editTextNomeEstado);
                EditText siglaEstado = (EditText) findViewById(R.id.editTextSiglaEstado);

                formulario.getEstado().setNome(nomeEstado.getText().toString());
                formulario.getEstado().setSigla(siglaEstado.getText().toString());

                System.out.println("NOME: " + formulario.getEstado().getNome());
                System.out.println("SIGLA: " + formulario.getEstado().getSigla());

                //PERSISTE OS DADOS
/*

                EstadoDAO crud = new EstadoDAO(getBaseContext());
                crud.insereDado(formulario.getEstado().getNome(),
                        formulario.getEstado().getSigla());
*/
                serviceBO=new EstadoServiceBO(getBaseContext());
                String resultado=serviceBO.getDao().insereDado(formulario.getEstado().getNome(),
                        formulario.getEstado().getSigla());

                //Exibe FAIXA DE MODAL NO RODAPÉ
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                System.out.println("MENSAGEM: " + resultado);

            }

        });



      /*
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    */

    }
}
