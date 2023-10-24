package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public List<Integer> handlingAndConvert(String input, int numberOfDigits) {
        handlingLength(input, numberOfDigits);
        List<Integer> numbers = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            handlingIsDigit(ch);
            int number = Character.getNumericValue(ch);
            handlingUniqueNumber(numbers, number);
            handlingRange(number);
            numbers.add(number);
        }
        return numbers;
    }

    private void handlingLength(String input, int numberOfDigits) {
        if (input.length() != numberOfDigits) {
            throw new IllegalArgumentException(numberOfDigits + "자리의 숫자를 입력해주세요.");
        }
    }

    private void handlingIsDigit(char ch) {
        if (!Character.isDigit(ch)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void handlingUniqueNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private void handlingRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
        }
    }
}
