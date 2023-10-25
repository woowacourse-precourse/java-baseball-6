package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PROMPT_FOR_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String PROMPT_FOR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ";

    public static String readUserInputForNumbers() {
        System.out.print(PROMPT_FOR_NUMBERS);
        return Console.readLine();
    }

    public static String readUserInputForRestart() {
        System.out.print(PROMPT_FOR_RESTART);
        return Console.readLine();
    }
}
