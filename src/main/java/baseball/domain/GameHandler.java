package baseball.domain;

import static baseball.global.common.BaseballConstant.RESTART_MENU_NUMBER;
import static baseball.global.common.GameMessage.RESTART_GAME_OR_EXIT_MESSAGE;
import static baseball.global.regex.RegularExpression.RESTART_MENU_NUMBER_PATTERN;

import camp.nextstep.edu.missionutils.Console;

public class GameHandler {

    public boolean isRestart() {
        printRestartOrExit();
        String input = Console.readLine().trim();
        validateNumberFormat(input);

        return input.equals(RESTART_MENU_NUMBER);
    }

    private void printRestartOrExit() {
        System.out.print(RESTART_GAME_OR_EXIT_MESSAGE.message);
    }

    private void validateNumberFormat(String input) {
        // 입력 값이 1, 2 이외의 숫자일 경우 판명
        if (!input.matches(RESTART_MENU_NUMBER_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }
}
