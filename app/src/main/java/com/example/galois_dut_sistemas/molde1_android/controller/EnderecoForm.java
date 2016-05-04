package com.example.galois_dut_sistemas.molde1_android.controller;

import com.example.galois_dut_sistemas.molde1_android.model.Endereco;
import com.example.galois_dut_sistemas.molde1_android.model.Estado;
import com.example.galois_dut_sistemas.molde1_android.model.Municipio;

/**
 * Created by galois on 29/04/16.
 */
public class EnderecoForm {

    private Endereco endereco=new Endereco();

    private Estado estado=new Estado();

    private Municipio municipio=new Municipio();

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }



    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


}
