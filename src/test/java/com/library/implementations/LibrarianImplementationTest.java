package com.library.implementations;

import com.library.enums.Role;
import com.library.exceptions.BookException;
import com.library.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianImplementationTest {
    LibrarianImplementation librarianImplementation = new LibrarianImplementation();
    UserImplementation userImplementation = new UserImplementation();
    User seniorUser = User.builder().role(Role.SENIOR_STUDENT).build();
    User juniorUser = User.builder().role(Role.JUNIOR_STUDENT).build();
    User teacherUser = User.builder().role(Role.TEACHER).build();

    @Test
    void checkoutBook() {
        try {
            userImplementation.requestBook(
                    "Pride and Prejudice",
                    "Jane Austen",
                    seniorUser
            );
            userImplementation.requestBook(
                    "The Harry Potter series",
                    "J.K. Rowling",
                    juniorUser
            );
            userImplementation.requestBook(
                    "The Hunger Games trilogy",
                    "Suzanne Collins",
                    teacherUser
            );
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }

        assertInstanceOf(User.class, librarianImplementation.checkoutBook());
    }

    @Test
    void shouldUpdateRegister() {
        try {
            userImplementation.requestBook(
                    "Pride and Prejudice",
                    "Jane Austen",
                    seniorUser
            );
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }
        assertTrue(librarianImplementation.updateCollectedBookRegister(seniorUser));
    }
}