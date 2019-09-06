package com.merlib.process;

import com.merlib.dao.AdnJDBC;
import com.merlib.models.Estadistica;
import com.merlib.models.Persona;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Stats {

    public static Estadistica getStats(){
        Estadistica stat;
        int mutante = 0;
        int humano = 0;
        double ratio =0;
        AdnJDBC AdnJDBC =  new AdnJDBC();
        DecimalFormat df = new DecimalFormat("#.0");
        Connection conn = AdnJDBC.getConnection();

        if (conn!=null){
            mutante  = AdnJDBC.getCantidadTipo(1);
            humano = AdnJDBC.getCantidadTipo(0);
            if (humano>0){
                ratio = Double.valueOf(mutante)/Double.valueOf(humano);
            }
            String ratioStr= df.format(ratio);
            double ratioFinal = Double.parseDouble(ratioStr);
            stat = new Estadistica(mutante,humano,ratioFinal);
        }else{
            stat = new Estadistica(mutante,humano,ratio);
        }

        return stat;
    }

    /* Convert Adn to Insert  */
    public static String convertAdntoIns(String[] dna){
        String dnaStr = Arrays.toString(dna);
        dnaStr = dnaStr.replace("[","");
        dnaStr = dnaStr.replace("]","");
        dnaStr = dnaStr.replace(", ","-");
        return dnaStr;
    }

    public static void insStats(String[] dna, boolean isMutant){
        int tipo=0;
        String dnaNew = convertAdntoIns(dna);
        if (isMutant){
            tipo=1;
        }

        AdnJDBC AdnJDBC = new AdnJDBC();
        Connection conn = AdnJDBC.getConnection();
        if (conn!=null){
            int nroStats  = AdnJDBC.getCantidadEstadistica(dnaNew);
            if (nroStats==0){
                Persona pers = new Persona(dnaNew,tipo);
                AdnJDBC.insertEstadistica(pers);
            }
            AdnJDBC.closeConnection();
        }
    }

}
