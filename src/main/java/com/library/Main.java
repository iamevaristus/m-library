package com.library;

import com.library.enums.Role;
import com.library.enums.Status;
import com.library.exceptions.BookException;
import com.library.implementations.LibrarianImplementation;
import com.library.implementations.UserImplementation;
import com.library.models.Library;
import com.library.models.User;

public class Main {
    public static void main(String[] args) {
        UserImplementation userImplementation = new UserImplementation();
        User seniorUser = User.builder().role(Role.SENIOR_STUDENT).build();
        User juniorUser = User.builder().role(Role.JUNIOR_STUDENT).build();
        User teacherUser = User.builder().role(Role.TEACHER).build();
        try {
            Status status = userImplementation.requestBook(
                    "Pride and Prejudice",
                    "Jane Austen",
                    seniorUser
            );
            userImplementation.requestBook(
                    "The Harry Potter series",
                    "J.K. Rowling",
                    juniorUser
            );
            userImplementation.requestBook(
                    "The Hunger Games trilogy",
                    "Suzanne Collins",
                    teacherUser
            );
//            var wrapper = new Object(){ String value = ""; };
//            list.forEach(s->{
//                wrapper.value += "blah";
//            });
//            Or if you're stuck with Java 8 or 9, use the same kind of construct as we did above, but with an AtomicReference...
//
//            AtomicReference<String> value = new AtomicReference<>("");
//            list.forEach(s -> {
//                value.set(value.get() + s);
//            });
            System.out.println(status.getType());
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }

        LibrarianImplementation librarianImplementation =  new LibrarianImplementation();
        System.out.println(librarianImplementation.checkoutBook());
    }
}