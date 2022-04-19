package autotests.template.taskOop.five;

public class Aspirant extends Student {

    boolean scientificWork = true;


    public Aspirant(String firstName, String lastName, String group, double averageMark) {
        super(firstName, lastName, group, averageMark);
    }

    public Aspirant(double averageMark) {
        super(averageMark);
    }

    public Aspirant() {
        super();
    }

    @Override
    public int getScholarship() {
        if (super.averageMark == 5) return 200;
        else return 180;
    }
}
