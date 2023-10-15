package com.library.implementations;

import com.library.enums.Role;
import com.library.enums.Status;
import com.library.exceptions.BookException;
import com.library.models.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserImplementationTest {
    UserImplementation userImplementation = new UserImplementation();
    User seniorUser = User.builder().role(Role.SENIOR_STUDENT).build();

    @Test
    void requestBook() {
        try {
            assertEquals(Status.REQUESTED, userImplementation.requestBook(
                    "The Twilight Saga",
                    "Stephenie Meyer",
                    seniorUser
            ));
        } catch (BookException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwBookExceptionNotFound() {
        assertThrows(BookException.class, () -> userImplementation.requestBook(
                "Thing fall apart",
                "Chinua Achebe",
                seniorUser
        ));
    }

    @Test
    void throwBookExceptionNotAvailable() {
        assertThrows(BookException.class, () -> userImplementation.requestBook(
                "Things fall apart",
                "Chinua Achebe",
                seniorUser
        ));
    }

    @Test
    void checkIfBookIsInLibrary() {
        assertInstanceOf(Optional.class, userImplementation.checkIfBookExistByAuthorAndTitle(
                "The Twilight Saga",
                "Stephenie Meyer"
        ));
    }
}