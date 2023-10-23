package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PLAYER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_QUIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getPlayerInput() {
        System.out.print(PLAYER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String getRestartOrQuitInput() {
        System.out.print(RESTART_OR_QUIT_MESSAGE);
        return Console.readLine();
    }
}
