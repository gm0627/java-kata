package org.echocat.kata.java.manager;

import org.echocat.kata.java.csv.CSVImporter;
import org.echocat.kata.java.models.Author;
import org.echocat.kata.java.models.Book;
import org.echocat.kata.java.models.Magazine;
import org.echocat.kata.java.part1.MainApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryManager {
    final private String booksPath = "src/main/resources/org/echocat/kata/java/part1/data/books.csv";
    final private String authorsPath = "src/main/resources/org/echocat/kata/java/part1/data/authors.csv";
    final private String magazinesPath = "src/main/resources/org/echocat/kata/java/part1/data/magazines.csv";
    protected static LibraryManager instance = new LibraryManager();

    List<Book> books= new ArrayList<>();
    List<Author> autors= new ArrayList<>();;
    List<Magazine> magazines= new ArrayList<>();;

    public static LibraryManager getInstance() {
        if(instance == null) {
            throw new RuntimeException("Internationalization has to be initialized when getInstance() is first called");
        }
        return instance;
    }

    private LibraryManager() {
        // load Data from CSV
        try {
            readDataFromCSV(booksPath, attributes -> {
                books.add(createBook(attributes));
            });
            readDataFromCSV(authorsPath, attributes -> {
                autors.add(createAuthor(attributes));
            });
            readDataFromCSV(magazinesPath, attributes -> {
                magazines.add(createMagazine(attributes));
            });
        }catch (Exception ex){

        }

        System.out.println(books);

    }
    private static void readDataFromCSV(String fileName, Consumer<String[]> onLoad) throws Exception {
        Path pathToFile = Paths.get(fileName.trim());
         new BufferedReader(new FileReader(fileName))
                .lines()
                .skip(1) //Skips the first n lines, in this case 1
                .forEach(s -> {
                    String[] attributes = s.split(";");
                    onLoad.accept(attributes);
                });

        // return books;
    }
    private static Book createBook(String[] metadata) {
        String title = metadata[0];
        String isbn = metadata[1];
        String author = metadata[2];
        String description=metadata[3];
        return new Book(title, isbn, author,description);
    }
    private static Author createAuthor(String[] metadata) {
        String email = metadata[0];
        String firstName = metadata[1];
        String lastName = metadata[2];

        return new Author(firstName, lastName, email);
    }
    private static Magazine createMagazine(String[] metadata) {
        String title = metadata[0];
        String isbn = metadata[1];
        String author = metadata[2];
        String publishedAt = metadata[3];
        return new Magazine(title, isbn, author, publishedAt);
    }

    public List<Book> findBookByISBN(String isbn){
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).collect(Collectors.toList());
    }
    public List<Magazine> findMagazinesByISBN(String isbn){
        return magazines.stream().filter(magazine -> magazine.getIsbn().equals(isbn)).collect(Collectors.toList());
    }

    public void findBooksMagazinesByEmail(String email){
        List<Book> book = books.stream().filter(magazine -> magazine.getAuthor().equals(email)).collect(Collectors.toList());
        List<Magazine> mag = magazines.stream().filter(magazine -> magazine.getAuthors().equals(email)).collect(Collectors.toList());
        System.out.println(book);
        System.out.println(mag);
    }

}
