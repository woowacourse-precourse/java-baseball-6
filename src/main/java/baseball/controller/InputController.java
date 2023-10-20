package baseball.controller;

import baseball.converter.StringInputConverter;
import baseball.validator.NumberValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputController {

    public static int receiveUserNumberWidthLength(final int length) {
        String userInput = receivePlayNumberWithLength(length);

        return StringInputConverter.convertStringToInt(userInput);
    }

    private static String receivePlayNumberWithLength(final int length) {
        String userInput = Console.readLine();
        assertNumberValueWithLength(userInput, length);

        return userInput;
    }

    private static void assertNumberValueWithLength(final String inputNumber, final int expectedLength) {
        NumberValidator.assertInputNumberWithLength(inputNumber, expectedLength);
    }
}
