package com.merlib.dao;

import com.merlib.models.Persona;

import java.sql.*;

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

    public int getCantidadTipo(int tipo) {
        // List<Person> persons = new LinkedList<Person>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(tipo) 'total'  from stadistic where tipo = " + tipo);

            int total = 0;
            if(resultSet.next()){
                total = resultSet.getInt("total");
            }

            resultSet.close();
            statement.close();
            return  total;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean insertEstadistica(Persona persona) {
        boolean resp = false;

        try {
            String sql ="insert into stadistic (adn, tipo)  " +
                        "values ('"+ persona.getAdn() +"',"+ persona.getTipo() +")";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString(1,  person.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            resp = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resp;
    }


    public int getCantidadEstadistica(String adn) {
        // List<Person> persons = new LinkedList<Person>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(tipo) 'total'  from stadistic " +
                                                              "where adn = '" + adn +"'");

            int total = 0;
            if(resultSet.next()){
                total = resultSet.getInt("total");
            }

            resultSet.close();
            statement.close();
            return  total;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
