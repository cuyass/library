package com.library.model.dao;
import java.sql.Connection;
import java.sql.Statement;

import com\library\utils\ConnectionDB.java

public class BookDAO {

    public void createBook(Book book){
        try {
            Connection connection = ConnectionDB.initConnection();
            Statatement stmn = connection.createStatement();
            String sql = "INSERT TO Library (title, description, isbn, isAvailable, author, genre) VALUES ('" + book.getTitle() + " ' , " + book.getDescription() + " , " +  book.getIsbn() + ", true + " book.getAuthor() + " + " book.getGenre() ")";
            stmn.executeUpdate(sql);
            System.out.println("Book added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection();
        }
    }
}