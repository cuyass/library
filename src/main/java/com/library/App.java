package com.library;

import com.library.controller.BookController;
import com.library.model.BookDAO;
import com.library.view.BookView; 

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Biblioteca - Library");

      BookDAO bookDAO = new BookDAO(); 
      BookController bookController = new BookController(bookDAO);
      BookView bookView = new BookView(bookController);
      bookView.createBook();
    }
}
