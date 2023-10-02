package g.library.services.implementations;

import g.library.enums.BookStatus;
import g.library.enums.MemberType;
import g.library.exceptions.BookException;
import g.library.functions.EnumConverter;
import g.library.functions.MemberComparator;
import g.library.models.Book;
import g.library.models.Member;
import g.library.models.Student;
import g.library.models.Teacher;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianImplementationTest {
    LibrarianImplementation librarianImplementation;
    Member member;
    Member junior;
    Member teacher;
    PriorityQueue<Member> priorityQueue;
    Queue<Member> queue;
    Book book;

    @BeforeEach
    void setUp() {
        librarianImplementation = new LibrarianImplementation();

        member = new Student(
                "Eva",
                "Ris",
                UUID.randomUUID(),
                EnumConverter.getGenderFromString("Male"),
                "Ss2",
                MemberType.SENIOR_STUDENT
        );

        junior = new Student(
                "Eva",
                "Ris",
                UUID.randomUUID(),
                EnumConverter.getGenderFromString("Male"),
                "Ss2",
                MemberType.JUNIOR_STUDENT
        );

        teacher = new Teacher(
                "Eva",
                "Ris",
                UUID.randomUUID(),
                EnumConverter.getGenderFromString("Male"),
                "Ss2"
        );

        book = new Book(
                "Tales of a thousand times",
                "Frank Edwards"
        );

        priorityQueue = new PriorityQueue<>(new MemberComparator());
        priorityQueue.add(member);
        priorityQueue.add(teacher);
        priorityQueue.add(junior);
        priorityQueue.add(teacher);
        priorityQueue.add(member);
        priorityQueue.add(teacher);
        priorityQueue.add(junior);

        queue = new LinkedList<>();
        queue.add(member);
        queue.add(teacher);
        queue.add(junior);
        queue.add(teacher);
        queue.add(member);
        queue.add(teacher);
        queue.add(junior);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void throwBookExceptionWhenBookIsNotInLibrary() {
        assertThrows(BookException.class, () -> librarianImplementation.searchBookByTitleAndAuthor(book));
    }

    @Test
    void shouldShowThatBookExistsInLibrary() {
        try {
            List<Book> books = new ArrayList<>();
            books.add(book);
            librarianImplementation.setBookList(books);

            assertEquals(book, librarianImplementation.searchBookByTitleAndAuthor(book));
        } catch (BookException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldAddCollectedBookToLibraryBookCollectedRegister() {
        assertInstanceOf(Map.class, librarianImplementation.addCollectedBookToRegister(member, book));
    }

    @Test
    void shouldGiveBookToMemberByPriority() {
        List<Book> books = new ArrayList<>();
        books.add(book);
        librarianImplementation.setBookList(books);

        try {
            assertEquals(teacher, librarianImplementation.checkoutBook(
                    priorityQueue,
                    book
            ));
        } catch (BookException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwBookNotAvailableExceptionWhileInPriority() {
        book.setStatus(BookStatus.NOT_AVAILABLE);
        assertThrows(BookException.class, () -> {
            librarianImplementation.checkoutBook(
                    priorityQueue,
                    book
            );
        });
    }

    @Test
    void shouldGiveBookToFirstPersonInTheQueue() {
        List<Book> books = new ArrayList<>();
        books.add(book);
        librarianImplementation.setBookList(books);

        try {
            assertEquals(member, librarianImplementation.checkoutBook(
                    queue,
                    book
            ));
        } catch (BookException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwBookNotAvailableException() {
        book.setStatus(BookStatus.NOT_AVAILABLE);
        assertThrows(BookException.class, () -> {
            librarianImplementation.checkoutBook(
                    queue,
                    book
            );
        });
    }

    @Test
    void shouldReturnTrueThatBookListHasBeenUpdatedUponBookReturn() {
        List<Book> books = new ArrayList<>();
        books.add(book);
        librarianImplementation.setBookList(books);

        assertTrue(librarianImplementation.updateLibraryData(member, book, true));
    }

    @Test
    void shouldReturnFalseThatBookListWasNotUpdatedUponReturn() {
        assertFalse(librarianImplementation.updateLibraryData(member, book, true));
    }

    @Test
    void shouldReturnTrueThatBookListHasBeenUpdatedUponBookRemoval() {
        List<Book> books = new ArrayList<>();
        books.add(book);
        librarianImplementation.setBookList(books);

        assertTrue(librarianImplementation.updateLibraryData(member, book, false));
    }

    @Test
    void shouldReturnFalseThatBookListWasNotUpdatedUponRemoval() {
        assertFalse(librarianImplementation.updateLibraryData(member, book, false));
    }
}