package autotests.template.taskOop.six.com.company.vehicles;

import autotests.template.taskOop.six.com.company.details.Engine;
import autotests.template.taskOop.six.com.company.professions.Driver;

public class Car {
    private String brand;
    private String classCar;
    private int weight;
    private Driver driver;
    private Engine motor;

    public Car(String brand, String classCar, int weight, Driver driver, Engine motor) {
        this.brand = brand;
        this.classCar = classCar;
        this.weight = weight;
        this.driver = driver;
        this.motor = motor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getClassCar() {
        return classCar;
    }

    public void setClassCar(String classCar) {
        this.classCar = classCar;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Engine getMotor() {
        return motor;
    }

    public void setMotor(Engine motor) {
        this.motor = motor;
    }

    public void start(){
        System.out.println("Поехали");
    }
    public void stop(){
        System.out.println("Останавливаемся");
    }
    public void turnRight(){
        System.out.println("Поворот направо");
    }
    public void turnLeft(){
        System.out.println("Поворот налево");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", classCar='" + classCar + '\'' +
                ", weight=" + weight +
                ", driver=" + driver +
                ", motor=" + motor +
                '}';
    }

    public static void main(String[] args) {
        Driver bmwDriver = new Driver("Иванов В.В.",   30);
        Engine bmwEngine = new Engine(60, "BMW");
        Car car = new Car("BMW", "C", 5000, bmwDriver, bmwEngine);

        Driver lorryDriver = new Driver("Петров В.В.", 20);
        Engine lorryEngine = new Engine(30, "LorryEngine");
        Lorry lorry = new Lorry("Грузовик", "D", 8000, lorryDriver, lorryEngine, 70);

        Driver sportDriver = new Driver("Сидоров В.В.", 15);
        Engine sportEngine = new Engine(80, "SportEngine");
        SportCar sportCar = new SportCar("SportCar", "C", 4000, sportDriver, sportEngine, 300);

        System.out.println(car);
        System.out.println(lorry);
        System.out.println(sportCar);
    }
}
