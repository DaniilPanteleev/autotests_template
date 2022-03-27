package autotests.template.fourSecond;
//Напишите метод, который проверяет является ли слово палиндромом.
public class Palindrome {
    public Palindrome(String s) {
        System.out.println(s.equals((new StringBuilder(s)).reverse().toString()));
    }

}
