package com.example.galois_dut_sistemas.molde1_android.model;

import java.util.List;

/**
 * Created by galois on 09/04/16.
 */
public class Estado {

    private Long idEstado;
    private String sigla;
    private String nome;
    private List<Municipio> municipiosDoEstado;

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Municipio> getMunicipiosDoEstado() {
        return municipiosDoEstado;
    }

    public void setMunicipiosDoEstado(List<Municipio> municipiosDoEstado) {
        this.municipiosDoEstado = municipiosDoEstado;
    }
}
