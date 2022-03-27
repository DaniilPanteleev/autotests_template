package autotests.template.tasks;

public class Task {
    public static void main(String[] args) {




    }
    public class Vector {

        private double x;
        private double y;
        private double z;


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



    }
}
