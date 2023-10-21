package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String PRE_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public String inputPlayerNumber() {
        System.out.println(PRE_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String inputRestartNumber() {
        return Console.readLine();
    }
}
