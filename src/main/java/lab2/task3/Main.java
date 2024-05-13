package lab2.task3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<Group> groups = new LinkedList<>() {{
        this.add(new Group("IP-z01", 3));
        this.add(new Group("IP-z02", 4));
        this.add(new Group("IP-z03", 2));
    }};

    public static void main(String[] args) throws InterruptedException {
        groups.forEach(x -> x.createStudents());
        Journal journal = new Journal();
        List<Teacher> teachers = createTeachers(journal);
        journal.setTeachers(teachers);

        teachers.forEach(Thread::start);

        for (Teacher teacher : teachers) {
            teacher.join();
        }

        journal.printJournal();
    }

    private static List<Teacher> createTeachers(Journal journal) {
        return new ArrayList<>() {{
            this.add(new Teacher("Vova", journal));
            this.add(new Teacher("Max assistant", journal));
            this.add(new Teacher("Dima assistant", journal));
            this.add(new Teacher("Ihor assistant", journal));
        }};
    }
}
