package com.message_app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.message_app.utils.DBConnector;

public class Main {
    public static void main(String[] args) {
        DBConnector connector = new DBConnector();

        try 
        (
            Connection myConnection = connector.getConnection();
            Statement myStatement = myConnection.createStatement();
            ResultSet myResultSet = myStatement.executeQuery("Select * from message")
            ){
                while (myResultSet.next()) {
                    System.out.println(myResultSet.getString("author"));
                }
            
        } catch (Exception e) {
        }

    }
}