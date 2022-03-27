package autotests.template.four;
//4.0. Реализовать иерархию классов, описывающую трёхмерные фигуры

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(4.5);
        Cylinder cylyinder = new Cylinder(2, 2);
        Pyramid pyramid = new Pyramid(100, 100);

        Box box = new Box(100);

        System.out.println(box.add(ball));
        System.out.println(box.add(cylyinder));
        System.out.println(box.add(pyramid));
    }
}
