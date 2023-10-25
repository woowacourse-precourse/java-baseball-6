package baseball.game;

import baseball.error.ErrorCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballGame {

    private final int RESET = 0;

    private final List<Integer> ANSWER_NUMBERS;

    private int strike;

    private int ball;

    public BaseballGame(List<Integer> numbers) {
        this.ANSWER_NUMBERS = numbers;
        this.strike = RESET;
        this.ball = RESET;
    }

    public int tryAgainGame(String userInput) {
        validRestart(userInput);
        return Integer.parseInt(userInput);
    }

    public void tryUserInput(String userInput) {
        valid(userInput);
        List<Integer> userNumbers = convertToIntegerList(userInput);
        matching(userNumbers);

    }

    public void matching(List<Integer> userNumbers) {
        reset();
        for (Integer userNumber : userNumbers) {
            if (ANSWER_NUMBERS.contains(userNumber)) {
                checkStrike(userNumber, userNumbers);
            }
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void checkStrike(Integer userNumber, List<Integer> userNumbers) {
        if (userNumbers.indexOf(userNumber) == ANSWER_NUMBERS.indexOf(userNumber)) {
            strike++;
            return;
        }
        ball++;
    }

    private void reset() {
        strike = RESET;
        ball = RESET;
    }

    private List<Integer> convertToIntegerList(String userInput) {
        String[] arr = userInput.split("");
        return Arrays.stream(arr).map(Integer::valueOf).collect(Collectors.toList());
    }

    private void valid(String userInput) {
        validateSize(userInput);
        validateDigit(userInput);
        validateDuplication(userInput);
    }

    private static void validateSize(String userInput) {
        if (userInput.length() != GameConfig.SIZE) {
            throw new IllegalArgumentException(ErrorCode.SIZE_ERROR.message);
        }
    }

    private static void validateDigit(String userInput) {
        for (char target : userInput.toCharArray()) {
            if (!Character.isDigit(target)) {
                throw new IllegalArgumentException(ErrorCode.DIGIT_ERROR.message);
            }
        }
    }

    private static void validateDuplication(String userInput) {
        Set<Character> temp = new HashSet<>();

        for (char userNumber : userInput.toCharArray()) {
            temp.add(userNumber);
        }

        if (temp.size() != GameConfig.SIZE) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATION_ERROR.message);
        }
    }

    private void validRestart(String userInput) {
        String RestartButton = String.valueOf(GameConfig.RESTART_NUMBER);
        String EndButton = String.valueOf(GameConfig.END_NUMBER);

        if (!userInput.equals(RestartButton) && !userInput.equals(EndButton)) {
            throw new IllegalArgumentException(ErrorCode.RESTART_ERROR.message);
        }
    }
}
