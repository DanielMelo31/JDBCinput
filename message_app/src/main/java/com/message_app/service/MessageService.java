package com.message_app.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.message_app.MessageDAO;
import com.message_app.model.Message;


public class MessageService {
    private Scanner scanner;
    private MessageDAO  messageDAO;
    private Message message;
    
    public void createMessage() throws SQLException, IOException {
        scanner = new  Scanner(System.in);

        System.out.println("Enter your message...");
        String messageContent = scanner.nextLine();

        System.out.println("Enter your name...");
        String author = scanner.nextLine();

        message = new Message();
        message.setMessage(messageContent);
        message.setAuthor(author);


        messageDAO = new MessageDAO();

        messageDAO.createMessage(message);
    }

    public void updateMessage() {
        scanner = new  Scanner(System.in);

        
        System.out.println("Enter your message...");
        String messageContent = scanner.nextLine();
        
        System.out.println("Enter your name...");
        String author = scanner.nextLine();

        System.out.println("Enter the message ID...");
        int messageID = scanner.nextInt();

        message = new Message();
        message.setId_messages(messageID);
        message.setMessage(messageContent);
        message.setAuthor(author);
        
        messageDAO = new MessageDAO();
        messageDAO.updateMessage(messageID, message);
    }

    public void deleteMessage(){
        scanner = new  Scanner(System.in);

        System.out.println("Enter the message ID...");
        int messageID = scanner.nextInt();

        messageDAO = new MessageDAO();
        messageDAO.deleteMessage(messageID);
    }
}
