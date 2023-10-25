package baseball.domain;

import static baseball.global.GameMessage.RESTART_GAME_OR_EXIT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class GameHandler {

    private void printRestartOrExit() {
        System.out.println(RESTART_GAME_OR_EXIT_MESSAGE.message);
    }

    public boolean isRestart() {
        printRestartOrExit();
        String input = Console.readLine().trim();
        validateNumberFormat(input);

        return input.equals("1");
    }

    private void validateNumberFormat(String input) {
        // 입력 값이 1~9 사이 3자리 숫자가 아닐 경우 판명
        if (!input.matches("^[1-2]$")) {
            throw new IllegalArgumentException();
        }
    }
}
