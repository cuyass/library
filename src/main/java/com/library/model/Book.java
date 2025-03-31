package main.java.com.library.model;

public class Book {
    private int id;
    private String title;
    private String description;
    private String isbn;
    private boolean isAvailable;
    private String author;
    private String genre;

    public Book(String title, String description, String isbn, String author, String genre){
        this.title=title;
        this.description=description;
        this.isbn=isbn;
        this.available=true;
        this.author=author;
        this.genre=genre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
	
}
