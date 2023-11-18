package com.library.services;

import com.library.models.Library;
import com.library.models.User;

import java.util.ArrayList;

@FunctionalInterface
public interface LibrarianService {
    /**
     * This will check out the queue according to either priority or normal queue.
     * @return User the book was given to.
     */
    User checkoutBook();

    /**
     * Update the collected register in the library
     * @param user, person who requested for the book.
     * @return True or false
     */
    default boolean updateCollectedBookRegister(User user) {
        var register = Library.collectedBooksRegister;
        // Update books in the library
        Library.bookInventory.stream().takeWhile(book ->
                book.getTitle().equalsIgnoreCase(user.getBookCart().getTitle()) &&
                        book.getAuthor().equalsIgnoreCase(user.getBookCart().getAuthor())
        ).findAny().ifPresent(book -> book.setQuantity(book.getQuantity() - 1));
        return register.computeIfAbsent(user, put -> new ArrayList<>()).add(user.getBookCart());
    }
}