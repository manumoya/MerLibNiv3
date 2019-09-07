package com.merlib.dao;

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
        AdnJDBC AdnJDBC =  new AdnJDBC();
        Connection conn = AdnJDBC.getConnection();
        AdnJDBC.closeConnection();
        assertNotNull(conn);



    }

}
