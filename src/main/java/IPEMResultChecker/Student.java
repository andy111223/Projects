package IPEMResultChecker;

public final class Student {

    String name;
    String surname;

    int group;
    int row; //? separate test class?

    double test1Grade;
    double test2Grade;

    double plusesForActivity;

    double additionalAssignment;

    double finalGrade;

    public Student(String surname, int group, double test1Grade) {
        this.surname = surname;
        this.group = group;
        this.test1Grade = test1Grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public double getTest1Grade() {
        return test1Grade;
    }

    public void setTest1Grade(double test1Grade) {
        this.test1Grade = test1Grade;
    }

    public double getTest2Grade() {
        return test2Grade;
    }

    public void setTest2Grade(double test2Grade) {
        this.test2Grade = test2Grade;
    }

    public double getPlusesForActivity() {
        return plusesForActivity;
    }

    public void setPlusesForActivity(double plusesForActivity) {
        this.plusesForActivity = plusesForActivity;
    }

    public double getAdditionalAssignment() {
        return additionalAssignment;
    }

    public void setAdditionalAssignment(double additionalAssignment) {
        this.additionalAssignment = additionalAssignment;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group=" + group +
                ", row=" + row +
                ", test1Grade=" + test1Grade +
                ", test2Grade=" + test2Grade +
                ", plusesForActivity=" + plusesForActivity +
                ", additionalAssignment=" + additionalAssignment +
                ", finalGrade=" + finalGrade +
                '}';
    }
}
