package programming;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int nOfStudents;

    public Course(String name, String category, int reviewScore, int nOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.nOfStudents = nOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getnOfStudents() {
        return nOfStudents;
    }

    public void setnOfStudents(int nOfStudents) {
        this.nOfStudents = nOfStudents;
    }

    public String toString(){
        return name + ":" + nOfStudents + ":" + reviewScore;
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 2000),
                new Course("Spring boot", "Framework", 95, 1800),
                new Course("API" , "Microservices", 97, 2200),
                new Course("Microservices", "Microservices", 96, 2500),
                new Course("FullStack", "FullStack", 91, 1400),
                new Course("AWS", "Cloud", 92, 2100),
                new Course("Azure", "Cloud", 99, 2100),
                new Course("Docker", "Cloud", 92, 2000),
                new Course("Kubernetes", "Cloud", 91, 2000)
        );

        //allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

//        System.out.println("All Match > 95: " +courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
//
//        System.out.println("None Match < 90: " +courses.stream().noneMatch(reviewScoreLessThan90Predicate));
//
//        System.out.println("Any Match < 90: " + courses.stream().anyMatch(reviewScoreLessThan90Predicate));
//
//        System.out.println("Any Match < 95: " + courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        Comparator<Course> comparingByNoOfStudentsIncreasing
                = Comparator.comparingInt(Course::getnOfStudents);

        Comparator<Course> comparingByNoOfStudentsDecreasing
                = Comparator.comparingInt(Course::getnOfStudents).reversed();

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsIncreasing)
                        .collect(Collectors.toList()));
        //[FullStack:1400:91, Spring boot:1800:95, Spring:2000:98, Docker:2000:92, Kubernetes:2000:91, AWS:2100:92, Azure:2100:99, API:2200:97, Microservices:2500:96]

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsDecreasing)
                        .collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsAndNoOfReview
                = Comparator.comparingInt(Course::getnOfStudents)
                .thenComparing(Course::getReviewScore)
                .reversed();

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndNoOfReview)
                        .collect(Collectors.toList()));

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndNoOfReview)
                        .limit(5)
                        .collect(Collectors.toList()));

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndNoOfReview)
                        .skip(3)
                        .collect(Collectors.toList()));

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndNoOfReview)
                        .skip(3)
                        .limit(5)
                        .collect(Collectors.toList()));

        System.out.println(courses);

        System.out.println(
                courses.stream()
                        .takeWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList()));
        //[Spring:2000:98, Spring boot:1800:95, API:2200:97, Microservices:2500:96]

        System.out.println(
                courses.stream()
                        .dropWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList()));
        //[FullStack:1400:91, AWS:2100:92, Azure:2100:99, Docker:2000:92, Kubernetes:2000:91]

        System.out.println(
                courses.stream()
                        .max(comparingByNoOfStudentsAndNoOfReview));
        // Optional[FullStack:1400:91]

        System.out.println(
                courses.stream()
                        .min(comparingByNoOfStudentsAndNoOfReview));
        //Optional[Microservices:2500:96]

        System.out.println(
        courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparingByNoOfStudentsAndNoOfReview)
                .orElse(new Course("Kubernetes", "Cloud", 91,2000))
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findFirst()
        ); // Optional[Spring:2000:98]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findAny()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getnOfStudents)
                        .sum()); // 8800

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getnOfStudents)
                        .average()); // OptionalDouble[2200.0]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getnOfStudents)
                        .count());

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getnOfStudents)
                        .max()); // OptionalInt[2500]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getnOfStudents)
                        .min()); // OptionalInt[2000]

        System.out.println(
        courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        //{Cloud=4, FullStack=1, Microservices=2, Framework=2}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        //{Cloud=Optional[Azure:2100:99], FullStack=Optional[FullStack:1400:91], Microservices=Optional[API:2200:97], Framework=Optional[Spring:2000:98]}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList()))));
        //{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring boot]}

    }
}
