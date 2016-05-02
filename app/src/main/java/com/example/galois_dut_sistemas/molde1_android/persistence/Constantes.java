package com.example.galois_dut_sistemas.molde1_android.persistence;

/**
 * Created by galois on 11/04/16.
 */
public class Constantes {

    //ESTADOS
    public static final String TABELA_ESTADOS = "estados";
    public static final String ID_ESTADO = "_id"; //Convencao de identificador
    public static final String NOME_ESTADO = "nome_estado";
    public static final String SIGLA = "sigla";
    //TEM UMA LISTA DE ESTADOS

    //MUNICIPIOS
    public static final String TABELA_MUNICIPIOS = "municipios";
    public static final String ID_MUNICIPIO = "_id"; //Convencao de identificador
    public static final String NOME_MUNICIPIO = "nome_municipio";
    //MUNICITPIO TEM UM ESTADO
    public static final String MUNICIPIO_TEM_ESTADO="fk_estado_id";

    //ENDERECO
    public static final String TABELA_ENDERECOS = "enderecos";
    public static final String ID_ENDERECO = "_id"; //Convencao de identificador
    public static final String LAGRADOURO_ENDERECO="lagradouro";
    public static final String BAIRRO_ENDERECO="bairro";
    //ENDERECO TEM UM ESTADO
    public static final String ENDERECO_TEM_ESTADO="fk_endereco_estado_id";
    //ENDERECO TEM UM MUNICIPIO
    public static final String ENDERECO_TEM_MUNICIPIO="fk_endereco_municipio_id";

}
