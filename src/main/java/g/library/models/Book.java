package g.library.models;

import g.library.enums.BookStatus;

import java.util.Calendar;
import java.util.Objects;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publishDate;
    private String genre;
    private String ISBN;
    private String description;
    private int numberOfCopies;
    private BookStatus status;

    /// SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /// GETTERS

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public String getGenre() {
        return genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getDescription() {
        return description;
    }

    public BookStatus getStatus() {
        return status;
    }

    public Book(
            int id,
            String title,
            String author,
            String publishDate,
            int numberOfCopies,
            String genre,
            String ISBN,
            String description,
            BookStatus status
    ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.description = description;
        this.numberOfCopies = numberOfCopies;
        this.status = status;
        this.genre = genre;
        this.ISBN = ISBN;
    }

    public Book(
            String title,
            String author
    ) {
        this.title = title;
        this.author = author;
        this.publishDate = Calendar.getInstance().getTime().toString();
        this.description = "Library Description";
        this.numberOfCopies = 20;
        this.status = BookStatus.AVAILABLE;
        this.genre = "History";
        this.ISBN = "ISBN-1234-1234-5677-3423-43423";
    }

    public Book() {}

    public boolean isAvailable() {
        return getStatus() == BookStatus.AVAILABLE;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book book) {
            return id == book.id
                    && Objects.equals(title, book.title)
                    && Objects.equals(author, book.author);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }

    @Override
    public String toString() {
        return """
               Information on this book go as follows:
                    Id: %s,
                    Title: %s,
                    Author: %s,
                    Publish Date: %s,
                    Genre: %s,
                    ISBN: %s,
                    Description: %s,
                    Number of copies: %s,
                    Status: %s
                """.formatted(
                        id,
                title,
                author,
                publishDate,
                genre,
                ISBN,
                description,
                numberOfCopies,
                status
        );
    }
}
