package g.library.services.implementations;

import g.library.models.Book;
import g.library.services.interfaces.MemberInterface;

public class MemberImplementation implements MemberInterface {
    @Override
    public Book requestForBook(String bookName, String authorOrCategory) {
        return new Book(
                bookName,
                authorOrCategory
        );
    }

    @Override
    public Book returnBook(Book book) {
        return book;
    }
}
