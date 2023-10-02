package g.library.models;

import java.util.*;

public class Library {
    private Librarian librarian;

    private Map<Member, Book> collectedBooksRegister = new Hashtable<>();

    private List<Book> bookList = new ArrayList<>();

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Map<Member, Book> getCollectedBooksRegister() {
        return collectedBooksRegister;
    }

    public void setCollectedBooksRegister(Map<Member, Book> collectedBooksRegister) {
        this.collectedBooksRegister = collectedBooksRegister;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Library(
            Librarian librarian,
            Map<Member, Book> collectedBooksRegister,
            List<Book> bookList
    ) {
        this.librarian = librarian;
        this.collectedBooksRegister = collectedBooksRegister;
        this.bookList = bookList;
    }

    public Library() {}
}
