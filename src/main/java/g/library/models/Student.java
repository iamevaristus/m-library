package g.library.models;

import g.library.enums.Gender;
import g.library.enums.MemberType;

import java.util.UUID;

public class Student extends Member {
    private String classLevel;

    public Student(
            String firstName,
            String lastName,
            UUID id,
            Gender gender,
            String classLevel,
            MemberType memberType
    ) {
        super(
                firstName,
                lastName,
                id,
                gender,
                memberType
        );
        this.classLevel = classLevel;
    }

    public Student() {}

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    @Override
    public String toString() {
        return super.toString() + "StudentLevel: " + classLevel;
    }
}
