package autotests.template.six;
//Напишите класс BaseConverter для конвертации из градусов по Цельсию в
//Кельвины, Фаренгейты, и так далее. У класса должен быть метод convert, который
//и делает конвертацию.

public class BaseConverter {
    interface Converter {
        double getValue(double value);
    }

    public static class CelsiusConvert implements Converter{

        @Override
        public double getValue(double value) {
            return value;
        }
    }

    public static class KelvinConvert implements Converter{

        @Override
        public double getValue(double value) {
            return value + 273;
        }
    }

    public static class FahrenheitConvert implements Converter{

        @Override
        public double getValue(double value) {
            return value * 1.8 + 32;
        }
    }



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