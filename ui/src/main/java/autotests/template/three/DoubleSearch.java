package autotests.template.three;
//3.0. Двоичный поиск
public class DoubleSearch {
    public static String enumerationOfElements(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) return "Номер элемента = " + i;
        }
        return "не входит";
    }
}
