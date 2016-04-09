package com.example.galois_dut_sistemas.molde1_android.service_e_bo;

import com.example.galois_dut_sistemas.molde1_android.persistence.EstadoDAO;

/**
 * Created by galois on 09/04/16.
 */
public class EstadoServiceBO {

    private EstadoDAO dao= new EstadoDAO(null);

    public EstadoDAO getDao() {
        return dao;
    }

    public void setDao(EstadoDAO dao) {
        this.dao = dao;
    }

}
