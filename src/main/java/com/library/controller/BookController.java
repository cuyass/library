package com.library.controller;

import java.sql.SQLException;
import java.util.List;

import com.library.model.Book;
import com.library.model.BookDAO;

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

    /* public Book getBookById(int id) throws SQLException {
        return bookDAO.getBookById(id);
    } */

    public List<Book> getBooksByTitle(String title) throws SQLException {
        return bookDAO.getBooksByTitle(title);
    }

    public List<Book> getBooksByAuthor(String author) throws SQLException {
        return bookDAO.getBooksByAuthor(author);
    }

    public List<Book> getBooksByGenre(String genre) throws SQLException {
        return bookDAO.getBooksByGenre(genre);
    }

    public void updateBook(Book book) throws SQLException {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id) throws SQLException {
        bookDAO.deleteBook(id);
    }
}