package com.library.view;

import java.util.Scanner;

import com.library.controller.BookController;
import com.library.model.Book;

public class BookView { 
     
    private final BookController bookController;
    private final Scanner scanner;
    

    public BookView(BookController bookController) {
        this.bookController = bookController;
        this.scanner = new Scanner(System.in);
    }
	 
    public void createBook() {
        System.out.println(" ===AFEGIR LLIBRE===");
        System.out.println("Escriu el titol del llibre");
        String title = scanner.nextLine();
        System.out.println("Escriu l'autor del llibre");
        String author = scanner.nextLine();
        System.out.println("Escriu el gènere del llibre");
        String genre = scanner.nextLine();
        System.out.println("Escriu l'ISBN del llibre");
        String isbn = scanner.nextLine();
        System.out.println("Escriu la descripció del llibre");
        String description = scanner.nextLine();
        
        if (description.length() > 200) {
            System.out.println("La descripció no pot tenir més de 200 caràcters.");
            return;
        }
        Book book = new Book(title, author, genre, isbn, description);
        bookController.createBook(book);
        scanner.close();
    }
}
