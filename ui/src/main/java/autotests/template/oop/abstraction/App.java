package autotests.template.oop.abstraction;

public class App {

    public static void main(String[] args) {
        IDuck duck = new DonaldDuck();
        duck.say();

        FlyDuck flyDuck = new FlyDuck();
        flyDuck.say();

    }

}
