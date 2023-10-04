package g.library.services.interfaces;

import g.library.exceptions.BookException;
import g.library.models.Book;
import g.library.models.Member;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public interface LibrarianInterface {
    Member checkoutBook(Queue<Member> memberQueue, Book book) throws BookException;

    Book searchBookByTitleAndAuthor(Book book, List<Book> books) throws BookException;

    boolean updateLibraryData(Member member, Book book, boolean isReturning, List<Book> books);
}
