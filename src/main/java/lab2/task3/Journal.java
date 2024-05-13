package lab2.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lab2.task3.Main.groups;

public class Journal {
    public static final int TILL_WEEK = 3;
    private List<JournalRecord> records = new ArrayList<>();
    private List<Teacher> teachers;

    public synchronized void addRecord(Mark mark, Student student, Teacher teacher, int week) {
        records.add(new JournalRecord(student, mark, teacher, week));
    }

    public synchronized void printJournal() {

        for (Group group : groups) {
            for (int i = 1; i <= TILL_WEEK; i++) {
                for (Teacher teacher : teachers) {
                    for (JournalRecord record : records) {
                        if (record.getWeek() == i
                                && Objects.equals(record.getStudent().getGroup().getGroupName(), group.getGroupName())
                                && record.getTeacher().equals(teacher)) {
                            System.out.printf("%10s - subject %12s - marked by %15s - mark %4d - %s%n",
                                    record.getStudent().getStudentName(),
                                    record.getMark().getSubjectName(),
                                    record.getTeacher().getTeacherName(),
                                    record.getMark().getValue(),
                                    record.getMark().isPassed() ? "passed" : "not passed");
                        }
                    }
                }
                System.out.println("____________________________________NEW WEEK________________________________________");
            }
            System.out.println("____________________________________NEW GROUP________________________________________");
        }
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
