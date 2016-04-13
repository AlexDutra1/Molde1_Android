package com.example.galois_dut_sistemas.molde1_android.controller;

import com.example.galois_dut_sistemas.molde1_android.model.Estado;
import com.example.galois_dut_sistemas.molde1_android.model.Municipio;

/**
 * Created by galois on 09/04/16.
 */
public class MunicipioForm {

    private Municipio municipio=new Municipio();
    private Estado estado= new Estado();

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
