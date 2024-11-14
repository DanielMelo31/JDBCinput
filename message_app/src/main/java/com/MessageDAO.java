package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.message_app.model.Message;
import com.message_app.utils.DBConnector;


public class MessageDAO {

    private static Connection getConnection() throws IOException, SQLException{
        return DBConnector.getInstance();
    }
 
    public void createMessage(Message message) throws SQLException, IOException{
        try {
            PreparedStatement myPreparedStatement = getConnection().prepareStatement(
                "insert into message(message, author) values(?,?)");

            myPreparedStatement.setString(1, message.getMessage());
            myPreparedStatement.setString(2, message.getAuthor());

            myPreparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while creating a new message");
        }
    }

    public List<Message> readMessage(){
        List<Message> messages = new ArrayList<>();
        try (
            Statement myStatement = getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery("Select * from message");
        )
        {
            while(myResultSet.next()){
                Message message = createMessage(myResultSet);
                messages.add(message);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading a user");
        }

        return messages;
    }

    public static void updateMessage(int id) {

    }

    public static void deleteMessage(int id) {

    }

    public static Message createMessage(ResultSet resultSet) throws SQLException {
        Message message = new Message();

        message.setMessage(resultSet.getString("message"));
        message.setAuthor(resultSet.getString("author"));
        message.setMessage_date(resultSet.getDate("message_date"));

        return message;
        
    }
}
