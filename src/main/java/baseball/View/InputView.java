package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String REQUEST_INPUT_MESSAGE  = "숫자를 입력해주세요 : ";

    public static String requestInputNumbers() {
        System.out.print(REQUEST_INPUT_MESSAGE);
        String input = Console.readLine();
        validateInput(input);
        return input;
    }
}
