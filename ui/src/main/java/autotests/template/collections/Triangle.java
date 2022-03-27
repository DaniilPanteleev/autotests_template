package autotests.template.collections;

public class Triangle {
    private int x;
    private int y;

    public Triangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
