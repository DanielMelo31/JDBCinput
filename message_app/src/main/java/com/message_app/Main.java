package com.message_app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.message_app.service.MessageService;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        MessageService messageService = new MessageService();
        MessageDAO messageDAO = new MessageDAO();

        // try 
        // (    
        //     Connection myConnection = connector.getInstance();
        //     Statement myStatement = myConnection.createStatement();
        //     ResultSet myResultSet = myStatement.executeQuery("Select * from message")
        //     ){
        //         while (myResultSet.next()) {
        //             System.out.println(myResultSet.getString("author"));
        //         }
            
        // } catch (Exception e) {
        // }

        int option = 0;

        do {
            System.out.println("--------------------");
            System.out.println("Message app");
            System.out.println("1. Create a message");
            System.out.println("2. Read messages");
            System.out.println("3. Edit message");
            System.out.println("4. Delete message");
            System.out.println("5. Exit");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    messageService.createMessage();
                    break;
                case 2:
    
                    messageDAO.readMessage().forEach(System.out::println);
                break;
                case 3:

                    messageService.updateMessage();
                    break;
                case 4:

                    messageService.deleteMessage();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (option != 5);

        

    }
}