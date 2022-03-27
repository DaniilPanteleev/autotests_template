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

        Bubble bubble = new Bubble(n);//пузырьковый метод
        int[] z = {0, 1, 2, 3, 4};
        SimpleNumb simpleNumb = new SimpleNumb(z);// нахождение простых чисел
        Delete delete = new Delete(z,2);// удаление элемента массива
    }
}
