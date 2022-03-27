package autotests.template.one;

import java.util.Arrays;
//1.3. Удаление из массива
public class Delete {
    public Delete(int[] x, int d) {
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
