package autotests.template.one;
//1.1. Реализуйте алгоритм сортировки пузырьком для сортировки массива
public class Bubble {
    public Bubble(double[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    double x = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = x;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
