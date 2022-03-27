package autotests.template.one;
//1.2. Поиск простых чисел
public class SimpleNumb {
    public SimpleNumb(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0 && a[i] % 2 == 0) {
                System.out.println(a[i]);
            }
        }
    }
}
