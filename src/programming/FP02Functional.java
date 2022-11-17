package programming;

import java.util.*;
import java.util.stream.*;

public class FP02Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        List<Integer> squareList = squareList(numbers);

        List<Integer> evenNumbersOnly = numbers.stream()
                        .filter(x -> x%2 ==0)
                                .collect(Collectors.toList());

        //System.out.println(doubleNumbers);
        System.out.println(evenNumbersOnly); // print even Numbers Only in another list

//        int sum = addListFunctional(numbers);
//
//        System.out.println(sum);
    }

    private static List<Integer> squareList(List<Integer> numbers) {
        // 1, 5, 6
        // 1 -> 1
        // 5 -> 25
        // 6 -> 36
        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    private static int sum(int aggregate, int nextNumber){
        System.out.println(aggregate + " " + nextNumber);
        return aggregate + nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {
       return  numbers.stream()
                //.reduce(0, FP02Functional::sum);
               //.reduce(0, (x, y) -> x + y);
               .reduce(0, Integer::sum);

    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        // How to loop the numbers?
        for (int number : numbers) {
            System.out.println(number);
        }

    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        // How to loop the numbers?
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}
