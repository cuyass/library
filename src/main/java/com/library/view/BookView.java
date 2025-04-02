package com.library.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.library.controller.BookController;
import com.library.model.Book;

public class BookView { 
     
    private final BookController bookController;
    private final Scanner scanner;
    
    String[] options = {
        "1. Veure tots els llibres",
        "2. Buscar llibre per títol",
        "3. Buscar llibre per autor",
        "4. Buscar llibre per gènere",
        "5. Crear llibre nou",
        "6. Actualitzar llibre",
        "7. Eliminar llibre",
        "8. Sortir"
    };

    public BookView(BookController bookController, Scanner scanner) {
        this.bookController = bookController;
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("╔═══════════════════╗");
        System.out.println("║      Llibrenú     ║");
        System.out.println("╚═══════════════════╝");
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void handleUserInput() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.println("Escull una opció: ");
            
            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invàlida. Si us plau, entra un número.");
                continue;
            }
            try {
                switch (choice) {
                    case 1:
                        try {
                            List<Book> books = bookController.getAllBooks();
                            System.out.println("=== Tots els llibres ===\n");
                            if (books.isEmpty()) {
                                System.out.println(">>---> No s'han trobat llibres. <---<<");
                            } else {
                                for (Book book : books) {
                                    System.out.println(book);
                                }
                            }
                        } catch (SQLException e) {
                            System.err.println("Error al recuperar els llibres: " + e.getMessage());
                        }

                        System.out.println("\nPrem Enter per tornar al Llibrenú...");
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("Introdueix el títol del llibre: ");
                        String title = scanner.nextLine();
                        bookController.getBooksByTitle(title);
                        break;
                    case 3:
                        System.out.println("Introdueix l'autor del llibre: ");
                        String author = scanner.nextLine();
                        bookController.getBooksByAuthor(author);
                        break;
                    case 4:
                        System.out.println("Introdueix el gènere del llibre: ");
                        String genre = scanner.nextLine();
                        bookController.getBooksByGenre(genre);
                        break;
                    case 5:
                        try {
                            createBook();
                        } catch (SQLException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println("Introdueix l'ID del llibre a actualitzar: ");
                        int bookId = Integer.parseInt(scanner.nextLine());
                    
                        System.out.println("Introdueix el nou títol: ");
                        String newTitle = scanner.nextLine();
                        
                        System.out.println("Introdueix el nou autor: ");
                        String newAuthor = scanner.nextLine();
                        
                        System.out.println("Introdueix el nou gènere: ");
                        String newGenre = scanner.nextLine();
                        
                        Book updatedBook = new Book(newTitle, "", "", newAuthor, newGenre, true);
                        bookController.updateBook(updatedBook);
                        break;
                    case 7:
                        System.out.println("Introdueix l'ID del llibre a eliminar: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        bookController.deleteBook(deleteId);
                        break;
                    case 8:
                        System.out.println("Sortint...");
                        running = false;
                        break;
                    default:
                        System.out.println("Opció invàlida. Si us plau, torna-ho a provar.");
                }
            } catch (SQLException e) {
                System.out.println("Error en la base de dades: " + e.getMessage());
        }
    }}

    public void createBook() throws SQLException {
        System.out.println(" === Afegir llibre ===\n");
        System.out.println("Escriu el títol del llibre");
        String title = scanner.nextLine();
        System.out.println("Escriu l'autor del llibre");
        String author = scanner.nextLine();
        System.out.println("Escriu el gènere del llibre");
        String genre = scanner.nextLine();
        System.out.println("Escriu l'ISBN del llibre");
        String isbn = scanner.nextLine();
        System.out.println("Escriu la descripció del llibre");
        String description = scanner.nextLine();
        System.out.println("Llibre creat correctament!");
        
        if (description.length() > 200) {
            System.out.println("La descripció no pot tenir més de 200 caràcters.");
            return;
        }
        Book book = new Book(title, description, isbn, author, genre, true); 

        try {
            bookController.createBook(book);
        } catch (SQLException e) {
            System.out.println("Error al crear el llibre: " + e.getMessage());
        }
    }
}
