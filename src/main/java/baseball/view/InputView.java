package baseball.view;

import static baseball.utils.ViewMessage.INPUT_NUMBERS;
import static baseball.utils.ViewMessage.INPUT_RESTART_OR_END;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String inputNumbers() {
        System.out.print(INPUT_NUMBERS);
        return readLine().strip();
    }

    public String inputGameCommand() {
        System.out.print(INPUT_RESTART_OR_END);
        return readLine().strip();
    }
}
