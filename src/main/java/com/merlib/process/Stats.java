package com.merlib.process;

import com.merlib.dao.AdnJDBC;
import com.merlib.models.Estadistica;

import java.sql.Connection;

public class Stats {

    public static Estadistica getStats(){

        AdnJDBC AdnJDBC =  new AdnJDBC();
        Connection conn = AdnJDBC.getConnection();

        int mutante  = AdnJDBC.getCantidadTipo(1);
        int humano = AdnJDBC.getCantidadTipo(0);
        float ratio =1;
        if (humano>0){
            ratio = mutante/humano;
        }


        Estadistica stat = new Estadistica(mutante,humano,ratio);
        return stat;
    }


}
