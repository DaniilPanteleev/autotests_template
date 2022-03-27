package autotests.template.four;
//4.3. Реализовать иерархию классов, описывающую трёхмерные фигуры — 4
public class SolidOfRevolution extends Shape {
    private double radius;

    public SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
