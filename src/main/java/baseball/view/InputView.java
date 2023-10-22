package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String PRE_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String inputPlayerNumber() {
        System.out.print(PRE_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String inputRestartNumber() {
        return Console.readLine();
    }
}
