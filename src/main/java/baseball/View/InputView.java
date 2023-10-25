package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PROMPT_FOR_NUMBER = "숫자를 입력해주세요 : ";
    private static final String PROMPT_FOR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String userInputMessage() {
        System.out.print(PROMPT_FOR_NUMBER);
        return Console.readLine();
    }

    public static String askRestartMessage() {
        System.out.println(PROMPT_FOR_RESTART);
        return Console.readLine();
    }
}
