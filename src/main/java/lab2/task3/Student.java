package lab2.task3;

import java.util.ArrayList;
import java.util.UUID;

public class Student {
    private final String studentName;
    private final Group group;

    public Student(String studentName, Group group) {
        this.studentName = studentName;
        this.group = group;
    }

    @Override
    public String toString() {
        return String.format("Student Name %s", studentName) ;
    }

    public String getStudentName() {
        return studentName;
    }

    public Group getGroup() {
        return group;
    }
}
