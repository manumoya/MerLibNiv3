package com.merlib.process;

import com.merlib.dao.AdnJDBC;
import com.merlib.models.Estadistica;

import java.sql.Connection;
import java.text.DecimalFormat;

public class Stats {

    public static Estadistica getStats(){

        AdnJDBC AdnJDBC =  new AdnJDBC();
        Connection conn = AdnJDBC.getConnection();
        DecimalFormat df = new DecimalFormat("#.0");

        int mutante  = AdnJDBC.getCantidadTipo(1);
        int humano = AdnJDBC.getCantidadTipo(0);
        double ratio =0;
        if (humano>0){
            ratio = Double.valueOf(mutante)/Double.valueOf(humano);
        }
        String ratioStr= df.format(ratio);
        double ratioFinal = Double.parseDouble(ratioStr);

        Estadistica stat = new Estadistica(mutante,humano,ratioFinal);
        return stat;
    }


}
