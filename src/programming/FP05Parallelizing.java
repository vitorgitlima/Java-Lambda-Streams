package programming;

import java.util.stream.*;

public class FP05Parallelizing {
    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        // 0, 100000000 time 190
        System.out.println(
        LongStream.range(0, 100000000).parallel().sum());

        System.out.println(System.currentTimeMillis() - time);
    }
}
