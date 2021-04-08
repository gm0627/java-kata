package org.echocat.kata.java.models;

public class Magazine {
    private String title;
    private String isbn;
    private String authors;
    private String publishedAt;

    public Magazine(String title, String isbn, String authors, String publishedAt) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.publishedAt = publishedAt;
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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
