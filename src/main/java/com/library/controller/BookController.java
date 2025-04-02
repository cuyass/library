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

    public boolean createBook(Book book) throws SQLException {
        try {
            bookDAO.beginTransaction();
            boolean result = bookDAO.createBook(book);
            bookDAO.commit();
            return result;
        } catch (SQLException e) {
            bookDAO.rollback();
            throw e;
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        try {
            bookDAO.beginTransaction();
            List<Book> books = bookDAO.getAllBooks();
            bookDAO.commit();
            return books;
        } catch (SQLException e) {
            bookDAO.rollback();
            throw e;
        }
    }

    public Book getBookById(int id) throws SQLException {
        try {
            bookDAO.beginTransaction();
            Book book = bookDAO.getBookById(id);
            bookDAO.commit();
            return book;
        } catch (SQLException e) {
            bookDAO.rollback();
            throw e;
        }
    }

    public List<Book> getBooksByTitle(String title) throws SQLException {
        try {
            bookDAO.beginTransaction();
            List<Book> books = bookDAO.getBooksByTitle(title);
            bookDAO.commit();
            return books;
        } catch (SQLException e) {
            bookDAO.rollback();
            throw e;
        }
    }

    public List<Book> getBooksByAuthor(String author) throws SQLException {
        try {
            bookDAO.beginTransaction();
            List<Book> books = bookDAO.getBooksByAuthor(author);
            bookDAO.commit();
            return books;
        } catch (SQLException e) {
            bookDAO.rollback();
            throw e;
        }
    }

    public List<Book> getBooksByGenre(String genre) throws SQLException {
        try {
            bookDAO.beginTransaction();
            List<Book> books = bookDAO.getBooksByGenre(genre);
            bookDAO.commit();
            return books;
        } catch (SQLException e) {
            bookDAO.rollback();
            throw e;
        }
    }

    public boolean updateBook(Book book) throws SQLException {
        try {
            bookDAO.beginTransaction();
            boolean result = bookDAO.updateBook(book);
            bookDAO.commit();
            return result;
        } catch (SQLException e) {
            bookDAO.rollback();
            throw e;
        }
    }

    public boolean deleteBook(int id) throws SQLException {
        try {
            bookDAO.beginTransaction();
            boolean result = bookDAO.deleteBook(id);
            bookDAO.commit();
            return result;
        } catch (SQLException e) {
            bookDAO.rollback();
            throw e;
        }
    }
}