package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 :";
    private static final String GAME_RESTART_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String readInputNumber() {
        System.out.print(INPUT_NUMBER);
        String input = Console.readLine();
        return input;
    }

    public boolean readGameRestart() {
        System.out.println(GAME_RESTART_NUMBER);
        String selectInput = Console.readLine();
        if (selectInput.equals("1")) {
            return true;
        }
        return false;
    }
}
