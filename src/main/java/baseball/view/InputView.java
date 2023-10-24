package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";

    private InputView() {}

    public static String inputPlayerNumbers() {
        System.out.println(INPUT_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String inputRestartOption(String doRestartOption, String dontRestartOption) {
        System.out.println(String.format(INPUT_RESTART_MESSAGE, doRestartOption, dontRestartOption));
        return Console.readLine();
    }
}
