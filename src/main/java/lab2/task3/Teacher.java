package lab2.task3;

import static lab2.task3.Journal.TILL_WEEK;
import static lab2.task3.Main.groups;

public class Teacher extends Thread {
    private String teacherName;
    private Journal journal;

    public Teacher(String name, Journal journal) {
        this.teacherName = name;
        this.journal = journal;
    }

    @Override
    public void run() {
        int fromWeek = 1;
        while (fromWeek <= TILL_WEEK) {
            for (Group group : groups) {
                for (Student student : group.getStudents()) {
                    Mark mark = new Mark((int) (Math.random() * 100), "Math " + fromWeek);
                    journal.addRecord(mark, student, this, fromWeek);
                }

            }
            fromWeek++;
        }
    }

    public String getTeacherName() {
        return teacherName;
    }
}
