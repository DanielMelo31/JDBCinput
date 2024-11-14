package com.message_app.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.MessageDAO;
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
}
