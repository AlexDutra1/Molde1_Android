package com.example.galois_dut_sistemas.molde1_android.persistence;

/**
 * Created by galois on 11/04/16.
 */
public class Constantes {

    //ESTADOS
    public static final String TABELA_ESTADOS = "estados";
    public static final String ID_ESTADO = "_id"; //Convencao de identificador
    public static final String NOME_ESTADO = "nome";
    public static final String SIGLA = "sigla";
    //TEM UMA LISTA DE ESTADOS

    //MUNICIPIOS
    public static final String TABELA_MUNICIPIOS = "municipios";
    public static final String ID_MUNICIPIO = "_id"; //Convencao de identificador
    public static final String NOME_MUNICIPIO = "nome";
    //TEM UM ESTADO
    public static final String ESTADO="fk_estado_id";

}
