package g.library.services.implementations;

import g.library.models.Book;
import g.library.models.Member;
import g.library.services.interfaces.MemberInterface;

import java.util.List;

public class MemberImplementation implements MemberInterface {
    @Override
    public Member requestForBook(String bookName, String authorOrCategory, Member member) {
        Book book = new Book(
                bookName,
                authorOrCategory
        );
        member.setBookCart(book);

        return member;
    }

    @Override
    public Book returnBook(Book book, Member member) {
        return book;
    }
}
