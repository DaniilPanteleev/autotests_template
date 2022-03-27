package autotests.template.fourSecond;
//Напишите метод для поиска самой длинной строки в массиве.
public class Linelength {
    String line;
    int max = 0;


    public Linelength(String[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > max) {
                line = a[i];
            }
        }
        System.out.println(line);
    }
}