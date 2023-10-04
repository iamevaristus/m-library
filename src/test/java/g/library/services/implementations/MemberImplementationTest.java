package g.library.services.implementations;

import g.library.functions.Commons;
import g.library.models.Book;
import g.library.models.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberImplementationTest {
    Book book;
    MemberImplementation memberImplementation;
    List<Member> memberList = Commons.getMembers();
    List<Book> books = Commons.books();

    @BeforeEach
    void apply() {
        book = new Book(
                "Tales of a thousand times",
                "Frank Edwards"
        );

        memberImplementation = new MemberImplementation();
    }

    @Test
    void shouldReturnTheTheMemberIsRequestingForABook() {
        assertInstanceOf(Member.class, memberImplementation.requestForBook(
                books.get(0).getTitle(),
                books.get(0).getAuthor(),
                memberList.get(0)
        ));
    }

    @Test
    void shouldReturnTheBookTheMemberWantsToReturn() {
        assertEquals(book, memberImplementation.returnBook(
                book,
                memberList.get(0)
        ));
    }
}