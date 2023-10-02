# Welcome to M-Library

`As your personal librarian, let me walk you down the project.`

## Getting Started

---

### Understanding the Project

~~M-Library is a java project which is an offshoot of my java learning.~~

>> This project is aimed at achieving certain things which a library
> should be able to do.
> 
>> [!NOTE]
> This is not a complete project, nor is it a project I might complete.
> 
>> [!IMPORTANT]
> This is for learning purposes.
> 
>> [!WARNING]
> Have fun.

### Project Folder Structure

```
m-library
├── src
│   ├── main
│   │   └── java
│   │       └── m.library
│   │           └── enums
│                  └── BookStatus.java
│                  └── Gender.java
│                  └── MemberType.java
│   │           └── exceptions
│                  └── BookException.java
│                  └── ExceptionStrings.java
│   │           └── functions
│                  └── Commons.java
│                  └── EnumConverter.java
│                  └── MemberComparator.java
│   │           └── models
│                  └── Book.java
│                  └── Librarian.java
│                  └── Library.java
│                  └── Member.java
│                  └── Student.java
│                  └── Teacher.java
│   │           └── services
│                  └── implementations
│                      └── LibrarianImplementation.java
│                      └── MemberImplementation.java
│                  └── interfaces
│                      └── LibrarianService.java
│                      └── MemberService.java
│   │           └── ui (For descriptive purposes)
│                  └── Runner.java
│                  └── RunnerCheckers.java
│                  └── RunnerInitializers.java
│   │           └── main.java
│   └── test
│       └── java
│           └── m.library.services.implementations
│               └── LibrarianImplementationTest.java
│               └── MemberImplementationTest.java
├── build/
├── pom.xml
├── README.md
└── LICENSE
```

## Project Requirements

---

**Problem Description**

A book library where a student, teacher borrow books. 
When the copy of the book is no longer in the library. 
The library should return `book taken`. 
They can be multiple copies of the same book in the 
library.

**Implementation 1:** `FIFO with Priority`

The books are given by the Librarian on a first-come-first-serve
basis, however, when a teacher is requesting for the
same book a student is asking for, the teacher comes
first, When a junior student is asking for the same book
a senior student is asking for, the senior student comes
first.

**Implementation 2:** `FIFO`

The books are given by the Librarian on a first-come-first-serve
basis, whether you are a teacher, a junior or a senior
student.

## Project Models And Methods

---

To implement the book library in Java, these models 
will be used:

````
MLibrary (Models)
|
+-- Book
+-- Member
+---|
    +-- Student
    +-- Teacher
    +-- Librarian
+-- Library

MLibrary (Methods)
|
+-- checkoutBook()
+-- checkoutBook()
+-- searchBookByTitleAndAuthor()
+-- addCollectedBookToRegister()
+-- updateLibraryData()
+-- requestForBook()
+-- returnBook()
````

* A `Book` can be borrowed by multiple `Student`s
 or `Teacher`s.
* A `Student` or `Teacher` can borrow multiple `Book`s.
* A `Librarian` manages the `Library` and its collection
 of `Book`s.

## Project Implementation

---

**Implementation 1:** `FIFO with Priority`

```java
public Member checkoutBook(PriorityQueue<Member> priorityQueue, Book book) throws BookException{
    if (book.isAvailable()) {
    // Check out the book to the member at the front of the queue
    Member prioritizedMember = priorityQueue.poll();
    updateLibraryData(prioritizedMember, book, false);
    return prioritizedMember;
    }
    throw new BookException(ExceptionStrings.BOOK_IS_NOT_AVAILABLE);
}
```

**Implementation 2:** `FIFO`

```java
public Member checkoutBook(PriorityQueue<Member> priorityQueue, Book book) throws BookException{
    Book bookFound = searchBookByTitleAndAuthor(book);
    if (bookFound.isAvailable()) {
    // Check out the book to the member at the front of the queue
    Member memberAtFrontOfQueue = queue.poll();
    updateLibraryData(memberAtFrontOfQueue, book, false);
    return memberAtFrontOfQueue;
    }
    throw new BookException(ExceptionStrings.BOOK_IS_NOT_AVAILABLE);
}
```

## Project Testing

---

```java
@Test
void shouldGiveBookToMemberByPriority() {
    List<Book> books = new ArrayList<>();
    books.add(book);
    librarianImplementation.setBookList(books);

    try {
        assertEquals(teacher, librarianImplementation.checkoutBook(
        priorityQueue,
        book
        ));
    } catch (BookException e) {
        throw new RuntimeException(e);
    }
}

@Test
void throwBookNotAvailableExceptionWhileInPriority() {
    book.setStatus(BookStatus.NOT_AVAILABLE);
    assertThrows(BookException.class, () -> {
        librarianImplementation.checkoutBook(
            priorityQueue,
            book
        );
    });
}

@Test
void shouldGiveBookToFirstPersonInTheQueue() {
    List<Book> books = new ArrayList<>();
    books.add(book);
    librarianImplementation.setBookList(books);

    try {
        assertEquals(member, librarianImplementation.checkoutBook(
            queue,
            book
        ));
    } catch (BookException e) {
        throw new RuntimeException(e);
    }
}

@Test
void throwBookNotAvailableException() {
    book.setStatus(BookStatus.NOT_AVAILABLE);
    assertThrows(BookException.class, () -> {
        librarianImplementation.checkoutBook(
            queue,
            book
        );
    });
}
```

## Suffix

---

**My GitHub repo for this assignment can be found
[here](https://github.com/iamevaristus/m-library.git).

