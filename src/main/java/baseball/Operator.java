package baseball;

import java.util.Arrays;

public class Operator {
    public static boolean isDuplicated(int[] numbers) {
        long count = Arrays.stream(numbers).distinct().count();
        return numbers.length == count;
    }
}
