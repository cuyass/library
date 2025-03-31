package com.library.view;

import java.util.List;

import com.library.model.Book;

public class BookDisplayView {
    
    public void displayBookList(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No hi ha llibres a la biblioteca.");
            return;
        }
        
        for (Book book : books) {
            displayBasicBookInfo(book);
        }
    }

    public void displayFullBookDetails(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No s'han trobat llibres.");
            return;
        }
        
        for (Book book : books) {
            displayCompleteBookInfo(book);
        }
    }

    public void displayBooksByGenre(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No s'han trobat llibres amb aquest gènere.");
            return;
        }
        
        for (Book book : books) {
            displayBasicBookInfo(book);
        }
    }

    public void displaySingleBook(Book book) {
        if (book == null) {
            System.out.println("No s'ha trobat el llibre.");
            return;
        }
        
        displayCompleteBookInfo(book);
    }

    private void displayBasicBookInfo(Book book) {
        System.out.println("ID: " + book.getId());
        System.out.println("Títol: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor());
        System.out.println("Gènere: " + book.getGenre());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Disponible: " + (book.getIsAvailable() ? "Sí" : "No"));
        System.out.println("-----------------------");
    }

    private void displayCompleteBookInfo(Book book) {
        System.out.println("ID: " + book.getId());
        System.out.println("Títol: " + book.getTitle());
        System.out.println("Descripció: " + book.getDescription());
        System.out.println("Autor: " + book.getAuthor());
        System.out.println("Gènere: " + book.getGenre());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Disponible: " + (book.getIsAvailable() ? "Sí" : "No"));
        System.out.println("-----------------------");
    }
}

