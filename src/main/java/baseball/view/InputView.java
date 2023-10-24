package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String inputNumbers() {
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String restartGame() {
        System.out.println(ASK_RESTART_MESSAGE);
        return Console.readLine();
    }
}
