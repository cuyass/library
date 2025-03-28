package com.library.service;

import com.library.model.Book;
import com.library.model.dao.BookDAO;

public class BookController {
    
        public BookController(BookDAO bookDAO) {
            this.bookDAO = bookDAO;
    }

    public void createBook(Book book) {
        bookDAO.createBook(book);
    }


	
}
