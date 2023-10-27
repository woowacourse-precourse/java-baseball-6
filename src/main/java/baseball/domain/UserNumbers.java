package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class UserNumbers extends Numbers {

    private UserNumbers(final List<Integer> numbers) {
        super(numbers);
    }

    public static UserNumbers createUserNumbers(final String userInput) {
        NumbersValidator.validate(userInput);
        List<Integer> userNumbers = mapToIntegers(userInput);
        return new UserNumbers(userNumbers);
    }

    private static List<Integer> mapToIntegers(final String userInput) {
        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    static private class NumbersValidator {

        private static void validate(final String inputNumber) {
            validateLength(inputNumber);
            validateInteger(inputNumber);
            validateRandomNumber(inputNumber);
        }

        private static void validateLength(final String userInput) {
            if (hasInvalidLength(userInput)) {
                throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
            }
        }

        private static void validateInteger(final String userInput) {
            try {
                Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }

        private static void validateRandomNumber(final String userInput) {
            List<String> userNumbers = Arrays.asList(userInput.split(""));
            if (isDuplicated(userNumbers)) {
                throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
            }
            validateZeroNumber(userNumbers);
        }

        private static void validateZeroNumber(final List<String> userNumbers) {
            if (containsZero(userNumbers)) {
                throw new IllegalArgumentException("숫자는 1~9 사이의 숫자만 입력할 수 있습니다.");
            }
        }

        private static boolean hasInvalidLength(final String userInput) {
            return userInput.length() != NUMBER_LENGTH;
        }

        private static boolean isDuplicated(final List<String> userNumbers) {
            return userNumbers.size() != userNumbers.stream()
                    .distinct()
                    .toList()
                    .size();
        }

        private static boolean containsZero(final List<String> userNumbers) {
            return userNumbers.stream()
                    .anyMatch("0"::equals);
        }

    }
}
