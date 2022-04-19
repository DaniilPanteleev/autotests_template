package autotests.template.taskOop.task2;

public class Person {
    int age;
    String fullName;

    public void move(){
        System.out.println(fullName +" двигается");
    }

    public void talk(){
        System.out.println(fullName +" говорит");
    }

    public Person(int age, String fullName) {
        this.age = age;
        this.fullName = fullName;
    }

    public Person() {
    }

    public static void main(String[] args) {
        Person person = new Person();
        Person person1 = new Person(18,"Goshan");
        person1.talk();
        person.talk();

    }
}
