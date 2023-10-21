package baseball.controller;

import baseball.Constants;
import baseball.converter.StringInputConverter;
import baseball.validator.NumberValidator;
import baseball.validator.ResumeValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputController {

    public static int receiveUserNumber() {
        String userInput = receivePlayNumberWithLength(Constants.PLAY_NUMBER_DIGIT);

        return StringInputConverter.toInt(userInput);
    }

    private static String receivePlayNumberWithLength(final int length) {
        String userInput = Console.readLine();
        assertNumberValueWithLength(userInput, length);

        return userInput;
    }

    private static void assertNumberValueWithLength(final String inputNumber, final int expectedLength) {
        NumberValidator.assertInputNumberWithLength(inputNumber, expectedLength);
    }

    public static int receiveResumeNumberWithOption(final int restart, final int end) {
        String resumeInput = Console.readLine();
        assertResumeValue(resumeInput, restart, end);

        return StringInputConverter.toInt(resumeInput);
    }

    private static void assertResumeValue(final String resume, final int restart, final int end) {
        ResumeValidator.assertResumeInput(resume, restart, end);
    }
}
