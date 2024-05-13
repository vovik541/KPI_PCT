package lab2.task3;

public class Mark {
    private String subjectName;
    private int value;
    private boolean passed = false;

    public Mark(int value, String subjectName) {
        if (value < 0 | value > 100) {
            throw new RuntimeException("Wrong grade exception");
        }
        this.value = value;
        this.subjectName = subjectName;


        if (value > 60) {
            passed = true;
        }
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getValue() {
        return value;
    }

    public boolean isPassed() {
        return passed;
    }
}
