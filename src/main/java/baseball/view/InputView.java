package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String PLEASE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public String readPlayerBall() {
        System.out.print(PLEASE_INPUT_NUMBER);
        return Console.readLine();
    }
}
