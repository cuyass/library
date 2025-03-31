package com.library.controller;

import java.util.List;
import com.library.model.Book;
import com.library.model.BookDAO;
import java.sql.*;


public class BookController {
    private final BookDAO bookDAO;

    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    
    public void createBook(Book book) throws SQLException {
        bookDAO.createBook(book);
    }
    
    public List<Book> getAllBooks() throws SQLException {
        return bookDAO.getAllBooks();
        
    }
    
    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }
    
    public List<Book> getBooksByTitle(String title) {
        return bookDAO.getBooksByTitle(title);
    }
    
    public List<Book> getBooksByAuthor(String author) {
        return bookDAO.getBooksByAuthor(author);
    }
    
    public List<Book> getBooksByGenre(String genre) {
        return bookDAO.getBooksByGenre(genre);
    }
    
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }
    
    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}

