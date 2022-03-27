package autotests.template.two;
//2.0. Проектирование и создание класса, описывающего вектор
public class Vector {
    double x;
    double y;
    double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProduct(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public Vector crossProduct(Vector vector) {
        return new Vector(
                y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x);
    }

    public double cos(Vector vector){
        return scalarProduct(vector) / (length() * vector.length());
    }

    public Vector PlusORMinus(Vector vector, String a) {
        if (a.equals("Plus") || a.equals("plus")) {
            return new Vector(
                    x + vector.x,
                    y + vector.y,
                    z + vector.z
            );
        } else {
            return new Vector(
                    x - vector.x,
                    y - vector.y,
                    z - vector.z);
        }

    }

    public static Vector[] generate(int x) {
        Vector[] vectors = new Vector[x];
        for (int i = 0; i < x; i++) {
            vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectors;

    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public static void main(String[] args) {
        Vector[] vectors = Vector.generate(10);
        System.out.println(vectors[0]);
        System.out.println(vectors[1]);
        System.out.println(vectors[0].length());
        System.out.println(vectors[0].scalarProduct(vectors[1]));
        System.out.println(vectors[0].crossProduct(vectors[1]));
        System.out.println(vectors[0].cos(vectors[1]));
        System.out.println(vectors[0].PlusORMinus(vectors[1], "plus"));
        System.out.println(vectors[0].PlusORMinus(vectors[1], " "));

        int[] x = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] y = new int[]{1, 1, 6, 7, 5, 2, 1, 10, 2,};
        RandomFromArray randomFromArray = new RandomFromArray(x, y);
        System.out.println( "Random = " + randomFromArray.getRandom());

    }
}
