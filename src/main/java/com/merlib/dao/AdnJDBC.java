package com.merlib.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdnJDBC {

    Connection connection = null;
    String server="mysqlmerlib33.mysql.database.azure.com:3306";
    String bbdd ="merlib3";
    String user ="admin1@mysqlmerlib33";
    String password="BASEdatos3.";

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://"+ server +"/"+bbdd+"?user="+user+"&password="+password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            //do nothing
        }
    }

}
