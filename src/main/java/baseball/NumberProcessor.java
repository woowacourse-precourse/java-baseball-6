package baseball;

import java.util.ArrayList;
import java.util.List;

public class NumberProcessor {
    public static List<Integer> getDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        return digits;
    }

    public static int calculateStrikeCount(List<Integer> randomDigits, List<Integer> userDigits) {
        int count = 0;
        for (int i = 0; i < randomDigits.size(); i++) {
            if (randomDigits.get(i).equals(userDigits.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static int calculateBallCount(List<Integer> randomDigits, List<Integer> userDigits) {
        int count = 0;
        for (int i = 0; i < randomDigits.size(); i++) {
            if (randomDigits.contains(userDigits.get(i)) && !randomDigits.get(i).equals(userDigits.get(i))) {
                count++;
            }
        }
        return count;
    }
}