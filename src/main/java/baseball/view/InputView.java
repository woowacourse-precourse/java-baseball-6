package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String inputNumberMessage = "숫자를 입력해주세요 : ";
    private static final String inputRestartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String inputNumbers() {
        System.out.print(inputNumberMessage);
        return Console.readLine();
    }

    public static String inputRestart() {
        System.out.println(inputRestartMessage);
        return Console.readLine();
    }
}
