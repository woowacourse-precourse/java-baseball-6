package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String number() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String restart() {
        System.out.println(RESTART_INPUT_MESSAGE);
        return Console.readLine();
    }
}
