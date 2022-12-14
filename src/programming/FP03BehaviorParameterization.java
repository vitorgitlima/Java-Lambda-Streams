package programming;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class FP03BehaviorParameterization {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

      //  filterAndPrint(numbers, x -> x % 2 == 0);

    //    filterAndPrint(numbers, x -> x % 2 != 0);

        filterAndPrint(numbers, x -> x % 3 == 0);


        List<Integer> squareNumbers = mapAndCreateNewList(numbers, x -> x * x);

        List<Integer> cubeNumbers = mapAndCreateNewList(numbers, x -> x * x * x);

        List<Integer> doubleNumbers = mapAndCreateNewList(numbers, x -> x + x);

        System.out.println(doubleNumbers);

    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
