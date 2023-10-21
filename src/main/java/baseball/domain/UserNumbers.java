package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumbers extends Numbers {

    public UserNumbers(final List<Integer> numbers) {
        super(numbers);
    }

    public static UserNumbers createUserNumbers(final String userInputNumber) {
        NumbersValidator.validate(userInputNumber);
        List<Integer> userNumbers = Arrays.stream(userInputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new UserNumbers(userNumbers);
    }

    static private class NumbersValidator {

        private static void validate(final String userInputNumber) {
            validateLength(userInputNumber);
            validateInteger(userInputNumber);
            validateRandomNumber(userInputNumber);
        }

        private static void validateInteger(final String userInputNumber) {
            try {
                Integer.parseInt(userInputNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }

        private static void validateLength(final String userInputNumber) {
            if (userInputNumber.length() != NUMBER_LENGTH) {
                throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
            }
        }

        private static void validateRandomNumber(final String userInputNumber) {
            String[] userNumbers = userInputNumber.split("");
            if (isDuplicated(userNumbers)) {
                throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
            }
            validateZeroNumber(userNumbers);
        }

        private static void validateZeroNumber(final String[] userNumbers) {
            if (isZero(userNumbers)) {
                throw new IllegalArgumentException("숫자는 1~9 사이의 숫자만 입력할 수 있습니다.");
            }
        }

        private static boolean isZero(final String[] userNumbers) {
            return userNumbers[0].equals("0") || userNumbers[1].equals("0") || userNumbers[2].equals("0");
        }

        private static boolean isDuplicated(final String[] userNumbers) {
            return userNumbers[0].equals(userNumbers[1])
                    || userNumbers[1].equals(userNumbers[2])
                    || userNumbers[0].equals(userNumbers[2]);
        }

    }
}
