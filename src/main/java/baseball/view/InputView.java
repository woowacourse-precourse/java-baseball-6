package baseball.view;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final InputView instance = new InputView();

    private InputView() {

    }

    public static InputView getInstance() {
        return instance;
    }

    public String readNumber() {
        return readLine();
    }

    public void readClose() {
        close();
    }

}
