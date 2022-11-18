package programming;

import java.util.*;
import java.util.function.*;

public class FP03FunctionalInterfaces2 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


        // No input > Return Something
        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        //System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
      //  System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number <10 && str.length() > 5;
        };
     //   System.out.println(biPredicate.test(15, "in28minutes"));

        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return number + " " + str;
        };
       // System.out.println(biFunction.apply(15, "in28minutes"));

        BiConsumer<Integer, String> biConsumer = (s1,s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };

      biConsumer.accept(25, "in28minutes");





        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }

        };

        Function<Integer, Integer> squareFunction = x -> x * x;

        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }

        };

        Consumer<Integer> sysoutConsumer = System.out::println;

        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

//        numbers.stream()
//                .filter(isEvenPredicate2)
//                .map(squareFunction2)
//                .forEach(sysoutConsumer2);

        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

//        int sum = numbers.stream()
//                .reduce(0, sumBinaryOperator);
//
   }
}
