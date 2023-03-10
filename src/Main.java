import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    private static void task1() {
        System.out.println("Задача 1");
        Integer x = 5;
        Predicate<Integer> predicate = new Predicate<Integer>() {

            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        };
        System.out.println("Число: " + x + (predicate.test(x) ? " положительное." : " отрицательное."));

        Predicate<Integer> predicate1 = y -> y >= 0;
        Integer y = -1;
        System.out.println("Число: " + y + (predicate1.test(y) ? " положительное." : " отрицательное."));

    }


    private static void task2() {

        String name = "виталя";
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Привет " + name);
            }
        };
        consumer.accept(name);

        Consumer<String> consumer1 = name1 -> System.out.println("Привет " + name1);
        String name1 = "виталя";

        consumer1.accept(name1);
    }

    private static void task3() {
        System.out.println("Задача 3");
        Double z = 23.21;
        Double y = 25.66;

        List<Double> list = new ArrayList<>();
        list.add(23.21);
        list.add(24.1);
        list.add(24.55);
        list.add(25.66);

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double x) {
                return x.longValue();
            }
        };
        System.out.println(function.apply(z));


        Function<Double, Long> function1 = Double::longValue;
        System.out.println(function1.apply(y));

        for (Double list1 : list) {
            System.out.println(function1.apply(list1));
        }
    }

    private static void task4() {
        Random random = new Random();
        int upperRange = 100;
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return random.nextInt(upperRange);
            }
        };
        System.out.println(supplier.get());

        Supplier<Integer> supplier1 = () -> random.nextInt(upperRange);
        System.out.println(supplier1.get());

    }


    private static void task5() {
        System.out.println("Задача 5");
        Integer y = 5;

        Predicate<Integer> condition = x -> x > 6;
        System.out.println(condition.test(y));
        Function<Integer, Integer> ifTrue = x -> x * x;
        System.out.println(ifTrue.apply(y));
        Function<Integer, Integer> ifFalse = x -> x + x;
        System.out.println(ifFalse.apply(y));
        ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply(y));

    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}