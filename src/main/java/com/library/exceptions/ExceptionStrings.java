package com.library.exceptions;

public class ExceptionStrings {
    /// BOOK EXCEPTION
    public static String bookException(String message) {
        return "Book Exception:::::" + message;
    };
    public static final String BOOK_NOT_FOUND = bookException("Book does not exist");
    public static final String BOOK_IS_NOT_AVAILABLE = bookException("Book is not available");
}
