package com.library.enums;

import lombok.Getter;

@Getter
public enum Role {
    TEACHER("Teacher"),
    SENIOR_STUDENT("Senior Student"),
    JUNIOR_STUDENT("Junior Student"),
    LIBRARIAN("Librarian");

    private final String type;

    Role(String type) {
        this.type = type;
    }
}
