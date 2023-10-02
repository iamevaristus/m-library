package g.library.models;

import g.library.enums.Gender;
import g.library.enums.MemberType;

import java.util.UUID;

public class Teacher extends Member {
    private String subject;

    public Teacher(
            String firstName,
            String lastName,
            UUID id,
            Gender gender,
            String subject
    ) {
        super(
                firstName,
                lastName,
                id,
                gender,
                MemberType.TEACHER
        );
        this.subject = subject;
    }

    public Teacher() {}

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + "Subject: " + getSubject();
    }
}
