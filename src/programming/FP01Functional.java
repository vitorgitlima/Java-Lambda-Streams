package programming;

import java.util.*;

public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        //  printEvenNumbersInListFunctional(numbers);
        // printEvenNumbersInListFunctional(numbers);

        //  printSquaresOfEvenNumbersInListFunctional(numbers);
        //  printCubesOfEvenNumbersInListFunctional(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

//        courses.stream()
//                .forEach(System.out::println);

//        courses.stream()
//                .filter(course -> course.contains("Spring"))
//                .forEach(System.out::println);

//        courses.stream()
//                .filter(course -> course.length() >= 4)
//                .forEach(System.out::println);
        courses.stream()
                .map(course -> course + " - " + course.length())
                .forEach(System.out::println);

    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // what to do?
        numbers.stream()
                .forEach(System.out::println); // Method Reference

    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        // what to do?
        numbers.stream()
                .filter(number -> number % 2 == 0) // Lambda Expression
                .forEach(System.out::println); // Method Reference

    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        // what to do?
        numbers.stream()
                .filter(number -> number % 2 == 0) // Lambda Expression
                .map(number -> number * number)
                .forEach(System.out::println); // Method Reference

    }

    private static void printCubesOfEvenNumbersInListFunctional(List<Integer> numbers) {
        // what to do?
        numbers.stream()
                .filter(number -> number % 2 == 0) // Lambda Expression
                .map(number -> number * number * number)
                .forEach(System.out::println); // Method Reference

    }
}
