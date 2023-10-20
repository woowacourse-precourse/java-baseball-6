package baseball.view;

import static baseball.util.MessageConst.NUMBER_INPUT_FORMAT_EXCEPTION;
import static baseball.util.MessageConst.STRING_INPUT_FORMAT_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private void validateNumber(String ballNumbersStr) {
        for (int i = 0; i < ballNumbersStr.length(); i++) {
            if (!Character.isDigit(ballNumbersStr.charAt(i))) {
                throw new IllegalArgumentException(NUMBER_INPUT_FORMAT_EXCEPTION);
            }
        }
    }

    public int readBallNumbers() {
        String ballNumbersStr = readLine();
        validateNumber(ballNumbersStr);
        return Integer.parseInt(ballNumbersStr);
    }

    private String readLine() {
        String input = Console.readLine().trim();
        validateIfIsBlank(input);
        return input;
    }

    private void validateIfIsBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(STRING_INPUT_FORMAT_EXCEPTION);
        }
    }
}
