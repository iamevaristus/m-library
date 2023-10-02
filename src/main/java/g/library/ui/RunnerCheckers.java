package g.library.ui;

import g.library.exceptions.BookException;
import g.library.functions.Commons;
import g.library.models.Book;
import g.library.models.Member;
import g.library.services.implementations.LibrarianImplementation;

import java.util.List;
import java.util.Scanner;

import static g.library.ui.RunnerInitializers.getStringLineInput;

public class RunnerCheckers {
    public static Book checkIfBookExists(
            Book book, LibrarianImplementation librarianImplementation,
            Scanner scanner, Member member, Member librarian, List<Book> books
    ) {
        try {
            return librarianImplementation.searchBookByTitleAndAuthor(book);
        } catch (BookException e) {
            Commons.printError(e.getMessage());
            Commons.printDebug("""
                From %s :::
                    Hi %s,
                    These are the books we have in our library at the moment...
            """.formatted(
                        librarian.getFirstName(),
                        member.getFirstName()
            ));

            for(Book libraryBook : books) {
                Commons.printDebug("""
                    Title: %s,
                    Author: %s
                """.formatted(
                            libraryBook.getTitle(),
                            libraryBook.getAuthor()
                ));
            }
            Book newBook = RunnerInitializers.getBookFromInput(scanner, member, librarian);
            return checkIfBookExists(newBook, librarianImplementation, scanner, member, librarian, books);
        }
    }

    public static boolean chooseOption(Scanner scanner, Member member, Member librarian, Book book) {
        Commons.printDebug("""
            From %s :::
                Hi %s,
                %s is being requested by multiple persons in our library. As a result of this, which is better?
                Sort: PRIORITY/NONE... Choose one by typing one of the options.
        """.formatted(
                librarian.getFirstName(),
                member.getFirstName(),
                book.getTitle()
        ));
        String priorityInput = getStringLineInput(scanner);

        return priorityInput.toLowerCase().contains("priority");
    }
}
