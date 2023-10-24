package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumber {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    private BaseballNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public BaseballNumber(String numberString) {
        validateAnswerLength(numberString);

        List<Character> numberChars = new ArrayList<>();
        for (Character c : numberString.toCharArray()) {
            numberChars.add(c);
        }
        validateAnswerNumberRange(numberChars);
        validateNumberDuplicated(numberChars);

        numbers = numberChars.stream()
                .map(n -> n-48)
                .collect(Collectors.toList());
    }

    private void validateAnswerLength(String answer) {
        if (answer.length() != 3)
            throw new IllegalArgumentException();
    }

    private void validateAnswerNumberRange(List<Character> chars) {
        for (char c : chars) {
            if (c < 49 || c > 57)
                throw new IllegalArgumentException();
        }
    }

    private void validateNumberDuplicated(List<Character> chars) {
        if (chars.size() != Set.copyOf(chars).size())
            throw new IllegalArgumentException();
    }

    public static BaseballNumber generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int n = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(n)) {
                numbers.add(n);
            }
        }
        return new BaseballNumber(numbers);
    }
}
