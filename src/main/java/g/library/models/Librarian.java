package g.library.models;

import g.library.enums.Gender;
import g.library.enums.MemberType;

import java.util.UUID;

public class Librarian extends Member {
    public Librarian(
            String firstName,
            String lastName,
            UUID id,
            Gender gender
    ) {
        super(
                firstName,
                lastName,
                id,
                gender,
                MemberType.LIBRARIAN
        );
    }
}
