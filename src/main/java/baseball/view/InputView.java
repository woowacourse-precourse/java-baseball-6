package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PLAYER_NUMBER_PROMPT = "숫자를 입력해주세요 : ";
    private static final String GAME_CONTINUE_CHOICE_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getPlayerNumber() {
        System.out.print(PLAYER_NUMBER_PROMPT);
        return Console.readLine();
    }

    public String getGameContinueChoice() {
        System.out.println(GAME_CONTINUE_CHOICE_PROMPT);
        return Console.readLine();
    }
}
