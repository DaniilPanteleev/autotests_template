package autotests.template.taskOop.six.com.company.vehicles;

import autotests.template.taskOop.six.com.company.details.Engine;
import autotests.template.taskOop.six.com.company.professions.Driver;

public class SportCar extends Car{
    private double speed;

    public SportCar(String brand, String classCar, int weight, Driver driver, Engine motor , double speed) {
        super(brand, classCar, weight, driver, motor);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "speed=" + speed +
                '}'+ super.toString();
    }
}
