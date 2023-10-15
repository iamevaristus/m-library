package com.library.models;

import com.library.enums.Gender;
import com.library.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class User {
    private String firstName;
    private String lastName;
    private UUID id;
    private Role role;
    private Gender gender;
    private Book bookCart;
}
