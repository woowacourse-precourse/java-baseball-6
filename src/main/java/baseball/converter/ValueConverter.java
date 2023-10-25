package baseball.converter;

import java.util.ArrayList;
import java.util.List;

public class ValueConverter {
    public List<Integer> convertToList(String input) {
        int number = convertToInt(input);
        return convertToList(number);
    }

    private int convertToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private List<Integer> convertToList(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        return digits;
    }
}
