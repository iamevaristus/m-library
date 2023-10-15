package com.library.services;

import com.library.enums.Status;
import com.library.exceptions.BookException;
import com.library.models.Book;
import com.library.models.Library;
import com.library.models.User;

import java.util.Optional;

@FunctionalInterface
public interface UserService {
    /**
     * This is the method which the user/person uses to request for a book in the library.
     * @param title String name of the book title in request.
     * @param author String name of the book author in request.
     */
    Status requestBook(String title, String author, User user) throws BookException;

    /**
     * This checks if the title and the author of a book the user/person wants to request for is in the library.
     * @param title String name of the book title in request.
     * @param author String name of the book author in request.
     * @return Optional Book.
     */
    default Optional<Book> checkIfBookExistByAuthorAndTitle(String title, String author) {
        return Library.bookInventory.stream().filter(book1 -> {
            boolean authorMatches = book1.getAuthor()
                    .replace(" ", "")
                    .equalsIgnoreCase(author.replace(" ", ""));
            boolean titleMatches = book1.getTitle()
                    .replace(" ", "")
                    .equalsIgnoreCase(title.replace(" ", ""));
            return authorMatches && titleMatches;
        }).findAny();
    }
}