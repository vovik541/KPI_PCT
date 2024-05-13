package lab2.task3;

public class JournalRecord {
    private Student student;
    private Mark mark;
    private Teacher teacher;

    private int week;

    public JournalRecord(Student student, Mark mark, Teacher teacher, int week) {
        this.student = student;
        this.mark = mark;
        this.teacher = teacher;
        this.week = week;
    }

    public Student getStudent() {
        return student;
    }

    public Mark getMark() {
        return mark;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public int getWeek() {
        return week;
    }
}
