package g.library.services.interfaces;

import g.library.exceptions.BookException;
import g.library.models.Book;
import g.library.models.Member;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public interface LibrarianInterface {
    Member checkoutBook(PriorityQueue<Member> priorityQueue, Book book) throws BookException;

    Member checkoutBook(Queue<Member> queue, Book book) throws BookException;

    Book searchBookByTitleAndAuthor(Book book) throws BookException;

    Map<Member, Book> addCollectedBookToRegister(Member member, Book book);

    boolean updateLibraryData(Member member, Book book, boolean isReturning);
}
