package baseball.view;

import static baseball.util.CommandValidator.validateRestartNumber;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readGameNumber() {
        OutputView.printInputMessage();
        return Console.readLine();
    }

    public static String readRestartOrEndGame() {
        OutputView.printRestartOrEnd();

        String input = Console.readLine();
        validateRestartNumber(input);
        return input;
    }
}
