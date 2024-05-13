package lab2.task3;

import java.util.ArrayList;

import static lab2.task3.Main.groups;

public class Group {
    private String groupName;
    private ArrayList<Student> students = new ArrayList<>();
    private int studentsNumber;

    public Group(String groupName, int countStudents) {
        this.groupName = groupName;
        this.studentsNumber = countStudents;
    }

    public void createStudents() {
        for (Group group : groups) {
            for (int i = 0; i < group.getStudentsNumber(); i++) {
                students.add(new Student("Student " + i + group.getGroupName(), group));
            }
        }
    }

    @Override
    public String toString() {
        return "Group" + groupName + "with" + students + "students";
    }

    public String getGroupName() {
        return groupName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getStudentsNumber() {
        return studentsNumber;
    }
}
