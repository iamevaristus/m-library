package g.library.ui;

import g.library.enums.MemberType;
import g.library.exceptions.BookException;
import g.library.functions.Commons;
import g.library.functions.EnumConverter;
import g.library.functions.MemberComparator;
import g.library.models.*;
import g.library.services.implementations.LibrarianImplementation;

import java.util.*;

public class Runner {
    static LibrarianImplementation librarianImplementation;
    static Student seniorStudent1;
    static Student juniorStudent1;
    static Teacher teacher;
    static Librarian librarian;

    static {
        librarianImplementation = new LibrarianImplementation();
        seniorStudent1 = new Student();
        juniorStudent1 = new Student();
        teacher = new Teacher();
        librarian = new Librarian(
                "Beauty",
                "Banks",
                UUID.randomUUID(),
                EnumConverter.getGenderFromString("Male")
        );
        librarianImplementation.setLibrarian(librarian);
        librarianImplementation.setBookList(Commons.books());

        Commons.printDebug("""
            Welcome to M-Library. We enrich your knowledge with our resources.
            I am %s, and as the librarian, am here for you.
        """.formatted(librarian.getFirstName()));
    }

    public static void run() {
        PriorityQueue<Member> priorityQueue = new PriorityQueue<>(new MemberComparator());
        Queue<Member> queue = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        Member member = RunnerInitializers.getMemberInfoFromInput(scanner, librarianImplementation.getLibrarian());

        juniorStudent1.setClassLevel("Jss1");
        juniorStudent1.setId(member.getId());
        juniorStudent1.setGender(member.getGender());
        juniorStudent1.setFirstName(member.getFirstName());
        juniorStudent1.setLastName(member.getLastName());
        juniorStudent1.setMemberType(MemberType.JUNIOR_STUDENT);
        juniorStudent1.setCollectedBooks(member.getCollectedBooks());

        seniorStudent1.setClassLevel("Ss1");
        seniorStudent1.setId(member.getId());
        seniorStudent1.setGender(member.getGender());
        seniorStudent1.setFirstName(member.getFirstName());
        seniorStudent1.setLastName(member.getLastName());
        seniorStudent1.setMemberType(MemberType.SENIOR_STUDENT);
        seniorStudent1.setCollectedBooks(member.getCollectedBooks());

        teacher.setSubject("English");
        teacher.setId(member.getId());
        teacher.setGender(member.getGender());
        teacher.setFirstName(member.getFirstName());
        teacher.setLastName(member.getLastName());
        teacher.setMemberType(MemberType.TEACHER);
        teacher.setCollectedBooks(member.getCollectedBooks());

        priorityQueue.add(seniorStudent1);
        priorityQueue.add(juniorStudent1);
        priorityQueue.add(teacher);

        queue.add(seniorStudent1);
        queue.add(juniorStudent1);
        queue.add(teacher);

        Book book = RunnerInitializers.getBookFromInput(scanner, member, librarianImplementation.getLibrarian());
        Commons.printDebug("Please wait a moment, we are checking if " + book.getTitle() + " exists...");
        Book foundBook = RunnerCheckers.checkIfBookExists(
                book,
                librarianImplementation,
                scanner,
                member,
                librarianImplementation.getLibrarian(),
                librarianImplementation.getBookList()
        );
        boolean isPriority = RunnerCheckers.chooseOption(scanner, member, librarianImplementation.getLibrarian(), foundBook);
        if(isPriority) {
            try {
                Member receiver = librarianImplementation.checkoutBook(priorityQueue, foundBook);
                Commons.printDebug(receiver.getFirstName() + "," + receiver.getMemberType() + " received the book, " + foundBook.getTitle());
            } catch (BookException e) {
                Commons.printError(e.getMessage());
            }
        } else {
            try {
                Member receiver = librarianImplementation.checkoutBook(queue, foundBook);
                Commons.printDebug(receiver.getFirstName() + "," + receiver.getMemberType() + " received the book, " + foundBook.getTitle());
            } catch (BookException e) {
                Commons.printError(e.getMessage());
            }
        }
    }
}
