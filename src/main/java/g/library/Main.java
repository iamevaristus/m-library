package g.library;

import g.library.exceptions.BookException;
import g.library.functions.Commons;
import g.library.models.Book;
import g.library.models.Library;
import g.library.models.Member;
import g.library.services.implementations.LibrarianImplementation;
import g.library.services.implementations.MemberImplementation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibrarianImplementation librarianImplementation = new LibrarianImplementation();
        MemberImplementation memberImplementation = new MemberImplementation();

        List<Member> memberList = Commons.getMembers();
        List<Book> books = Commons.books();

        try {
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

            // Should give book by priority
            printEntry(library);

            Member byPriority = librarianImplementation.checkoutBook(library.getMemberQueue(), book);
            System.out.println("Book given by priority to " + byPriority.getMemberType() + "\n\n");

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

            printEntry(library);

            // Should give book by first - in - first - out
            Member fifo = librarianImplementation.checkoutBook(library.getMemberQueue(), book);
            System.out.println("Book given to " + fifo.getMemberType() + " as the first in queue.");
        } catch (BookException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printEntry(Library library) {
        System.out.println("These person are requesting for this book...");
        for(Member mem : library.getMemberQueue()) {
            System.out.println(mem.getMemberType());
        }
    }
}