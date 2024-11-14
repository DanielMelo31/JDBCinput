package com.message_app.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;
    private static Connection myConnection;

    public static Connection getInstance() throws IOException, SQLException {
        Properties properties = new Properties();
        FileInputStream fiStream = new FileInputStream("message_app\\config.properties");
        properties.load(fiStream);

        try{  
            myConnection = DriverManager.getConnection(
            properties.getProperty("dbUrl"), properties.getProperty("dbUser"), properties.getProperty("dbPassword"));
            
     
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Error in connection");
        }
        return myConnection;
    }
}
