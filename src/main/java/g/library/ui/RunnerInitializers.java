package g.library.ui;

import g.library.enums.Gender;
import g.library.enums.MemberType;
import g.library.functions.Commons;
import g.library.functions.EnumConverter;
import g.library.models.Book;
import g.library.models.Member;
import g.library.models.Student;
import g.library.models.Teacher;

import java.util.Scanner;
import java.util.UUID;

public class RunnerInitializers {
    public static Book getBookFromInput(Scanner scanner, Member member, Member librarian) {
        Commons.printDebug("""
            From %s :::
                Hi %s,
                Type the book name and author/category you want.
                Format: Things fall apart, Chinua Achebe
        """.formatted(
                librarian.getFirstName(),
                member.getFirstName())
        );
        String bookInput = getStringLineInput(scanner);

        if(bookInput.contains(",")) {
            String[] bookInputArray = bookInput.split(",");
            return new Book(
                    bookInputArray[0],
                    bookInputArray[1]
            );
        } else {
            Commons.printError("Please separate your input like the given format.");
            return getBookFromInput(scanner, member, librarian);
        }
    }

    public static Member getMemberInfoFromInput(Scanner scanner, Member librarian) {
        Commons.printDebug("""
            From %s :::
            In order to enhance your experience while making request in this library and to help us with documentation, we need some details from you.
            What's your full name? Eg. Francis Baker
        """.formatted(librarian.getFirstName()));
        String fullNameInput = getStringLineInput(scanner);
        String[] nameArray = fullNameInput.split(" ");
        String firstName;
        String lastName;

        try {
            firstName = nameArray[0];
            lastName = nameArray[1];
        } catch (Exception e) {
            // The nameArray index is out of bounds. Assign a default value.
            firstName = fullNameInput;
            lastName = "M";
        }

        Commons.printDebug("""
            Are you a teacher, junior or senior student?
        """);

        String typeInput = getStringLineInput(scanner);
        MemberType type = EnumConverter.getStudentLevelFromString(typeInput);

        Commons.printDebug("""
            Gender___ MALE/FEMALE?
        """);

        String genderInput = getStringLineInput(scanner);
        Gender gender = EnumConverter.getGenderFromString(genderInput);

        if(type == MemberType.TEACHER) {
            return new Teacher(
                    firstName,
                    lastName,
                    UUID.randomUUID(),
                    gender,
                    "English, Mathematics"
            );
        } else {
            return new Student(
                    firstName,
                    lastName,
                    UUID.randomUUID(),
                    gender,
                    "Student",
                    type
            );
        }
    }

    public static String getStringLineInput(Scanner scanner) {
        String bookInput = scanner.nextLine();

        if(bookInput.isEmpty()) {
            return getStringLineInput(scanner);
        } else {
            return bookInput;
        }
    }
}
