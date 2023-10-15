package com.library.implementations;

import com.library.enums.Role;
import com.library.enums.Status;
import com.library.exceptions.BookException;
import com.library.exceptions.ExceptionStrings;
import com.library.models.Book;
import com.library.models.Library;
import com.library.models.User;
import com.library.services.UserService;

import java.util.Optional;

public class UserImplementation implements UserService {
    @Override
    public Status requestBook(String title, String author, User user) throws BookException {
        Optional<Book> optionalBook = checkIfBookExistByAuthorAndTitle(title, author);
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if(book.isAvailable()) {
                user.setBookCart(book);
                Library.libraryQueue.add(user);
                return Status.REQUESTED;
            } else {
                throw new BookException(ExceptionStrings.BOOK_IS_NOT_AVAILABLE);
            }
        } else {
            throw new BookException(ExceptionStrings.BOOK_NOT_FOUND);
        }
    }
}