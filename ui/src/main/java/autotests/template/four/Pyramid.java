package autotests.template.four;

public class Pyramid extends Shape{
    private double s;
    private double h;

    public Pyramid(double h ,double s) {
        super(h *s * 4/3);
        this.h = h;
        this.s = s;
    }
}
