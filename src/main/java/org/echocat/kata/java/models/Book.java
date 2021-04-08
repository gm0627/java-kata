package org.echocat.kata.java.models;

public class Book {
    private String title;
    private String isbn;
    private String author;
    private String description;

    public Book(String title, String isbn, String author, String description) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", isbn=" + isbn + ", author=" + author + ", description=" + description +"]";
    }
}
