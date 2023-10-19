package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private static final int COUNT_TO_GENERATE = 3;
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;

    private Numbers computerNumbers;
    private Numbers userNumbers;

    public void generateNumber() {
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers(COUNT_TO_GENERATE);
        computerNumbers = Numbers.from(randomNumbers);
    }

    public void addUserNumber(final String inputUserNumber) {
        this.userNumbers = convertToNumbers(inputUserNumber);
    }

    public GameResult createResult() {
        List<Integer> compareResults = computerNumbers.createCompareResult(userNumbers);
        return new GameResult(compareResults.get(STRIKE_INDEX), compareResults.get(BALL_INDEX));
    }

    private Numbers convertToNumbers(final String inputUserNumber) {
        validate(inputUserNumber);
        List<Integer> userNumbers = Arrays.stream(inputUserNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return Numbers.from(userNumbers);
    }

    private void validate(final String inputUserNumber) {
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
        if (inputUserNumber.length() != COUNT_TO_GENERATE) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateRandomNumber(final String inputUserNumber) {
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
