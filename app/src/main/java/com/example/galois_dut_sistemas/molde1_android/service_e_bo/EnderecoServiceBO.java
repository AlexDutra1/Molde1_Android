package com.example.galois_dut_sistemas.molde1_android.service_e_bo;

import com.example.galois_dut_sistemas.molde1_android.persistence.EnderecoDAO;
import com.example.galois_dut_sistemas.molde1_android.persistence.EstadoDAO;

/**
 * Created by galois on 29/04/16.
 */
public class EnderecoServiceBO {

    private EnderecoDAO dao;

    public EnderecoDAO getDao() {
        return dao;
    }

    public void setDao(EnderecoDAO dao) {
        this.dao = dao;
    }


}
