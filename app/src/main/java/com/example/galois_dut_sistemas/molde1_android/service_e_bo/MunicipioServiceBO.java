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

    //Repassa o contexto até o DAO
    public MunicipioServiceBO(Context contexto){
        dao = new MunicipioDAO(contexto);
    }
}
