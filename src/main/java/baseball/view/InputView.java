package baseball.view;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String INPUT_USER_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String inputUserNumberMessage() {
        System.out.print(INPUT_USER_NUMBER_MESSAGE);
        return validateUserNumberInput();
    }

    private static String validateUserNumberInput() {
        String input = getInput();
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String inputUserRestartMessage() {
        System.out.println(INPUT_USER_RESTART_MESSAGE);
        return validateUserRestartInput();
    }

    private static String validateUserRestartInput() {
        String input = getInput();
        if (!input.equals(Constant.GAME_RESTART_NUMBER) && !input.equals(Constant.GAME_END_NUMBER)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private static String getInput() {
        return Console.readLine();
    }
}
