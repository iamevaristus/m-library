package g.library.services.implementations;

import g.library.enums.MemberType;
import g.library.exceptions.BookException;
import g.library.exceptions.ExceptionStrings;
import g.library.functions.MemberComparator;
import g.library.models.Book;
import g.library.models.Member;
import g.library.services.interfaces.LibrarianInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LibrarianImplementation implements LibrarianInterface {
    @Override
    public Member checkoutBook(Queue<Member> memberQueue, Book book) throws BookException {
        PriorityQueue<Member> priorityQueue = new PriorityQueue<>(new MemberComparator());
        List<Member> members = new ArrayList<>(memberQueue);
        Member mem = members.get(0);
        for (Member member : memberQueue) {
            if (member.getBookCart().getTitle().equals(mem.getBookCart().getTitle())) {
                mem = member;
                priorityQueue.add(member);
            }
        }

        if (book.isAvailable()) {
            if (!priorityQueue.isEmpty()) {
                return priorityQueue.poll();
            } else {
                return memberQueue.poll();
            }
        }
        throw new BookException(ExceptionStrings.BOOK_IS_NOT_AVAILABLE);
    }

    @Override
    public Book searchBookByTitleAndAuthor(Book book, List<Book> books) throws BookException{
        for(Book libraryBook : books) {
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
    public boolean updateLibraryData(Member member, Book book, boolean isReturning, List<Book> books) {
        // Minus 1 from book quantity
        for(Book libraryBook : books) {
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
