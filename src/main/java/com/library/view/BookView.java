package com.library.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.library.controller.BookController;
import com.library.model.Book;

public class BookView {
    private final BookController bookController;
    private final Scanner scanner;
    private final BookDisplayView displayView;

    public BookView(BookController bookController, Scanner scanner) {
        this.bookController = bookController;
        this.scanner = scanner;
        this.displayView = new BookDisplayView();
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n╔═══════════════════╗");
            System.out.println("║     Llibrenú      ║");
            System.out.println("╚═══════════════════╝\n");
            System.out.println("1. Crear llibre");
            System.out.println("2. Mostrar llibres");
            System.out.println("3. Buscar llibre per títol");
            System.out.println("4. Buscar llibre per autor");
            System.out.println("5. Buscar llibre per gènere");
            System.out.println("6. Editar llibre");
            System.out.println("7. Eliminar llibre");
            System.out.println("8. Sortir");
            System.out.print("Trieu una opció: ");

            try {
                int option = Integer.parseInt(scanner.nextLine().trim());

                switch (option) {
                    case 1 -> createBook();
                    case 2 -> showAllBooks();
                    case 3 -> findBooksByTitle();
                    case 4 -> findBooksByAuthor();
                    case 5 -> findBooksByGenre();
                    case 6 -> editBook();
                    case 7 -> deleteBook();
                    case 8 -> {
                        exit = true;
                        System.out.println("Adéu!");
                    }
                    default -> System.out.println("Opció no vàlida. Torna a intentar-ho.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Si us plau, introdueix un número vàlid.");
            } catch (Exception e) {
                System.out.println("S'ha produït un error: " + e.getMessage());
            }
        }
    }

    private void createBook() {
        try {
            System.out.println("Introdueix les dades del llibre:");
            System.out.print("Títol: ");
            String title = scanner.nextLine().trim();
            System.out.print("Descripció: ");
            String description = scanner.nextLine().trim();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine().trim();
            System.out.print("Autor: ");
            String author = scanner.nextLine().trim();
            System.out.print("Gènere: ");
            String genre = scanner.nextLine().trim();

            Book newBook = new Book ( title, description, isbn, author, genre, true);
            boolean created = bookController.createBook(newBook);
            
            if (created) {
                System.out.println("Llibre creat amb èxit!");
            } else {
                System.out.println("No s'ha pogut crear el llibre.");
            }
        } catch (SQLException e) {
            System.out.println("Error al crear el llibre: " + e.getMessage());
        }
    }

    private void showAllBooks() {
        try {
            List<Book> books = bookController.getAllBooks();
            displayView.displayBookList(books);
        } catch (SQLException e) {
            System.out.println("Error en mostrar els llibres: " + e.getMessage());
        }
    }

    private void findBooksByTitle() {
        try {
            System.out.print("Introdueix el títol a buscar: ");
            String title = scanner.nextLine().trim();
            List<Book> books = bookController.getBooksByTitle(title);
            displayView.displayFullBookDetails(books);
        } catch (SQLException e) {
            System.out.println("Error en buscar llibres per títol: " + e.getMessage());
        }
    }

    private void findBooksByAuthor() {
        try {
            System.out.print("Introdueix l'autor a buscar: ");
            String author = scanner.nextLine().trim();
            List<Book> books = bookController.getBooksByAuthor(author);
            displayView.displayFullBookDetails(books);
        } catch (SQLException e) {
            System.out.println("Error en buscar llibres per autor: " + e.getMessage());
        }
    }

    private void findBooksByGenre() {
        try {
            System.out.print("Introdueix el gènere a buscar: ");
            String genre = scanner.nextLine().trim();
            List<Book> books = bookController.getBooksByGenre(genre);
            displayView.displayBooksByGenre(books);
        } catch (SQLException e) {
            System.out.println("Error en buscar llibres per gènere: " + e.getMessage());
        }
    }

    private void editBook() {
        try {
            System.out.print("Introdueix l'ID del llibre a editar: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            Book book = bookController.getBookById(id);

            if (book == null) {
                System.out.println("No s'ha trobat cap llibre amb aquest ID.");
                return;
            }

            displayView.displaySingleBook(book);
            System.out.println("Introdueix les noves dades (deixeu en blanc per mantenir les actuals):");

            System.out.print("Títol [" + book.getTitle() + "]: ");
            String title = scanner.nextLine().trim();
            if (!title.isEmpty()) {
                book.setTitle(title);
            }

            System.out.print("Descripció [" + book.getDescription() + "]: ");
            String description = scanner.nextLine().trim();
            if (!description.isEmpty()) {
                book.setDescription(description);
            }

            System.out.print("ISBN [" + book.getIsbn() + "]: ");
            String isbn = scanner.nextLine().trim();
            if (!isbn.isEmpty()) {
                book.setIsbn(isbn);
            }

            System.out.print("Autor [" + book.getAuthor() + "]: ");
            String author = scanner.nextLine().trim();
            if (!author.isEmpty()) {
                book.setAuthor(author);
            }

            System.out.print("Gènere [" + book.getGenre() + "]: ");
            String genre = scanner.nextLine().trim();
            if (!genre.isEmpty()) {
                book.setGenre(genre);
            }

            System.out.print("Disponible (true/false) [" + book.getIsAvailable() + "]: ");
            String available = scanner.nextLine().trim();
            if (!available.isEmpty()) {
                book.setIsAvailable(Boolean.parseBoolean(available));
            }

            boolean updated = bookController.updateBook(book);
            if (updated) {
                System.out.println("Llibre actualitzat amb èxit!");
            } else {
                System.out.println("No s'ha pogut actualitzar el llibre.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Si us plau, introduïu un ID vàlid.");
        } catch (SQLException e) {
            System.out.println("Error en editar el llibre: " + e.getMessage());
        }
    }

    private void deleteBook() {
        try {
            System.out.print("Introdueix l'ID del llibre a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            Book book = bookController.getBookById(id);

            if (book == null) {
                System.out.println("No s'ha trobat cap llibre amb aquest ID.");
                return;
            }

            displayView.displaySingleBook(book);
            System.out.print("Estàs segur que vols eliminar aquest llibre? (s/n): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("s")) {
                boolean deleted = bookController.deleteBook(id);
                if (deleted) {
                    System.out.println("Llibre eliminat amb èxit!");
                } else {
                    System.out.println("No s'ha pogut eliminar el llibre.");
                }
            } else {
                System.out.println("Operació cancel·lada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Si us plau, introdueix un ID vàlid.");
        } catch (SQLException e) {
            System.out.println("Error en eliminar el llibre: " + e.getMessage());
        }
    }
}