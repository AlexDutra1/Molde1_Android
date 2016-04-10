package com.example.galois_dut_sistemas.molde1_android.model;

/**
 * Created by galois on 09/04/16.
 */
public class Municipio {

    private Long idMunicipio;
    private Estado estado;
    private String nome;

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
