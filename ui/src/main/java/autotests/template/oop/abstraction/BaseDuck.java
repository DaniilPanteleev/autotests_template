package autotests.template.oop.abstraction;

public abstract class BaseDuck implements IDuck {

    public void say() {
        System.out.println(this.getClass().getAnnotation(Duck.class).voice());
    }

    void fly() {
        System.out.println("FLYYYY!");
    }

    private void run() {
        System.out.println("run");
    }

}
