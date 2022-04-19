package autotests.template.one;

import java.util.Arrays;
//1.0. Максимальное, минимальное и среднее значение
public class MaxMinAvg {
    public static void main(String[] args) {
        double max;
        double min;
        double avg;
        double[] n = new double[10];

        for (int i = 0; i < n.length; i++) {
            n[i] = Math.random();
        }
        max = Arrays.stream(n).max().getAsDouble();
        min = Arrays.stream(n).min().getAsDouble();
        avg = Arrays.stream(n).average().getAsDouble();

        System.out.println("Max = " + max + "\n" + "Min = " + min + "\n" + "Avg = " + avg);

        int[] z = {0, 1, 2, 3, 4};
        bubble(n);
        simpleNumb(z);
        delete(z, 2);

    }
    //1.1. Реализуйте алгоритм сортировки пузырьком для сортировки массива

    public static void bubble(double[] a) {
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

    public static void simpleNumb(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0 && a[i] % 2 == 0) {
                System.out.println(a[i]);
            }
        }
    }

    public static void delete(int[] x, int d) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == d) {
                count++;
            } else {
                x[i - count] = x[i];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(x, x.length - count)));
    }

}