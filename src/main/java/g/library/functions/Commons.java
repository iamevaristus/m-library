package g.library.functions;

import g.library.enums.Gender;
import g.library.enums.MemberType;
import g.library.models.Book;
import g.library.models.Member;
import g.library.models.Student;
import g.library.models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Commons {
    public static void printDebug(String message) {
        System.out.print(message.trim() + ".\n\n");
    }

    public static void printError(String error) {
        System.err.print(error.trim() + ".\n\n");
    }

    public static List<String> stringListOfBook() {
        return new ArrayList<>(){{
            add(
                    "The Hitchhiker's Guide to the Galaxy/" +
                    "Douglas Adams/" +
                    "1979/" +
                    "100/" +
                    "Science Fiction/" +
                    "0-330-25864-8/" +
                    "The Hitchhiker's Guide to the Galaxy is a comic science fiction series created by Douglas Adams. " +
                            "Originally a radio comedy broadcast on BBC Radio 4 in 1978, it was later adapted to other " +
                            "formats, including stage shows, novels, comic books, a 1981 TV series, a 1984 computer game, " +
                            "and 2005 feature film. The series follows the adventures of Arthur Dent, a hapless Englishman, " +
                            "following the destruction of the Earth by the Vogons, a race of unpleasant and bureaucratic " +
                            "aliens./" +
                    "Available"
            );
            add(
                    "Pride and Prejudice/" +
                    "Jane Austen/" +
                    "1813/" +
                    "100/" +
                    "Romance/" +
                    "0-14-062328-4/" +
                    "Pride and Prejudice is a 1813 romantic novel written by Jane Austen. It is the story of Mr. and Mrs. " +
                            "Bennet's five unmarried daughters living in the early 19th century England. The story focuses " +
                            "on the relationship between the main character, Elizabeth Bennet, and Mr. Darcy, a wealthy and " +
                            "proud man./" +
                    "Available"
            );
            add(
                    "To Kill a Mockingbird/" +
                    "Harper Lee/" +
                    "1960/" +
                    "100/" +
                    "Fiction/" +
                    "0-446-69427-6/" +
                    "To Kill a Mockingbird is a novel by American author Harper Lee. Published in 1960, the novel won the " +
                            "Pulitzer Prize and has become a classic of modern American literature. The book is set in the " +
                            "fictional town of Maycomb, Alabama, during the Great Depression. The story is told from the " +
                            "perspective of Scout Finch, a young girl who witnesses her father, Atticus Finch, defend a " +
                            "black man falsely accused of rape./" +
                    "Available"
            );
            add(
                    "The Lord of the Rings/" +
                    "J.R.R. Tolkien/" +
                    "1954/" +
                    "100/" +
                    "Fantasy/" +
                    "0-395-08254-4/" +
                    "The Lord of the Rings is an epic high fantasy trilogy written by English philologist and University of " +
                            "Oxford professor J. R. R. Tolkien. The story began as a sequel to Tolkien's 1937 fantasy novel " +
                            "The Hobbit, but eventually developed into a much larger work. Written in stages between 1937 " +
                            "and 1949, with much of it being written during World War II, it was originally published in " +
                            "three volumes in 1954 and 1955. It has since been reprinted numerous times and translated into " +
                            "at least 38 languages, becoming one of the best-selling novels ever written./" +
                    "Available"
            );
            add(
                    "The Harry Potter series/" +
                    "J.K. Rowling/" +
                    "1997-2007/" +
                    "100/" +
                    "Fantasy/" +
                    "0-7475-3269-9/" +
                    "The Harry Potter series is a series of fantasy novels written by British author J. K. Rowling. The " +
                            "novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger " +
                            "and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry. The " +
                            "main story arc concerns Harry's struggle against Lord Voldemort, a dark wizard who intends to " +
                            "become immortal, overthrow the wizard governing body known as the Ministry of Magic and " +
                            "subjugate all wizards and Muggles (non-magical people)./" +
                    "Available"
            );
            add(
                    "The Hunger Games trilogy/" +
                    "Suzanne Collins/" +
                    "2008-2010/" +
                    "100/" +
                    "Science Fiction/" +
                    "0-545-01014-2/" +
                    "The Hunger Games trilogy is a series of dystopian science fiction novels written by American author " +
                            "Suzanne Collins. The novels are set in the dystopian nation of Panem, where children are " +
                            "forced to participate in a televised annual event known as the Hunger Games, in which they " +
                            "must fight to the death until only one remains. The trilogy follows the story of Katniss " +
                            "Everdeen, a young woman who volunteers to take her younger sister's place in the Hunger " +
                            "Games./" +
                    "Available"
            );
            add(
                    "The Twilight Saga/" +
                    "Stephenie Meyer/" +
                    "2005-2008/" +
                    "100/" +
                    "Fantasy/" +
                    "0-316-16000-3/" +
                    "The Twilight Saga is a series of four romantic fantasy novels written by American author Stephenie " +
                            "Meyer. The story revolves around Bella Swan, a teenage girl who moves to the small town of " +
                            "Forks, Washington, and falls in love with a vampire named Edward Cullen. The series explores " +
                            "themes of love, loss, and immortality/" +
                    "Available"
            );
        }};
    }

    public static List<Member> getMembers() {
        List<Member> list = new ArrayList<>();

        Student juniorStudent1 = new Student(
                "Chioma",
                "Frank",
                UUID.randomUUID(),
                Gender.FEMALE,
                "Jss1",
                MemberType.JUNIOR_STUDENT
        );
        Student juniorStudent2 = new Student(
                "Emmanuel",
                "Frank",
                UUID.randomUUID(),
                Gender.MALE,
                "Jss1",
                MemberType.JUNIOR_STUDENT
        );
        Student seniorStudent = new Student(
                "Evaristus",
                "Frank",
                UUID.randomUUID(),
                Gender.FEMALE,
                "Ss1",
                MemberType.SENIOR_STUDENT
        );
        Student seniorStudent1 = new Student(
                "Francis",
                "Frank",
                UUID.randomUUID(),
                Gender.MALE,
                "Ss1",
                MemberType.SENIOR_STUDENT
        );
        Teacher teacher = new Teacher(
                "Evaristus",
                "Frank",
                UUID.randomUUID(),
                Gender.MALE,
                "English"
        );
        Teacher teacher1 = new Teacher(
                "Joseph",
                "Frank",
                UUID.randomUUID(),
                Gender.FEMALE,
                "Mathematics"
        );

        list.add(juniorStudent1);
        list.add(juniorStudent2);
        list.add(seniorStudent1);
        list.add(seniorStudent);
        list.add(teacher1);
        list.add(teacher);

        return list;
    }

    public static List<Member> getMembersFromInput(Member member) {
        Student seniorStudent1 = new Student();
        Student juniorStudent1 = new Student();
        Teacher teacher = new Teacher();

        juniorStudent1.setClassLevel("Jss1");
        juniorStudent1.setId(member.getId());
        juniorStudent1.setGender(member.getGender());
        juniorStudent1.setFirstName(member.getFirstName());
        juniorStudent1.setLastName(member.getLastName());
        juniorStudent1.setMemberType(MemberType.JUNIOR_STUDENT);
        juniorStudent1.setBookCart(member.getBookCart());

        seniorStudent1.setClassLevel("Ss1");
        seniorStudent1.setId(member.getId());
        seniorStudent1.setGender(member.getGender());
        seniorStudent1.setFirstName(member.getFirstName());
        seniorStudent1.setLastName(member.getLastName());
        seniorStudent1.setMemberType(MemberType.SENIOR_STUDENT);
        seniorStudent1.setBookCart(member.getBookCart());

        teacher.setSubject("English");
        teacher.setId(member.getId());
        teacher.setGender(member.getGender());
        teacher.setFirstName(member.getFirstName());
        teacher.setLastName(member.getLastName());
        teacher.setMemberType(MemberType.TEACHER);
        teacher.setBookCart(member.getBookCart());

        List<Member> members = new ArrayList<>();
        members.add(juniorStudent1);
        members.add(seniorStudent1);
        members.add(teacher);
        return members;
    }

    public static List<Book> books() {
        List<Book> bookList = new ArrayList<>();
        int id = 1;
        for(String item : stringListOfBook()) {
            String[] array = item.split("/");
            Book book = new Book();
            book.setStatus(EnumConverter.getBookStatusFromString(array[7]));
            book.setNumberOfCopies(Integer.parseInt(array[3]));
            book.setAuthor(array[1]);
            book.setId(id++);
            book.setDescription(array[6]);
            book.setGenre(array[4]);
            book.setISBN(array[5]);
            book.setTitle(array[0]);
            book.setPublishDate(array[2]);
            bookList.add(book);
        }
        return bookList;
    }
}
