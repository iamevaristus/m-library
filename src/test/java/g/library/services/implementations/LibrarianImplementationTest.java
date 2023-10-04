package g.library.services.implementations;

import g.library.enums.BookStatus;
import g.library.enums.MemberType;
import g.library.exceptions.BookException;
import g.library.functions.Commons;
import g.library.functions.EnumConverter;
import g.library.functions.MemberComparator;
import g.library.models.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianImplementationTest {
    LibrarianImplementation librarianImplementation = new LibrarianImplementation();
    MemberImplementation memberImplementation = new MemberImplementation();
    Library library = new Library();
    List<Member> memberList = Commons.getMembers();
    List<Book> books = Commons.books();
    Book book;

    @BeforeEach
    void setUp() {
        book = new Book(
                "Tales of a thousand times",
                "Frank Edwards"
        );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void throwBookExceptionWhenBookIsNotInLibrary() {
        assertThrows(BookException.class, () -> librarianImplementation.searchBookByTitleAndAuthor(
                book,
                books
        ));
    }

    @Test
    void shouldShowThatBookExistsInLibrary() {
        try {
            assertEquals(books.get(0), librarianImplementation.searchBookByTitleAndAuthor(
                    books.get(0),
                    books
            ));
        } catch (BookException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldGiveBookToMemberByPriority() {
        Book book = books.get(0);
        Member juniorStudent = memberImplementation.requestForBook(
                book.getTitle(),
                book.getAuthor(),
                memberList.get(0)
        );

        Member seniorStudent = memberImplementation.requestForBook(
                book.getTitle(),
                book.getAuthor(),
                memberList.get(2)
        );

        Member teacher = memberImplementation.requestForBook(
                book.getTitle(),
                book.getAuthor(),
                memberList.get(4)
        );

        library.getMemberQueue().add(seniorStudent);
        library.getMemberQueue().add(teacher);
        library.getMemberQueue().add(juniorStudent);
        try {
            assertEquals(teacher, librarianImplementation.checkoutBook(library.getMemberQueue(), book));
        } catch (BookException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwBookNotAvailableExceptionWhileInPriority() {
        Book book = books.get(0);
        book.setStatus(BookStatus.NOT_AVAILABLE);
        Member juniorStudent = memberImplementation.requestForBook(
                book.getTitle(),
                book.getAuthor(),
                memberList.get(0)
        );

        Member seniorStudent = memberImplementation.requestForBook(
                book.getTitle(),
                book.getAuthor(),
                memberList.get(2)
        );

        Member teacher = memberImplementation.requestForBook(
                book.getTitle(),
                book.getAuthor(),
                memberList.get(4)
        );

        library.getMemberQueue().add(seniorStudent);
        library.getMemberQueue().add(teacher);
        library.getMemberQueue().add(juniorStudent);
        assertThrows(BookException.class, () -> {
            librarianImplementation.checkoutBook(
                    library.getMemberQueue(),
                    book
            );
        });
    }

    @Test
    void shouldGiveBookToFirstPersonInTheQueue() {
        Book book1 = books.get(1);
        Book book2 = books.get(2);
        Member juniorStudent1 = memberImplementation.requestForBook(
                book1.getTitle(),
                book1.getAuthor(),
                memberList.get(1)
        );

        Member seniorStudent1 = memberImplementation.requestForBook(
                book2.getTitle(),
                book2.getAuthor(),
                memberList.get(3)
        );

        Member teacher1 = memberImplementation.requestForBook(
                book.getTitle(),
                book.getAuthor(),
                memberList.get(5)
        );

        library.getMemberQueue().clear();

        library.getMemberQueue().add(seniorStudent1);
        library.getMemberQueue().add(juniorStudent1);
        library.getMemberQueue().add(teacher1);
        try {
            assertEquals(seniorStudent1, librarianImplementation.checkoutBook(library.getMemberQueue(), book));
        } catch (BookException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldReturnTrueThatBookListHasBeenUpdatedUponBookReturn() {
        assertTrue(librarianImplementation.updateLibraryData(
                memberList.get(0),
                books.get(0),
                true,
                books
        ));
    }

    @Test
    void shouldReturnFalseThatBookListWasNotUpdatedUponReturn() {
        assertFalse(librarianImplementation.updateLibraryData(
                memberList.get(0),
                book,
                true,
                books
        ));
    }

    @Test
    void shouldReturnTrueThatBookListHasBeenUpdatedUponBookRemoval() {
        assertTrue(librarianImplementation.updateLibraryData(
                memberList.get(0),
                books.get(0),
                false,
                books
        ));
    }

    @Test
    void shouldReturnFalseThatBookListWasNotUpdatedUponRemoval() {
        assertFalse(librarianImplementation.updateLibraryData(
                memberList.get(0),
                book,
                false,
                books
        ));
    }
}