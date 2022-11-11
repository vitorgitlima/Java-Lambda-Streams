package programming;

import java.util.*;

public class FP01Exercises {

    public static void main(String[] args) {

//        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//        printOddNumbersInListFunctional(numbers);


    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        // what to do?
        numbers.stream()
                .filter(number -> number % 2 != 0) // Lambda Expression
                .forEach(System.out::println); // Method Reference

    }


}
