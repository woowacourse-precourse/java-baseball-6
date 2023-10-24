package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {}

    public static String inputPlayerNumbers() {
        System.out.println(INPUT_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String inputRestartOption() {
        System.out.println(INPUT_RESTART_MESSAGE);
        return Console.readLine();
    }
}
