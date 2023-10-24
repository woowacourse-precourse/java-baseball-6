package baseball.view;

import baseball.common.exception.input.InputException;
import baseball.dto.request.UserNumberRequest;
import camp.nextstep.edu.missionutils.Console;

import static baseball.common.exception.input.InputErrorCode.INVALID_INPUT_VALUE;
import static baseball.view.message.GameMessage.QUESTION_MESSAGE;

public class InputView {
    public static UserNumberRequest requestUserNumber() {
        System.out.println(QUESTION_MESSAGE);
        final String arg = Console.readLine();
        if (arg == null || arg.isBlank()) {
            throw new InputException(INVALID_INPUT_VALUE);
        }

        return new UserNumberRequest(arg);
    }
}
