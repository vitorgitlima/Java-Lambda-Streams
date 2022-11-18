package programming;

import java.util.*;
import java.util.function.*;

public class FP03MethodReferences {

    private static void print(String str){
        System.out.println(str);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream()
                .map(String::toUpperCase)
               // .map(str -> str.toUpperCase())
                .forEach(FP03MethodReferences::print);

        Supplier<String> supplier = String::new;
    }
}
