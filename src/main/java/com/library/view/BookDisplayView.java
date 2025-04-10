package com.library.view;

import java.util.List;

import com.library.model.Book;

public class BookDisplayView {

    public void displayBookList(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("      __..._   _...__");
            System.out.println("__..-\"      `Y`      \"-._");
            System.out.println("\\\\ La        |           /");
            System.out.println("\\\\\\ biblio-  |     és   //");
            System.out.println("\\\\\\\\  teca   |  buida  ///");
            System.out.println(" \\\\\\\\        |.---.._ ///");
            System.out.println("  \\\\\\\\_..---.Y.---.._/// ");
            System.out.println("   '`               `'");
            return;
        }

        for (Book book : books) {
            displayBasicBookInfo(book);
        }
    }

    public void displayFullBookDetails(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("\nNo s'han trobat llibres.\n");
            return;
        }

        for (Book book : books) {
            displayCompleteBookInfo(book);
        }
    }

    public void displayBooksByGenre(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("\nNo s'han trobat llibres amb aquest gènere.\n");
            return;
        }

        for (Book book : books) {
            displayBasicBookInfo(book);
        }
    }

    public void displaySingleBook(Book book) {
        if (book == null) {
            System.out.println("\nNo s'ha trobat el llibre.\n");
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
