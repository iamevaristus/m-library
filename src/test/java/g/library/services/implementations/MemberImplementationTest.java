package g.library.services.implementations;

import g.library.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberImplementationTest {
    Book book;
    MemberImplementation memberImplementation;

    @BeforeEach
    void apply() {
        book = new Book(
                "Tales of a thousand times",
                "Frank Edwards"
        );

        memberImplementation = new MemberImplementation();
    }

    @Test
    void shouldReturnTheBookTheMemberIsRequestingFor() {
        assertInstanceOf(Book.class, memberImplementation.requestForBook(
                "Love is the answer",
                "Romance"
        ));
    }

    @Test
    void shouldReturnTheBookTheMemberWantsToReturn() {
        assertEquals(book, memberImplementation.returnBook(book));
    }
}