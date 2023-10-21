package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PLAYER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputPlayerNumber() {
        System.out.print(PLAYER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String inputRestartState() {
        System.out.println(GAME_RESTART_MESSAGE);
        return Console.readLine();
    }
}
