package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    private static final int NUMBER_LENGTH = 3;

    private final List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers createUserNumbers(final String inputUserNumber) {
        validate(inputUserNumber);
        List<Integer> userNumbers = Arrays.stream(inputUserNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Numbers(userNumbers);
    }

    public List<Integer> createCompareResult(final Numbers userNumbers) {
        int strikeCount = calculateStrikeCount(userNumbers);
        int ballCount = calculateBallCount(userNumbers);
        return List.of(strikeCount, ballCount);
    }

    private int calculateStrikeCount(final Numbers userNumbers) {
        return (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(i -> isSameNumber(numbers.get(i), userNumbers.numbers.get(i)))
                .count();
    }

    private int calculateBallCount(final Numbers userNumbers) {
        return (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(i -> !isSameNumber(numbers.get(i), userNumbers.numbers.get(i))
                        && numbers.contains(userNumbers.numbers.get(i)))
                .count();
    }

    private boolean isSameNumber(final int computerNumber, final int userNumber) {
        return Objects.equals(computerNumber, userNumber);
    }

    private static void validate(final String inputUserNumber) {
        validateLength(inputUserNumber);
        validateInteger(inputUserNumber);
        validateRandomNumber(inputUserNumber);
    }

    private static void validateInteger(final String inputUserNumber) {
        try {
            Integer.parseInt(inputUserNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    private static void validateLength(final String inputUserNumber) {
        if (inputUserNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
    }

    private static void validateRandomNumber(final String inputUserNumber) {
        String[] userNumbers = inputUserNumber.split("");
        if (userNumbers[0].equals(userNumbers[1])
                || userNumbers[1].equals(userNumbers[2])
                || userNumbers[0].equals(userNumbers[2])) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }
        validateZeroNumber(userNumbers);
    }

    private static void validateZeroNumber(final String[] userNumbers) {
        if (userNumbers[0].equals("0") || userNumbers[1].equals("0") || userNumbers[2].equals("0")) {
            throw new IllegalArgumentException("숫자는 1~9 사이의 숫자만 입력할 수 있습니다.");
        }
    }
}
