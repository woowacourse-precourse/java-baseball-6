package baseball.baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public String getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        return readLine();
    }
}
