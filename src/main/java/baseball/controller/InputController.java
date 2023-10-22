package baseball.controller;

import static baseball.Constant.END_WANT;
import static baseball.Constant.PLAY_NUMBER_DIGIT;
import static baseball.Constant.PLAY_WANT;

import baseball.validator.NumberValidator;
import baseball.validator.ResumeValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputController {

    public static int receiveUserNumber() {
        String userInput = Console.readLine();
        NumberValidator.assertInputNumberWithLength(userInput, PLAY_NUMBER_DIGIT.getValue());

        return Integer.parseInt(userInput);
    }

    public static int receiveResumeNumber() {
        String resumeInput = Console.readLine();
        ResumeValidator.assertResumeInput(resumeInput, PLAY_WANT.getValue(), END_WANT.getValue());

        return Integer.parseInt(resumeInput);
    }
}
