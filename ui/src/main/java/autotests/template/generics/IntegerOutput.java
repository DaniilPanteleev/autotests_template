package autotests.template.generics;

public class IntegerOutput extends CommonOutput<Integer> {

    public IntegerOutput(Integer var) {
        super(var);
    }

    public void printInteger() {
        super.print();
    }

    public static void main(String[] args) {
        new IntegerOutput(1).printInteger();
    }

}
