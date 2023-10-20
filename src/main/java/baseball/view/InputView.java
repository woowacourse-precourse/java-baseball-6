package baseball.view;

import baseball.constant.errorMessage.UserInputNumberError;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_GAME_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String GAME_RESTART_NUMBER = "1";
    private static final String GAME_END_NUMBER = "2";

    public static String inputGameNumberMessage() {
        String input = getInput();
        validateBlankInputGameNumber(input);
        return input;
    }

    public static String inputGameRestartMessage() {
        String input = getInput();
        validateWrongGameRestartInput(input);
        validateBlankInputGameNumber(input);
        return input;
    }

    private static void validateBlankInputGameNumber(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(UserInputNumberError.USER_INPUT_BLANK_ERROR_MESSAGE);
        }
    }


    private static void validateWrongGameRestartInput(String input) {
        if (!input.equals(GAME_RESTART_NUMBER) && !input.equals(GAME_END_NUMBER)) {
            throw new IllegalArgumentException(UserInputNumberError.USER_RESTART_INPUT_ERROR_MESSAGE);
        }
    }

    private static String getInput() {
        return Console.readLine();
    }
}
