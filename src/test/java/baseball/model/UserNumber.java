package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumber extends Number {

    public UserNumber(String input) {
        super(parseInput(input));
    }

    private static List<Integer> parseInput(String input) {
        if (input.length() != length) {
            throw new IllegalArgumentException("입력된 숫자들의 길이는 " + length + "여야 합니다.");
        }

        List<Integer> digits = new ArrayList<>(length);

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c < '1' || c > '9') {
                throw new IllegalArgumentException("입력된 숫자는 각각 1에서 9까지의 숫자 여야 합니다.");
            }

            int num = Character.getNumericValue(c);
            if (digits.contains(num)) {
                throw new IllegalArgumentException("입력된 숫자는 서로 달라야 합니다.");
            }
            digits.add(num);
        }

        return digits;
    }
}
