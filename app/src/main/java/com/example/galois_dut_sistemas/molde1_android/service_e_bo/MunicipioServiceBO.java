package com.example.galois_dut_sistemas.molde1_android.service_e_bo;

import android.content.Context;

import com.example.galois_dut_sistemas.molde1_android.model.Municipio;
import com.example.galois_dut_sistemas.molde1_android.persistence.EstadoDAO;
import com.example.galois_dut_sistemas.molde1_android.persistence.MunicipioDAO;

/**
 * Created by galois on 11/04/16.
 */
public class MunicipioServiceBO {

    private MunicipioDAO dao;

    private EstadoDAO estadoDAO;

    //Repassa o contexto até o DAO e o estadoDAO
    public MunicipioServiceBO(Context contexto){
        dao = new MunicipioDAO(contexto);
        estadoDAO = new EstadoDAO(contexto);
    }


    public MunicipioDAO getDao() {
        return dao;
    }

    public void setDao(MunicipioDAO dao) {
        this.dao = dao;
    }

    public EstadoDAO getEstadoDAO() { return estadoDAO; }

    public void setEstadoDAO(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }


}
