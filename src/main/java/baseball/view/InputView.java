package baseball.view;

import baseball.common.exception.input.InputException;
import baseball.dto.request.RestartAnswerRequest;
import baseball.dto.request.UserNumberRequest;
import camp.nextstep.edu.missionutils.Console;

import static baseball.common.exception.input.InputErrorCode.INVALID_INPUT_VALUE;
import static baseball.view.message.GameMessage.CONTINUE_MESSAGE;
import static baseball.view.message.GameMessage.QUESTION_MESSAGE;

public class InputView {
    public static UserNumberRequest requestUserNumber() {
        System.out.println(QUESTION_MESSAGE);
        final String arg = inputAndCheckNullOrBlank();
        return new UserNumberRequest(arg);
    }

    public static RestartAnswerRequest requestContinueAnswer() {
        System.out.println(CONTINUE_MESSAGE);
        final String arg = inputAndCheckNullOrBlank();
        return new RestartAnswerRequest(arg);
    }

    private static String inputAndCheckNullOrBlank() {
        final String arg = Console.readLine();
        checkNullOrBlank(arg);
        return arg;
    }

    private static void checkNullOrBlank(final String arg) {
        if (arg == null || arg.isBlank()) {
            throw new InputException(INVALID_INPUT_VALUE);
        }
    }
}
