package baseball.view;

import baseball.util.ConsoleMessage;
import baseball.util.Validation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputPlayerNumber() {
        OutputView.printConsoleMessage(ConsoleMessage.INPUT_PLAYER_NUMBER);
        return Validation.isValidInput(Console.readLine());
    }

    public static String inputRestartNumber() {
        OutputView.printlnConsoleMessage(ConsoleMessage.INPUT_QUIT_OR_RESTART_NUMBER);
        return Validation.isValidRestartInput(Console.readLine());
    }
}