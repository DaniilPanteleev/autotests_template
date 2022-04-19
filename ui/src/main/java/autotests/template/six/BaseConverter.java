package autotests.template.six;
//Напишите класс BaseConverter для конвертации из градусов по Цельсию в
//Кельвины, Фаренгейты, и так далее. У класса должен быть метод convert, который
//и делает конвертацию.

public class BaseConverter {
    public static void main(String[] args) {
        double temperature = 23.5;
        System.out.println("t = " +
                new CelsiusConvert().getValue(temperature));
        System.out.println("t = " +
                new KelvinConvert().getValue(temperature));
        System.out.println("t = " +
                new FahrenheitConvert().getValue(temperature));
    }
}