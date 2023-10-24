package baseball;

import static baseball.utils.Constants.COUNTS;
import static baseball.utils.Constants.MAXIMUM_NUMBER;
import static baseball.utils.Constants.MINIMUM_NUMBER;
import static baseball.utils.ErrorMessage.INPUT_NOT_INTEGER_ERROR_MESSAGE;
import static baseball.utils.ErrorMessage.PLAYER_INPUT_DUPLICATION_ERROR_MESSAGE;
import static baseball.utils.ErrorMessage.PLAYER_INPUT_OUT_OF_RANGE_ERROR_MESSAGE;
import static baseball.utils.GameMessage.GAME_SUCCESS_MESSAGE;
import static baseball.utils.GameMessage.INPUT_REQUEST_MESSAGE;
import static baseball.utils.Util.convertToIntegerList;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private Computer computer = new Computer();
    private int strike;
    private int ball;

    public Player() {
    }

    public void init() {
        computer.init();
        strike = 0;
        ball = 0;
    }

    public void play() {
        List<Integer> playerNumbers;
        while (strike < COUNTS) {
            System.out.print(INPUT_REQUEST_MESSAGE);
            String playerInput = Console.readLine();
            validateNumber(playerInput);
            playerNumbers = convertToIntegerList(playerInput);
            validatePlayerNumbers(playerNumbers);

            strike = computer.checkStrikeCount(playerNumbers);
            ball = computer.checkBallCount(playerNumbers);
            printBallCount();
        }
        printGameSuccessMessage();
    }

    private void printGameSuccessMessage() {
        System.out.println(GAME_SUCCESS_MESSAGE);
    }

    private void validateNumber(String playerInput) {
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    private void validatePlayerNumbers(List<Integer> playerNumbers) {
        validateCount(playerNumbers);
        validateRange(playerNumbers);
        validateDuplicates(playerNumbers);
    }

    private void validateCount(List<Integer> playerNumbers) {
        if (playerNumbers.size() != COUNTS) {
            throw new IllegalArgumentException("");
        }
    }

    private void validateRange(List<Integer> playerNumbers) {
        boolean isInvalid = playerNumbers.stream()
                .anyMatch(number -> number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER);
        if (isInvalid) {
            throw new IllegalArgumentException(PLAYER_INPUT_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicates(List<Integer> playerNumbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int number : playerNumbers) {
            if (numberSet.contains(number)) {
                throw new IllegalArgumentException(PLAYER_INPUT_DUPLICATION_ERROR_MESSAGE);
            }
            numberSet.add(number);
        }
    }

    public void printBallCount() {
        String result = "";
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        }
        if (ball == 0 && strike > 0) {
            result = strike + "스트라이크";
        }
        if (ball > 0 && strike == 0) {
            result = ball + "볼";
        }
        if (ball > 0 && strike > 0) {
            result = ball + "볼" + " " + strike + "스트라이크";
        }
        System.out.println(result);
    }
}
