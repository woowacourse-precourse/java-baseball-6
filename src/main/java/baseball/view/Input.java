package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String playerInputNumbers() {
        System.out.print(INPUT_NUMBER);
        return Console.readLine();
    }

    public static String restartOrNot() {
        System.out.println(RESTART_OR_NOT);
        return Console.readLine();
    }
}
