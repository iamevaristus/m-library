package g.library.enums;

public enum Gender {
    MALE("Male"),

    FEMALE("Female");

    private final String type;

    Gender(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}