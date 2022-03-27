package autotests.template.fourSecond;

public class Main {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome("как");
        String[] list = new String[]{"1", "22", "333", "4444"};
        Linelength linelength = new Linelength(list);

    }
    //Напишите метод, заменяющий в тексте все вхождения слова Навальный «бяка» на «[вырезано
    //цензурой]».

    public static void ChangeWord(String s, String s2) {
        String x = "[Вырезанно цензурой]";
        s = s.replaceAll(s2, x);
        System.out.println(s);
    }

}
