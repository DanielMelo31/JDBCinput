package com.message_app.model;

import java.sql.Date;

public class Message {
    private int id_messages;
    private String message;
    private String author;
    private Date message_date;

    
    public Message(){
        
    }
    
    public Message(String message, String author) {
        this.message = message;
        this.author = author;
    }
    
    
    public int getId_messages() {
        return id_messages;
    }
    public void setId_messages(int id_messages) {
        this.id_messages = id_messages;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Date getMessage_date() {
        return message_date;
    }
    public void setMessage_date(Date message_date) {
        this.message_date = message_date;
    }
    
    
    @Override
    public String toString() {
        return "Message: " + message + " Author: " + author + " Date: " + message_date;
    }
}

