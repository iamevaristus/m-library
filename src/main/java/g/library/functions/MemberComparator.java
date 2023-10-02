package g.library.functions;

import g.library.enums.MemberType;
import g.library.models.Member;

import java.util.Comparator;

public class MemberComparator implements Comparator<Member> {
    @Override
    public int compare(Member first, Member second) {
        // Sort by person type in the following order:
        // Teacher, Senior Student, Junior Student, Librarian
        if (first.getMemberType() == MemberType.TEACHER
                && second.getMemberType() == MemberType.SENIOR_STUDENT
        ) {
            return -1;
        } else if (first.getMemberType() == MemberType.TEACHER
                && second.getMemberType() == MemberType.JUNIOR_STUDENT
        ) {
            return -1;
        } else if (first.getMemberType() == MemberType.TEACHER
                && second.getMemberType() == MemberType.LIBRARIAN
        ) {
            return -1;
        } else if (first.getMemberType() == MemberType.SENIOR_STUDENT
                && second.getMemberType() == MemberType.JUNIOR_STUDENT
        ) {
            return -1;
        } else if (first.getMemberType() == MemberType.SENIOR_STUDENT
                && second.getMemberType() == MemberType.LIBRARIAN
        ) {
            return -1;
        } else if (first.getMemberType() == MemberType.JUNIOR_STUDENT
                && second.getMemberType() == MemberType.LIBRARIAN
        ) {
            return -1;
        } else if (first.getMemberType() == second.getMemberType()) {
            return 0;
        } else {
            return 1;
        }
    }
}
