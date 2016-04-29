package com.example.galois_dut_sistemas.molde1_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.galois_dut_sistemas.molde1_android.controller.ClienteCadastroActivity;
import com.example.galois_dut_sistemas.molde1_android.controller.ClienteConsultaActivity;
import com.example.galois_dut_sistemas.molde1_android.controller.EnderecoCadastroActivity;
import com.example.galois_dut_sistemas.molde1_android.controller.EnderecoConsultaActivity;
import com.example.galois_dut_sistemas.molde1_android.controller.EstadoCadastroActivity;
import com.example.galois_dut_sistemas.molde1_android.controller.EstadoConsultaActivity;
import com.example.galois_dut_sistemas.molde1_android.controller.MunicipioCadastroActivity;
import com.example.galois_dut_sistemas.molde1_android.controller.MunicipioConsultaActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //CADASTRA MUNICIPIO
        Button btCadastrarMunicipio = (Button) findViewById(R.id.buttonCadastrarMunicipio);
        btCadastrarMunicipio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MunicipioCadastroActivity.class);
                startActivity(intent);
            }
        });


        //CONSULTA MUNICIPIO
        Button btConsultarMunicipio = (Button) findViewById(R.id.buttonConsultarMunicipio);
        btConsultarMunicipio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, MunicipioConsultaActivity.class);
                startActivity(intent);

                //Finaliza a activity anterior
                //finish();

            }

        });

        //CADASTRA ESTADO
        Button btCadastrarEstado = (Button) findViewById(R.id.buttonCadastrarEstado);
        btCadastrarEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, EstadoCadastroActivity.class);
                startActivity(intent);

                //Finaliza a activity anterior
                //finish();

               //Faixa de mensagem no rodapé da tela
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        //CONSULTA ESTADO
        Button btConsultaEstado = (Button) findViewById(R.id.buttonConsultarEstado);
        btConsultaEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, EstadoConsultaActivity.class);
                startActivity(intent);

                //Finaliza a activity anterior
                //finish();

                //Faixa de mensagem no rodapé da tela
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });




        //CADASTRO ENDEREÇO
        Button btCadastrarEndereco = (Button) findViewById(R.id.buttonCadastrarEndereco);
        btCadastrarEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, EnderecoCadastroActivity.class);
                startActivity(intent);

                //Finaliza a activity anterior
                //finish();

            }

        });

        //CONSULTA ENDEREÇO
        Button btConsultarEndereco = (Button) findViewById(R.id.buttonConsultarEndereco);
        btConsultarEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, EnderecoConsultaActivity.class);
                startActivity(intent);

                //Finaliza a activity anterior
                //finish();

            }

        });

        //CADASTRA CLIENTE
        Button btCadastraCliente = (Button) findViewById(R.id.buttonCadastraCliente);
        btCadastraCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, ClienteCadastroActivity.class);
                startActivity(intent);

                //Finaliza a activity anterior
                //finish();

            }

        });

        //CONSULTA CLIENTE
        Button btConsultaCliente = (Button) findViewById(R.id.buttonConsultaCliente);
        btConsultaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ClienteConsultaActivity.class);
                startActivity(intent);

                //Finaliza a activity anterior
                //finish();

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
