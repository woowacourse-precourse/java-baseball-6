package baseball;

import java.util.Arrays;

public class Operator {
    public static boolean isDuplicated(int[] numbers) {
        long count = Arrays.stream(numbers).distinct().count();
        return numbers.length == count;
    }

    public static void isCorrectInput(String numbers) {
        if (numbers.length() < 3) {
            throw new IllegalArgumentException();
        }

        if (!numbers.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException();
        }

    }
}
