public class Test {
    String test = "asfg";

    @Override
    public String toString() {
        return "Test{" +
                "test='" + test + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Test test1 = new Test();
        System.out.println(test1);


    }
}
