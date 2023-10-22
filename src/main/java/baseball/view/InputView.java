package baseball.view;

import static baseball.model.message.ErrorMessage.INVALID_INPUT;
import static baseball.model.message.ErrorMessage.INVALID_NUMBER;
import static baseball.model.message.ErrorMessage.POSITIVE_NUMBER_NEED;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String inputPositiveNumber() {
        String inputString = Console.readLine();
        validateBlankString(inputString);
        validateNumber(inputString);
        validatePositiveNumber(inputString);
        return inputString;
    }

    private static void validateBlankString(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static void validateNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    private static void validatePositiveNumber(String string) {
        if (Integer.parseInt(string) <= 0) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_NEED.getMessage());
        }
    }

}
