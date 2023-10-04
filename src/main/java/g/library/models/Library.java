package g.library.models;

import g.library.functions.MemberComparator;

import java.util.*;

public class Library {
    private Librarian librarian;

    private Map<Member, Book> collectedBooksRegister = new Hashtable<>();

    private List<Book> bookList = new ArrayList<>();

    private Queue<Member> memberQueue = new LinkedList<>();

    private PriorityQueue<Member> memberPriorityQueue = new PriorityQueue<>(new MemberComparator());

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Map<Member, Book> getCollectedBooksRegister() {
        return collectedBooksRegister;
    }

    public void setCollectedBooksRegister(Map<Member, Book> collectedBooksRegister) {
        this.collectedBooksRegister = collectedBooksRegister;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Queue<Member> getMemberQueue() {
        return memberQueue;
    }

    public void setMemberQueue(Queue<Member> memberQueue) {
        this.memberQueue = memberQueue;
    }

    public PriorityQueue<Member> getMemberPriorityQueue() {
        return memberPriorityQueue;
    }

    public void setMemberPriorityQueue(PriorityQueue<Member> memberPriorityQueue) {
        this.memberPriorityQueue = memberPriorityQueue;
    }

    public Library(
            Librarian librarian,
            Map<Member, Book> collectedBooksRegister,
            List<Book> bookList
    ) {
        this.librarian = librarian;
        this.collectedBooksRegister = collectedBooksRegister;
        this.bookList = bookList;
    }

    public Library() {}
}
