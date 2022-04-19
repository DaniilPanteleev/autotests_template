package autotests.template.taskOop.task1;

public class Phone {
    private int number;
    private String model;
    private int weight;

    public void receiveCall(String callName) {
        System.out.println("Звонит " + callName);
    }

    public String getModel() {
        return model;
    }

    public int getNumber() {
        return number;
    }

    public Phone(int number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
    }

    public void receiveCall(String callName, int callNumber) {
        System.out.println("Звонит " + callName);
    }

    public void sendMessage(int number, int... list) {
        int[] listNumber = list;
        for (int x : listNumber) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Phone phone = new Phone(273506 ,"Samsung");
        Phone phone1 = new Phone(933244,"Apple");
        Phone phone2 = new Phone(554678,"Apple");
        phone1.getNumber();
        phone.receiveCall(phone1.getModel());
        phone.sendMessage(892231, 12321, 123123, 443434, 55555);
    }
}
