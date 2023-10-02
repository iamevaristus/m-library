package g.library.enums;

public enum MemberType {
    LIBRARIAN("Librarian"),

    SENIOR_STUDENT("Senior Student"),

    JUNIOR_STUDENT("Junior Student"),

    TEACHER("Teacher");

    private final String type;

    MemberType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
