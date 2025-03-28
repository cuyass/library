package com.library.view;

import java.util.Scanner;

import com.library.model.Book;
import com.library.service.BookController;

public class BookView { 
     
    private BookController bookController;

    public BookView(BookController bookController) {
        this.bookController = bookController;
    }
	 
    public void createBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("escriu el titol del llibre");
        String title = scanner.nextLine();
        System.out.println("escriu l' autor del llibre");
        String author = scanner.nextLine();
        System.out.println("escriu el genere del llibre");
        String genre = scanner.nextLine();
        System.out.println("escriu l' isbn del llibre");
        String isbn = scanner.nextLine();
        System.out.println("escriu la descripcio del llibre");
        String description = scanner.nextLine();
        Book book = new Book(title, author, genre, isbn, description);
        bookController.createBook(book);
        scanner.close();
    }
}
