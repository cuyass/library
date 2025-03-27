package com.library.model.dao;
import java.sql.Connection;
import java.sql.Statement;

import com.library.utils.ConnectionDB;

public class BookDAO {

    public void createBook(Book book){
        try {
            Connection connection = ConnectionDB.initConnection();
            Statement stmn = connection.createStatement();
            String sql = "INSERT TO Library (title, description, isbn, author, genre, isAvailable) VALUES ('" + book.getTitle() + " ' , " + book.getDescription() + " ' , " +  book.getIsbn() + book.getAuthor() + " ', " + book.getGenre() + " ', true)";
            stmn.executeUpdate(sql);
            System.out.println("Book added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection();
        }
    }
}
