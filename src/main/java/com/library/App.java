package com.library;
import java.util.Scanner;
import com.library.controller.BookController;
import com.library.model.BookDAO;
import com.library.view.BookView; 

public class App 
{ 
  private static final Scanner scanner = new Scanner(System.in);
    public static void main( String[] args )
    {
        System.out.println("Biblioteca");

      BookDAO bookDAO = new BookDAO(); 
      BookController bookController = new BookController(bookDAO);
      BookView bookView = new BookView(bookController);
      bookView.createBook(); closeScanner();
    }
    private static void closeScanner() {
        if(scanner != null) {
            scanner.close();
            System.out.println("scanner tancat");
        }
    }
}
