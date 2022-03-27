package autotests.template.lambdes;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaCheck {
    Predicate<String> predicate = a -> a.startsWith("a");
    Supplier<Integer> supplier = () -> new Random().nextInt();
    Consumer<Integer> consumer = a -> {
        System.out.println(a);
        System.out.println(a * 2);
    };

    public static void main(String[] args) {
        LambdaCheck lambdaCheck = new LambdaCheck();
        System.out.println(lambdaCheck.predicate.test("acvghjdf"));
        System.out.println( lambdaCheck.supplier.get());
        lambdaCheck.consumer.accept(10);


    }
}

