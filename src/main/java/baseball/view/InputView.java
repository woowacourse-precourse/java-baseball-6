package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String GET_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String readUserNumber() {
        System.out.print(GET_INPUT_MESSAGE);
        return Console.readLine();
    }
}
