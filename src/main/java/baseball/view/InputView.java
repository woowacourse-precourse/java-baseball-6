package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String restartValue = "1";
    private final static String endValue = "2";
    private final static String inputUserNumberMessage = "숫자를 입력해주세요 : ";
    private final static String inputRestartValueMessage = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";

    public static String inputUserNumber() {
        System.out.print(inputUserNumberMessage);
        return Console.readLine();
    }

    public static String inputRestartValue() {
        System.out.printf(inputRestartValueMessage, restartValue, endValue);
        return Console.readLine();
    }
}
