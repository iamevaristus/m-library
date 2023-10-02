package g.library.services.implementations;

import g.library.exceptions.BookException;
import g.library.exceptions.ExceptionStrings;
import g.library.models.Book;
import g.library.models.Library;
import g.library.models.Member;
import g.library.services.interfaces.LibrarianInterface;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LibrarianImplementation extends Library implements LibrarianInterface {
    @Override
    public Member checkoutBook(PriorityQueue<Member> priorityQueue, Book book) throws BookException{
        if (book.isAvailable()) {
            // Check out the book to the member at the front of the queue
            Member prioritizedMember = priorityQueue.poll();
            updateLibraryData(prioritizedMember, book, false);
            return prioritizedMember;
        }
        throw new BookException(ExceptionStrings.BOOK_IS_NOT_AVAILABLE);
    }

    @Override
    public Member checkoutBook(Queue<Member> queue, Book book) throws BookException {
        Book bookFound = searchBookByTitleAndAuthor(book);
        if (bookFound.isAvailable()) {
            // Check out the book to the member at the front of the queue
            Member memberAtFrontOfQueue = queue.poll();
            updateLibraryData(memberAtFrontOfQueue, book, false);
            return memberAtFrontOfQueue;
        }
        throw new BookException(ExceptionStrings.BOOK_IS_NOT_AVAILABLE);
    }

    @Override
    public Book searchBookByTitleAndAuthor(Book book) throws BookException{
        for(Book libraryBook : getBookList()) {
            boolean authorMatches = libraryBook.getAuthor()
                    .replace(" ", "")
                    .equalsIgnoreCase(book.getAuthor().replace(" ", ""));
            boolean titleMatches = libraryBook.getTitle()
                    .replace(" ", "")
                    .equalsIgnoreCase(book.getTitle().replace(" ", ""));
            if(authorMatches && titleMatches) {
                return libraryBook;
            }
        }
        throw new BookException(ExceptionStrings.BOOK_NOT_FOUND);
    }

    @Override
    public Map<Member, Book> addCollectedBookToRegister(Member member, Book book) {
        Map<Member, Book> existingCollection = getCollectedBooksRegister();
        existingCollection.put(member, book);
        setCollectedBooksRegister(existingCollection);
        return existingCollection;
    }

    @Override
    public boolean updateLibraryData(Member member, Book book, boolean isReturning) {
        // Add Collected book to register
        addCollectedBookToRegister(member, book);

        // Minus 1 from book quantity
        for(Book libraryBook : getBookList()) {
            boolean authorMatches = libraryBook.getAuthor()
                    .replace(" ", "")
                    .equalsIgnoreCase(book.getAuthor().replace(" ", ""));
            boolean titleMatches = libraryBook.getTitle()
                    .replace(" ", "")
                    .equalsIgnoreCase(book.getTitle().replace(" ", ""));
            if(authorMatches && titleMatches) {
                int remainingCopies;
                if(isReturning) {
                    remainingCopies = book.getNumberOfCopies() + 1;
                } else {
                    remainingCopies = book.getNumberOfCopies() - 1;
                }
                book.setNumberOfCopies(remainingCopies);
                return true;
            }
        }
        return false;
    }
}
