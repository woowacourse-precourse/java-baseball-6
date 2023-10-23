package baseball.baseball;

import static baseball.common.Constant.BALL_AMOUNT;
import static baseball.common.Constant.EXIT_NUMBER_STR;
import static baseball.common.Constant.MAX_BALL_NUMBER_CHAR;
import static baseball.common.Constant.MIN_BALL_NUMBER_CHAR;
import static baseball.common.Constant.RESTART_NUMBER_STR;
import static baseball.common.Message.DUPLICATION_START_INPUT_NUMBER_MESSAGE;
import static baseball.common.Message.INVALID_END_INPUT_NUMBER_MESSAGE;
import static baseball.common.Message.INVALID_START_INPUT_LENGTH_MESSAGE;
import static baseball.common.Message.INVALID_START_INPUT_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseBallInputDevice {

    public List<Integer> startInput() {
        List<Integer> inputNumbers = new ArrayList<>();
        String inputStr = Console.readLine();
        validateStartLength(inputStr);

        for (int i = 0; i < BALL_AMOUNT; i++) {
            char inputChar = inputStr.charAt(i);
            validateStartNumber(inputChar);

            int inputNumber = Character.getNumericValue(inputChar);
            validateExistsNumber(inputNumber, inputNumbers);

            inputNumbers.add(inputNumber);
        }

        return inputNumbers;
    }

    public int endInput() {
        String inputStr = Console.readLine();
        validateExitNumber(inputStr);

        return Integer.parseInt(inputStr);
    }

    private void validateStartLength(String inputStr) {
        if (inputStr.length() != BALL_AMOUNT) {
            throw new IllegalArgumentException(INVALID_START_INPUT_LENGTH_MESSAGE);
        }
    }

    private void validateStartNumber(char inputChar) {
        if (inputChar < MIN_BALL_NUMBER_CHAR || inputChar > MAX_BALL_NUMBER_CHAR) {
            throw new IllegalArgumentException(INVALID_START_INPUT_NUMBER_MESSAGE);
        }
    }

    private void validateExistsNumber(int inputNumber, List<Integer> inputNumbers) {
        if (inputNumbers.contains(inputNumber)) {
            throw new IllegalArgumentException(DUPLICATION_START_INPUT_NUMBER_MESSAGE);
        }
    }

    private void validateExitNumber(String inputStr) {
        if (!(inputStr.equals(RESTART_NUMBER_STR) || inputStr.equals(EXIT_NUMBER_STR))) {
            throw new IllegalArgumentException(INVALID_END_INPUT_NUMBER_MESSAGE);
        }
    }

}
