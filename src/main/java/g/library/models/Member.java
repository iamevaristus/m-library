package g.library.models;

import g.library.enums.Gender;
import g.library.enums.MemberType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

abstract public class Member {
    private String firstName;

    private String lastName;

    private UUID id;

    private Gender gender;

    private MemberType memberType;

    private Book bookCart;

    /// SETTERS
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setBookCart(Book bookCart) {
        this.bookCart = bookCart;
    }

    /// GETTERS

    public Gender getGender() {
        return gender;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public Book getBookCart() {
        return bookCart;
    }

    public Member(
            String firstName,
            String lastName,
            UUID id,
            Gender gender,
            MemberType memberType
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gender = gender;
        this.memberType = memberType;
    }

    public Member() {
    }

    @Override
    public String toString() {
        return """
                FirstName: %s,
                LastName: %s,
                ID: %s,
                Gender: %s,
                Type of member: %s,
                List of Collected Books: %s
        """.formatted(
                firstName,
                lastName,
                id,
                gender,
                memberType,
                bookCart.toString()
        );
    }
}
