package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.util.MessageConst.STRING_INPUT_FORMAT_EXCEPTION;

public class InputView {

    public String readLine() {
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
