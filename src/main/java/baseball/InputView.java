package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String BASEBALL_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String baseBallNumber() {
        System.out.print(BASEBALL_NUMBER_INPUT_MESSAGE);
        return InputValidator.validateBaseBallNumber(Console.readLine());
    }
}
