package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String IPUT_PLAYER_MASSAGE = "숫자를 입력해 주세요";
    private static final String ASK_RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputPlayerNumber() {
        System.out.println(IPUT_PLAYER_MASSAGE);
        return Console.readLine();
    }

    public String inputRestartGame() {
        System.out.println(ASK_RESTART_GAME);
        return Console.readLine();
    }
}
