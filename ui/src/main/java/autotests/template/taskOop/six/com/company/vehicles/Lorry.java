package autotests.template.taskOop.six.com.company.vehicles;

import autotests.template.taskOop.six.com.company.details.Engine;
import autotests.template.taskOop.six.com.company.professions.Driver;

public class Lorry extends Car{
    private int carrying;

    public Lorry(String brand, String classCar, int weight, Driver driver, Engine motor , int carrying) {
        super(brand, classCar, weight, driver, motor);
        this.carrying = carrying;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    @Override
    public String toString() {
        return "Lorry{" +
                "carrying=" + carrying +
                '}'+ super.toString();
    }
}
