package g.library.services.interfaces;

import g.library.models.Book;

public interface MemberInterface {
    /**
     * This method is where the member/person in the library can request for a book.
     * @param bookName Name of the book.
     * @param authorOrCategory Author/Category of the book
     * @return Book
     */
    Book requestForBook(String bookName, String authorOrCategory);

    /**
     * This method is where the member/person can return a book that was taken.
     * @param book Book taken
     * @return Book
     */
    Book returnBook(Book book);
}
