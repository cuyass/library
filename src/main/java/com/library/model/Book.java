package com.library.model;

public class Book {
    private int id;
    private String title;
    private String description;
    private String isbn;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(int id, String title, String description, String isbn, String author, String genre, boolean isAvailable) {
        this.id=id;
        this.title=title;
        this.description=description;
        this.isbn=isbn;
        this.author=author;
        this.genre=genre;
      /* this.isAvailable=isAvailable;*/
        this.isAvailable = true;
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

    public boolean getIsAvailable() {
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
