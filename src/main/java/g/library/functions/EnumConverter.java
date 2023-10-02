package g.library.functions;

import g.library.enums.BookStatus;
import g.library.enums.Gender;
import g.library.enums.MemberType;

public class EnumConverter {
    public static Gender getGenderFromString(String gender) {
        for (Gender extension : Gender.values()) {
            if (extension.getType().toLowerCase().contains(gender.toLowerCase().trim())) {
                return extension;
            }
        }
        // Default value or handle as needed.
        return Gender.MALE;
    }

    public static MemberType getStudentLevelFromString(String type) {
        for(MemberType memberType : MemberType.values()) {
            if(memberType.getType().toLowerCase().contains(type.toLowerCase().trim())) {
                return memberType;
            }
        }
        // Default value or handle as needed.
        return MemberType.LIBRARIAN;
    }

    public static BookStatus getBookStatusFromString(String status) {
        for(BookStatus bookStatus : BookStatus.values()) {
            if(bookStatus.getStatus().toLowerCase().contains(status.toLowerCase().trim())) {
                return bookStatus;
            }
        }
        // Default value or handle as needed.
        return BookStatus.AVAILABLE;
    }
}
