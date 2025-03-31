package com.library.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.library.config.ConnectionDB;

import java.util.List;

public class BookDAO {

    public void createBook(Book book){
        try {
            Connection connection = ConnectionDB.initConnection();
            String sql = "INSERT INTO Library (title, description, isbn, author, genre, isAvailable) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmn = connection.prepareStatement(sql);
            pstmn.setString(1, book.getTitle());
            pstmn.setString(2, book.getDescription());
            pstmn.setString(3, book.getIsbn());
            pstmn.setString(4, book.getAuthor());
            pstmn.setString(5, book.getGenre());
            pstmn.setBoolean(6, true);
            
            pstmn.executeUpdate();
            System.out.println("El llibre s'ha afegit correctament");
        } catch (Exception e) {
            System.out.println("Error en afegir el llibre: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection();
        }
    }
}

//crear public List<Book> getAllBooks() {

// crear  public Book getBookById(int id) {
    
// crear   public List<Book> getBooksByTitle(String title)

// crear   public List<Book> getBooksByAuthor(String author) {

// crear  public List<Book> getBooksByGenre(String genre) {

// crear  public List<Book> getAvailableBooks() {

// crear  public List<Book> getBooksByAuthor(String author) {

// crear  public void updateBook(Book book) {

// crear  public void deleteBook(int id) {