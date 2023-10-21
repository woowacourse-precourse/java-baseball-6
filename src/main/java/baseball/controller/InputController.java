package baseball.controller;

import static baseball.Constants.END_WANT;
import static baseball.Constants.PLAY_NUMBER_DIGIT;
import static baseball.Constants.PLAY_WANT;

import baseball.converter.StringInputConverter;
import baseball.validator.NumberValidator;
import baseball.validator.ResumeValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputController {

    public static int receiveUserNumber() {
        String userInput = Console.readLine();
        NumberValidator.assertInputNumberWithLength(userInput, PLAY_NUMBER_DIGIT);

        return StringInputConverter.toInt(userInput);
    }

    public static int receiveResumeNumber() {
        String resumeInput = Console.readLine();
        ResumeValidator.assertResumeInput(resumeInput, PLAY_WANT, END_WANT);

        return StringInputConverter.toInt(resumeInput);
    }
}
