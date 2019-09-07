package com.merlib.dao;

import com.merlib.models.Persona;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Connection;

import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class AdnJDBCTest {

    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(AdnJDBC.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    */

    @Test
    public void getConnection() {
        AdnJDBC AdnJDBC =  new AdnJDBC();
        assertNotNull(AdnJDBC.getConnection());
    }

    @Test
    public void closeConnection(){
        ;
    }

    @Test
    public void getCantidadTipo(){
        AdnJDBC AdnJDBC =  new AdnJDBC();
        Connection conn = AdnJDBC.getConnection();

        assertEquals(6,AdnJDBC.getCantidadTipo(1));
        assertEquals(0,AdnJDBC.getCantidadTipo(0));

       AdnJDBC.closeConnection();
    }

    @Test
    public void insertEstadistica(){
        AdnJDBC AdnJDBC =  new AdnJDBC();
        Connection conn = AdnJDBC.getConnection();
        //String adn="ATGAAA-AGAAAG-CAGATG-ACATGA-CCTGCC-TTGATA";
        String adn ="ATAG-AGGC-ATGT-CGAA";

        Persona per = new Persona(adn,1);

        assertEquals(true,AdnJDBC.insertEstadistica(per));

        AdnJDBC.closeConnection();
    }


    @Test
    public void getCantidadEstadistica(){
        String adn="ATGAAA-AGAAAG-CAGATG-ACATGA-CCTGCC-TTGATA";
        AdnJDBC AdnJDBC =  new AdnJDBC();
        Connection conn = AdnJDBC.getConnection();

        assertEquals(4,AdnJDBC.getCantidadEstadistica(adn));

        AdnJDBC.closeConnection();
    }

}