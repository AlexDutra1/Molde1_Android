package com.example.galois_dut_sistemas.molde1_android.service_e_bo;

import android.content.Context;

import com.example.galois_dut_sistemas.molde1_android.persistence.EstadoDAO;

/**
 * Created by galois on 09/04/16.
 */
public class EstadoServiceBO {

    private EstadoDAO dao;

    //Repassa o contexto até o DAO
    public EstadoServiceBO(Context contexto){
        dao = new EstadoDAO(contexto);
    }

    public EstadoDAO getDao() {
        return dao;
    }

    public void setDao(EstadoDAO dao) {
        this.dao = dao;
    }





}
