package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballNumber {
    private final List<Integer> numbers;

    public BaseballNumber(String input) {
        this(convertToNumbers(input));
    }

    public BaseballNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public GameResult compare(BaseballNumber guess) {
        int strikeCount = 0;
        int matchedCount = 0;

        for (int index = 0; index < BaseballRules.NUMBER_COUNT; index++) {
            if (numbers.get(index).equals(guess.numbers.get(index))) {
                strikeCount++;
            }

            if (numbers.contains(guess.numbers.get(index))) {
                matchedCount++;
            }
        }

        int ballCount = matchedCount - strikeCount;
        return new GameResult(ballCount, strikeCount);
    }

    private static List<Integer> convertToNumbers(String input) {
        List<Integer> convertedNumbers = new ArrayList<>();

        for (char digit : input.toCharArray()) {
            if (digit < '0' || digit > '9') {
                throw new IllegalArgumentException(
                        "숫자만 입력할 수 있습니다.");
            }

            convertedNumbers.add(digit - '0');
        }

        return convertedNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != BaseballRules.NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자는 3개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < BaseballRules.MIN_NUMBER || number > BaseballRules.MAX_NUMBER) {
                throw new IllegalArgumentException(
                        "1부터 9까지의 숫자만 사용할 수 있습니다.");
            }
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != BaseballRules.NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    "숫자는 중복될 수 없습니다.");
        }
    }
}