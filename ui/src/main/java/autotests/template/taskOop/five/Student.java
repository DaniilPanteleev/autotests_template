package autotests.template.taskOop.five;

public class Student {
    String firstName;
    String lastName;
    String group;
    double averageMark;

    public Student(double averageMark) {
        this.averageMark = averageMark;
    }

    public Student() {

    }

    public int getScholarship() {
        if (averageMark == 5) return 100;
        else return 80;
    }

    public Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public static void main(String[] args) {
        Student student = new Aspirant(5);
        Student student1 = new Student(4);
        Student student2 = new Aspirant(3);
        Student student3 = new Student(5);
        Student[] list = new Student[] {student , student1 , student2 , student3};
        for (Student x : list) System.out.println( x.getScholarship() + " грвн");
    }
}
