package com.library.model;

import java.sql.*;
import java.util.ArrayList;
import com.library.config.ConnectionDB;
import main.java.com.library.model.Book;
import java.util.List;

public class BookDAO {
    private static final Logger logger = Logger.getLogger(BookDAO.class.getName());
    private Connection connection;
    
    public void beginTransaction() throws SQLException {
        connection = ConnectionDB.initConnection();
        connection.setAutoCommit(false);
    }
    public void commit() throws SQLException {
        if (connection != null) {
            connection.commit();
            connection.close();
            connection = null;
        }
    }
    public void rollback() throws SQLException {
        if (connection != null) {
            connection.rollback();
            connection.close();
            connection = null;
        }
    }
   
    public void createBook(Book book) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("No hi ha una transacció activa");
        }
        String sql = "INSERT INTO books (title, description, isbn, author, genre, isAvailable) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
            pstmn.setString(1, book.getTitle());
            pstmn.setString(2, book.getDescription());
            pstmn.setString(3, book.getIsbn());
            pstmn.setString(4, book.getAuthor());
            pstmn.setString(5, book.getGenre());
            pstmn.setBoolean(6, true);
            pstmn.executeUpdate();
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("No hi ha una transacció activa");
        }
        String sql = "SELECT * FROM books";
        List<Book> books = new ArrayList<>();
        try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
            try (ResultSet rs = pstmn.executeQuery()) {
                while (rs.next()) {
                    books.add(mapResultSetToBook(rs));
                }
            }
        }
        return books;
    }

    public Book getBookById(int id) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("No hay transacción activa");
        }
        String sql = "SELECT * FROM books WHERE id = ?";
        try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
            pstmn.setInt(1, id);
            try (ResultSet rs = pstmn.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToBook(rs);
                }
            }
        }
        return null;
    }

    public List<Book> getBooksByField(String field, String value) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("No hi ha una transacció activa");
        }
        String sql = "SELECT * FROM books WHERE " + field + " ILIKE ?";
        List<Book> books = new ArrayList<>();
        try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
            pstmn.setString(1, "%" + value + "%");
            try (ResultSet rs = pstmn.executeQuery()) {
                while (rs.next()) {
                    books.add(mapResultSetToBook(rs));
                }
            }
        }
        return books;
    }

    public List<Book> getBooksByTitle(String title) throws SQLException {
        return getBooksByField("title", title);
    }

    public List<Book> getBooksByAuthor(String author) throws SQLException {
        return getBooksByField("author", author);
    }

    public List<Book> getBooksByGenre(String genre) throws SQLException {
        return getBooksByField("genre", genre);
    }

    public List<Book> getAvailableBooks() throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("No hi ha una transacció activa");
        }
        String sql = "SELECT * FROM books WHERE isAvailable = TRUE";
        List<Book> books = new ArrayList<>();
        try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
            try (ResultSet rs = pstmn.executeQuery()) {
                while (rs.next()) {
                    books.add(mapResultSetToBook(rs));
                }
            }
        }
        return books;
    }

    public void updateBook(Book book) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("No hi ha una transacció activa");
        }
        String sql = "UPDATE books SET title = ?, description = ?, isbn = ?, author = ?, genre = ?, isAvailable = ? WHERE id = ?";
        try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
            pstmn.setString(1, book.getTitle());
            pstmn.setString(2, book.getDescription());
            pstmn.setString(3, book.getIsbn());
            pstmn.setString(4, book.getAuthor());
            pstmn.setString(5, book.getGenre());
            pstmn.setBoolean(6, book.isAvailable());
            pstmn.setInt(7, book.getId());
            pstmn.executeUpdate();
        }
    }

    public void deleteBook(int id) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("No hi ha una transacció activa");
        }
        String sql = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
            pstmn.setInt(1, id);
            pstmn.executeUpdate();
        }
    }
  
    private Book mapResultSetToBook(ResultSet rs) throws SQLException {
        return new Book(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("isbn"),
            rs.getString("author"),
            rs.getString("genre"),
            rs.getBoolean("isAvailable")
        );
    }
}