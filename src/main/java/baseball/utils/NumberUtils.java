package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {
    public static List<Integer> getDigits(int number) {

        List<Integer> digits = new ArrayList<>();

        int digit1 = number / 100;
        int digit2 = (number % 100) / 10;
        int digit3 = number % 10;

        digits.add(digit1);
        digits.add(digit2);
        digits.add(digit3);

        return digits;
    }
}
